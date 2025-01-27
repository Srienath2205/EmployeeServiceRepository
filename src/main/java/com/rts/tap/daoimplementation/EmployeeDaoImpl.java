package com.rts.tap.daoimplementation;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.rts.tap.dao.BusinessUnitDao;
import com.rts.tap.dao.EmployeeDao;
import com.rts.tap.dao.LoginCredentialsDao;
import com.rts.tap.dao.RoleDao;
import com.rts.tap.dto.BulkEmployeeCreationDto;
import com.rts.tap.dto.BulkEmployeeUploadResponseDto;
import com.rts.tap.model.BusinessUnit;
import com.rts.tap.model.Documents;
import com.rts.tap.model.Employee;
import com.rts.tap.model.Employee.EmploymentStatus;
import com.rts.tap.model.LoginCredentials;
import com.rts.tap.model.Role;
import com.rts.tap.service.EmailService1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;

	private RoleDao roleDao;

	private BusinessUnitDao businessUnitDao;

	private EmailService1 emailService;

	private LoginCredentialsDao loginCredentialsDao;

	public EmployeeDaoImpl(EntityManager entityManager, RoleDao roleDao, BusinessUnitDao businessUnitDao,
			EmailService1 emailService, LoginCredentialsDao loginCredentialsDao) {
		super();
		this.entityManager = entityManager;
		this.roleDao = roleDao;
		this.businessUnitDao = businessUnitDao;
		this.emailService = emailService;
		this.loginCredentialsDao = loginCredentialsDao;
	}

	@Override // For Adding an Employee
	public void save(Employee employee) {

		Employee newEmployee = new Employee();

		newEmployee.setEmployeeEmail(employee.getEmployeeEmail());
		newEmployee.setEmployeeStatus(EmploymentStatus.ACTIVE);
		newEmployee.setEmployeeName(employee.getEmployeeName());
		newEmployee.setWorkLocation(employee.getWorkLocation());
		newEmployee.setManagerId(employee.getManagerId());
		newEmployee.setCandidateId(employee.getCandidateId());
		newEmployee.setBusinessUnit(businessUnitDao.getBusinessUnitByLocation(employee.getWorkLocation()));
		newEmployee.setRole(roleDao.getRoleById(employee.getRole().getRoleId()));

		LoginCredentials loginCredentials = new LoginCredentials();
		String password = generateRandomPassword(8); // Generate a random password

		loginCredentials.setUserEmail(employee.getEmployeeEmail());
		loginCredentials.setPasswordHash(password); // Save the password hash
		loginCredentials.setCreatedDate(LocalDateTime.now());
		loginCredentials.setUpdatedDate(LocalDateTime.now());
		loginCredentials.setEmployee(newEmployee);
		loginCredentials.setIsPasswordChange("NO");
		loginCredentialsDao.save(loginCredentials);

		emailService.sendLoginCredentials(employee.getEmployeeEmail(), employee.getEmployeeEmail(), password);

		entityManager.persist(newEmployee);

	}

	private String generateRandomPassword(int length) {
		// Define the characters to be used in the password
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters = "!@#$%^&*()-_=+<>?";

		// Combine all characters
		String allCharacters = upperCase + lowerCase + numbers + specialCharacters;

		// Use SecureRandom for better randomness
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder(length);

		// Ensure that the password contains at least one upper case, one lower case,
		// one number, and one special character
		password.append(upperCase.charAt(random.nextInt(upperCase.length())));
		password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
		password.append(numbers.charAt(random.nextInt(numbers.length())));
		password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

		// Fill the rest of the password length with random characters
		for (int i = 4; i < length; i++) {
			password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
		}

		// Shuffle the password to avoid any predictable patterns
		return shuffleString(password.toString());
	}

	// Helper method to shuffle the characters in the password
	private String shuffleString(String input) {
		char[] characters = input.toCharArray();
		SecureRandom random = new SecureRandom();

		for (int i = 0; i < characters.length; i++) {
			int randomIndex = random.nextInt(characters.length);
			// Swap characters
			char temp = characters[i];
			characters[i] = characters[randomIndex];
			characters[randomIndex] = temp;
		}

		return new String(characters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		String hql = "from Employee";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByBusinessUnitHead(Long employeeId) {
		// First, get the BusinessUnit of the given employeeId
		String businessUnitHQL = "SELECT e.businessUnit FROM Employee e WHERE e.employeeId = :employeeId";
		BusinessUnit businessUnit = (BusinessUnit) entityManager.createQuery(businessUnitHQL)
				.setParameter("employeeId", employeeId).getSingleResult();

		// Now query all employees in that BusinessUnit
		String hql = "FROM Employee e WHERE e.businessUnit.businessunitId = :businessUnitId";
		Query query = entityManager.createQuery(hql);
		query.setParameter("businessUnitId", businessUnit.getBusinessunitId());
		return query.getResultList();
	}

	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {

		System.out.println(id);
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null");
		}

		Employee employee = entityManager.find(Employee.class, id);

		// Return null if the employee is not found
		return employee; // This could return null if not found
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllEmployeeByEmails() {
		String hql = "select e.employeeEmail from Employee e";
		Query query = entityManager.createQuery(hql, String.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> saveBulk(List<BulkEmployeeCreationDto> bulkEmployee) {

		// Get the set of existing employee emails from the database

		Set<String> existingEmployeeEmails = new HashSet<>(getAllEmployeeByEmails());

		// Create lists for tracking the result of bulk insertion
		List<BulkEmployeeCreationDto> insertedEmployees = new ArrayList<>();
		List<BulkEmployeeCreationDto> skippedEmployees = new ArrayList<>();
		List<BulkEmployeeCreationDto> failedEmployees = new ArrayList<>();

		// Process each employee in the bulk list
		for (BulkEmployeeCreationDto employee : bulkEmployee) {
			try {
				// Check if the employee email already exists in the system
				if (existingEmployeeEmails.contains(employee.getEmployeeEmail())) {
					// If the employee already exists, mark as "failed" due to the existing email
					skippedEmployees.add(employee);
					continue; // Skip further processing for this employee
				}

				// Add employee to the "newEmployees" list if email does not exist
				Map<String, Object> response = insertAndSendEmail(Collections.singletonList(employee));

				// Add to the relevant lists based on the operation result
				insertedEmployees.addAll((List<BulkEmployeeCreationDto>) response.get("inserted"));
				skippedEmployees.addAll((List<BulkEmployeeCreationDto>) response.get("skipped"));
				failedEmployees.addAll((List<BulkEmployeeCreationDto>) response.get("failed"));

			} catch (Exception e) {
				// Log the exception and add the employee to the failed list in case of error
				System.err.println("Error processing employee with email: " + employee.getEmployeeEmail());
				e.printStackTrace();
				failedEmployees.add(employee); // Add the employee object to the failed list
			}
		}

		// Construct the final response with details about the bulk operation
		Map<String, Object> result = new HashMap<>();
		result.put("response", new BulkEmployeeUploadResponseDto(insertedEmployees, skippedEmployees, failedEmployees,
				bulkEmployee.size(), insertedEmployees.size(), skippedEmployees.size(), failedEmployees.size()));

		return result;
	}

	@Async
	@Transactional
	public Map<String, Object> insertAndSendEmail(List<BulkEmployeeCreationDto> newEmployees) {

		Map<String, Object> response = new HashMap<>();

		List<BulkEmployeeCreationDto> insertedEmployees = new ArrayList<>();
		List<BulkEmployeeCreationDto> skippedEmployees = new ArrayList<>();
		List<BulkEmployeeCreationDto> failedEmployees = new ArrayList<>();

		for (BulkEmployeeCreationDto employee : newEmployees) {
			try {
				// Validate required fields before proceeding
				if (employee.getEmployeeEmail() == null || employee.getEmployeeEmail().isEmpty()
						|| employee.getEmployeeName() == null || employee.getEmployeeName().isEmpty()
						|| employee.getManagerEmail() == null || employee.getManagerEmail().isEmpty()
						|| employee.getRole() == null || employee.getRole().isEmpty()
						|| employee.getWorkLocation() == null || employee.getWorkLocation().isEmpty()) {

					// Add detailed error message for missing fields
					employee.setErrorMessage("Missing required fields: Email, Name, Manager, Role or Work Location");
					failedEmployees.add(employee);
					continue; // Skip this employee
				}

				// Create a new Employee entity from the DTO
				Employee emp = new Employee();
				emp.setEmployeeEmail(employee.getEmployeeEmail());
				emp.setEmployeeName(employee.getEmployeeName());
				emp.setEmployeeStatus(EmploymentStatus.ACTIVE);

				// Find the manager based on email
				Employee manager = findEmployeeByEmail(employee.getManagerEmail());
				System.out.println(employee.getManagerEmail());

				if (manager == null) {
					employee.setErrorMessage("Manager not found with email: " + employee.getManagerEmail());
					failedEmployees.add(employee); // Add to failed list with specific error
					continue;
				}

				emp.setManagerId(manager.getEmployeeId());

				// Find the role based on the role name
				Role role = roleDao.getRoleByName(employee.getRole());
				if (role == null) {
					employee.setErrorMessage("Role not found with name: " + employee.getRole());
					failedEmployees.add(employee); // Add to failed list with specific error
					continue;
				}
				emp.setRole(role);

				// Find the business unit based on the work location
				BusinessUnit businessUnit = businessUnitDao.getBusinessUnitByLocation(employee.getWorkLocation());
				if (businessUnit == null) {
					employee.setErrorMessage("Business unit not found for location: " + employee.getWorkLocation());
					failedEmployees.add(employee); // Add to failed list with specific error
					continue;
				}
				emp.setBusinessUnit(businessUnit);
				emp.setWorkLocation(employee.getWorkLocation());

				// Check if the employee already exists before persisting
				if (existsByEmail(emp.getEmployeeEmail())) {
					// Provide a specific message for skipped employees (already exists)
					employee.setErrorMessage("Employee already exists with email: " + emp.getEmployeeEmail());
					skippedEmployees.add(employee); // Add to skipped list if already exists
					continue; // Skip this employee
				}

				// Persist the new employee in the database
				entityManager.persist(emp);

				// Create login credentials for the new employee
				LoginCredentials loginCredentials = new LoginCredentials();
				loginCredentials.setUserEmail(emp.getEmployeeEmail());
				String password = generateRandomPassword(8);
				loginCredentials.setPasswordHash(password);
				loginCredentials.setCreatedDate(LocalDateTime.now());
				loginCredentials.setUpdatedDate(LocalDateTime.now());
				loginCredentials.setEmployee(emp);

				// Save the login credentials
				loginCredentialsDao.save(loginCredentials);

				// Send login credentials via email
				try {
					emailService.sendLoginCredentials(emp.getEmployeeEmail(), emp.getEmployeeEmail(), password);
				} catch (Exception emailEx) {
					employee.setErrorMessage(
							"Error sending email to: " + emp.getEmployeeEmail() + " - " + emailEx.getMessage());
					failedEmployees.add(employee); // Add to failed list if email sending fails
					continue;
				}

				// Add to the inserted list after successful email sending
				insertedEmployees.add(employee);

			} catch (Exception e) {
				// Handle any unexpected errors
				employee.setErrorMessage("Unexpected error processing employee: " + e.getMessage());
				failedEmployees.add(employee); // Add to failed list with the error message
			}
		}

		// Build the response with details about the inserted, skipped, and failed
		// employees
		response.put("inserted", insertedEmployees);
		response.put("skipped", skippedEmployees);
		response.put("failed", failedEmployees);
		response.put("totalProcessed", newEmployees.size());
		response.put("totalInserted", insertedEmployees.size());
		response.put("totalSkipped", skippedEmployees.size());
		response.put("totalFailed", failedEmployees.size());

		return response;
	}

	@Override
	public Employee findEmployeeByEmail(String email) {
		String hql = "FROM Employee WHERE employeeEmail = :email";
		TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public boolean existsByEmail(String email) {
		try {
			System.out.println("Checking if employee with email " + email + " exists in the database.");

			// Build the query
			String query = "SELECT COUNT(e) > 0 FROM Employee e WHERE e.employeeEmail = :email";
			Boolean exists = entityManager.createQuery(query, Boolean.class).setParameter("email", email)
					.getSingleResult();

			// Log the query result
			System.out.println("Query result for email " + email + ": " + exists);

			// Return the result (false if exists is null, or true if exists is not null and
			// true)
			return exists != null && exists;

		} catch (Exception e) {
			// Log any exceptions
			System.err.println("Error occurred while checking if employee exists with email: " + email);
			e.printStackTrace(); // Print the stack trace for debugging
			return false; // Return false in case of error
		}
	}

	@Override
	public Optional<Employee> findByempId(Long employeeId) {
		try {
			// Fetch the employee by ID using the entityManager's find method
			Employee employee = entityManager.find(Employee.class, employeeId);

			// Return the employee wrapped in Optional, or Optional.empty() if not found
			return Optional.ofNullable(employee);
		} catch (Exception e) {
			// Log any exceptions that might occur (optional)
			System.err.println("Error fetching employee with ID: " + employeeId);
			e.printStackTrace();
			return Optional.empty(); // Return Optional.empty() if there's an error
		}
	}

	@Override
	public String checkEmployeeStatus(String email) {
		String hql = "FROM Employee WHERE employeeEmail = :email";
		TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
		query.setParameter("email", email);
		try {
			Employee employee = query.getSingleResult();
			EmploymentStatus status = employee.getEmployeeStatus();

			if (status == EmploymentStatus.ACTIVE) {
				return "ACTIVE";
			} else if (status == EmploymentStatus.INACTIVE) {
				return "INACTIVE";
			} else {
				return "Status unknown";
			}
		} catch (NoResultException e) {
			return "Employee not found";
		}
	}

	@Override
	public List<Employee> findEmployeesByRoleName(String roleName) {
		String hql = "SELECT e FROM Employee e WHERE e.role.roleName = :roleName";
		TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
		query.setParameter("roleName", roleName);
		return query.getResultList();
	}

	@Override
	public List<Employee> findEmployeesByRecruiter(String roleName, Long employeeId) {
		// Step 1: Retrieve the employee with the given employeeId
		Employee employee = entityManager.find(Employee.class, employeeId);

		// Check if the employee exists
		if (employee == null) {
			return Collections.emptyList(); // or throw an exception if you prefer
		}

		// Step 2: Get the business unit ID from the retrieved employee
		Long businessUnitId = employee.getBusinessUnit().getBusinessunitId(); // Assuming there is a method to get the
																				// business unit ID

		if (businessUnitId != null) {
			// Step 3: Query to find all employees in the same business unit with the
			// specified roleName
			TypedQuery<Employee> query = entityManager.createQuery(
					"SELECT e FROM Employee e WHERE e.businessUnit.businessunitId = :businessUnitId AND e.role.roleName = :roleName",
					Employee.class);

			query.setParameter("businessUnitId", businessUnitId);
			query.setParameter("roleName", roleName);
			return query.getResultList();
		} else {
			System.out.println("No ID Found!");
			return null;
		}
	}

	// Code By velan
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByRoles() {
		String hql = "select emp from Employee emp where emp.role.roleName = 'Recruiter Manager' or emp.role.roleName = 'Client Partner'";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	// Bu Head Hierarchy
	public List<Employee> findEmployeesByBUHead(Long buHeadId) {
		String hql = "select emp from Employee emp " + "left join fetch emp.businessUnit bu "
				+ "left join fetch emp.manager m " + "where bu.managerId = :buHeadId "
				+ "and (m.role.name = 'ClientPartner' " + "     or m.role.name = 'RecruitingManager' "
				+ "     or m.role.name = 'Recruiter')";
		TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
		query.setParameter("buHeadId", buHeadId);
		return query.getResultList();
	}

	@Override
	public List<Employee> findClientPartnerByBUHead(Long buHeadId) {
		String hql = "select emp from Employee emp where emp.managerId = :buHeadId and emp.role.roleName = 'Client Partner'";
		TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
		query.setParameter("buHeadId", buHeadId);
		return query.getResultList();
	}

	@Override
	public List<Employee> findRecruitingManagerByClientPartner(Long clientPartnerId) {
		String hql = "select emp from Employee emp where emp.managerId = :clientPartnerId and emp.role.roleName = 'Recruiting Manager'";
		TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
		query.setParameter("clientPartnerId", clientPartnerId);
		return query.getResultList();
	}

	@Override
	public List<Employee> findRecruiterByRecruitingManager(Long recruitingManagerId) {
		String hql = "select emp from Employee emp where emp.managerId = :recruitingManagerId and emp.role.roleName = 'Recruiter'";
		TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
		query.setParameter("recruitingManagerId", recruitingManagerId);
		return query.getResultList();
	}

	@Override
	public void saveComplete(Employee employee) {
		System.out.println(employee.getEmployeeId());
		if (employee.getEmployeeId() != null) {
			// Update existing employee
			entityManager.merge(employee);
			System.out.println("Updated employee with ID: " + employee.getEmployeeId());
		} else {
			// Save new employee
			entityManager.persist(employee);
			System.out.println("Inserted new employee: " + employee);
		}
	}

	@Override

	public Documents saveDocuments(Documents document) {
		entityManager.persist(document);
		return document;
	}

	@Override
	public List<Long> emplgetAllDocumentIdByEmployeeId(Long employeeId) {
		System.out.println("DAO");
		// Find the Employee entity based on employeeId
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null) {
			// Get the list of Documents for the found employee and extract their IDs
			return employee.getDocuments().stream().map(Documents::getDocumentsId) // Extract the documentsId from each
																					// Documents instance
					.collect(Collectors.toList());
		}
		return List.of(); // Return an empty list if the employee was not found
	}

	@Override
	public Documents findByDocumentId(Long documentId) {
		if (documentId == null) {
			return null; 
		}

		TypedQuery<Documents> query = entityManager
				.createQuery("SELECT d FROM Documents d WHERE d.documentsId = :documentId", Documents.class);
		query.setParameter("documentId", documentId);

		return query.getResultStream().findFirst().orElse(null); // returns null if no result found
	}

	@Override
	public void saveProfile(Employee employee) {
		entityManager.merge(employee);

	}

}
