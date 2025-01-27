package com.rts.tap.serviceimplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.rts.tap.dao.BusinessUnitDao;
import com.rts.tap.dao.EmployeeDao;
import com.rts.tap.dao.LoginCredentialsDao;
import com.rts.tap.dao.RoleDao;
import com.rts.tap.dto.BulkEmployeeCreationDto;

import com.rts.tap.model.Documents;
import com.rts.tap.model.Employee;
import com.rts.tap.model.PersonalInfo;
import com.rts.tap.model.Role;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImpl1Test {

	@Mock
	private EmployeeDao employeeDao;

	@Mock
	private LoginCredentialsDao loginCredentialsDao;

	@Mock
	private BusinessUnitDao businessUnitDao;

	@Mock
	private RoleDao roleDao;

	@Mock
	private Logger logger;

	@Mock
	private GridFsTemplate gridFsTemplate;

	private List<Employee> mockEmployeeList;

	private List<BulkEmployeeCreationDto> bulkEmployeeList;

	private String testEmail;
	private String testRoleName;
	private Long testEmployeeId;
	private Long testBuHeadId;
	private PersonalInfo personalInfo;

	@InjectMocks
	private EmployeeServiceImpl1 employeeService;

	private Employee testEmployee;

	@BeforeEach
	public void setUp() {
		testEmployeeId = 1L; // Example Employee ID

		// Initialized Employee
		testEmployee = new Employee();
		testEmployee.setEmployeeEmail("test@example.com");
		testEmployee.setEmployeeName("John Doe");
		testEmployee.setEmployeeStatus(Employee.EmploymentStatus.ACTIVE);
		testEmployee.setEmployeeId(testEmployeeId);

		// Set up personal info
		personalInfo = new PersonalInfo();
		personalInfo.setFirstName("John");
		personalInfo.setLastName("Doe");
		personalInfo.setPhone("1234567890");

	}

	// Test addEmployee
	@Test
	public void testAddEmployee_EmailExists() {
		when(employeeDao.existsByEmail(testEmployee.getEmployeeEmail())).thenReturn(true);

		String result = employeeService.addEmployee(testEmployee);

		assertEquals("Email Exist", result);
		verify(employeeDao, never()).save(any());
	}

	@Test
	public void testAddEmployee_Success() {
		when(employeeDao.existsByEmail(testEmployee.getEmployeeEmail())).thenReturn(false);

		String result = employeeService.addEmployee(testEmployee);

		assertEquals("Employee Added", result);
		verify(employeeDao).save(testEmployee);
	}

	@Test
	public void testAddEmployee_Exception() {
		when(employeeDao.existsByEmail(testEmployee.getEmployeeEmail()))
				.thenThrow(new RuntimeException("Database error"));

		Exception exception = assertThrows(RuntimeException.class, () -> {
			employeeService.addEmployee(testEmployee);
		});

		assertEquals("Error occurred while adding employee", exception.getMessage());
	}

	@Test
	public void testGetAllEmployee() {
		// Arrange
		List<Employee> mockEmployees = new ArrayList<>();
		// Ensure you provide all necessary parameters for the Employee constructor
		mockEmployees.add(new Employee(1L, "john.doe@example.com", "John Doe", "New York",
				Employee.EmploymentStatus.ACTIVE, null, null, null, null, null, null, null, null, null, null, null));
		mockEmployees.add(new Employee(2L, "jane.smith@example.com", "Jane Smith", "Los Angeles",
				Employee.EmploymentStatus.ACTIVE, null, null, null, null, null, null, null, null, null, null, null));

		when(employeeDao.getAllEmployee()).thenReturn(mockEmployees); // Mock the behavior

		// Act
		List<Employee> employees = employeeService.getAllEmployee();

		// Assert
		assertNotNull(employees);
		assertEquals(2, employees.size());
		assertEquals("John Doe", employees.get(0).getEmployeeName());
		assertEquals("Jane Smith", employees.get(1).getEmployeeName());
	}

	@Test
	public void testGetEmployeesByBusinessUnitHead() {
		// Arrange
		Long businessUnitHeadId = 1L; // Assume this is the ID of the business unit head
		List<Employee> mockEmployees = new ArrayList<>();

		// You can adjust these Employee instances according to your Employee class
		mockEmployees.add(new Employee(2L, "john.doe@example.com", "John Doe", "New York",
				Employee.EmploymentStatus.ACTIVE, null, null, null, null, null, null, null, null, null, null, null));
		mockEmployees.add(new Employee(3L, "jane.smith@example.com", "Jane Smith", "Los Angeles",
				Employee.EmploymentStatus.ACTIVE, null, null, null, null, null, null, null, null, null, null, null));

		// Mock the behavior of employeeDao
		when(employeeDao.getEmployeesByBusinessUnitHead(businessUnitHeadId)).thenReturn(mockEmployees);

		// Act
		List<Employee> employees = employeeService.getEmployeesByBusinessUnitHead(businessUnitHeadId);

		// Assert
		assertNotNull(employees);
		assertEquals(2, employees.size());
		assertEquals("John Doe", employees.get(0).getEmployeeName());
		assertEquals("Jane Smith", employees.get(1).getEmployeeName());
	}

	// Test getEmployeeById
	@Test
	public void testGetEmployeeById() {
		Long employeeId = 1L;
		when(employeeDao.getEmployeeById(employeeId)).thenReturn(testEmployee);

		Employee result = employeeService.getEmployeeById(employeeId);

		assertEquals(testEmployee, result);
		verify(employeeDao).getEmployeeById(employeeId);
	}

	@Test
	public void testGetEmployeeById_NotFound() {
		Long employeeId = 1L;
		when(employeeDao.getEmployeeById(employeeId)).thenReturn(null);

		Employee result = employeeService.getEmployeeById(employeeId);

		assertNull(result);
		verify(employeeDao).getEmployeeById(employeeId);
	}

	// Test updateEmployeeStatus
	@Test
	public void testUpdateEmployeeStatus_EmployeeFound() {
		Long employeeId = 1L;
		when(employeeDao.getEmployeeById(employeeId)).thenReturn(testEmployee);

		employeeService.updateEmployeeStatus(employeeId, Employee.EmploymentStatus.INACTIVE);

		assertEquals(Employee.EmploymentStatus.INACTIVE, testEmployee.getEmployeeStatus());
		verify(employeeDao).updateEmployee(testEmployee);
	}

	@Test
	public void testUpdateEmployeeStatus_EmployeeNotFound() {
		Long employeeId = 1L;

		when(employeeDao.getEmployeeById(employeeId)).thenReturn(null);

		Exception exception = assertThrows(RuntimeException.class, () -> {
			employeeService.updateEmployeeStatus(employeeId, Employee.EmploymentStatus.INACTIVE);
		});

		assertEquals("Employee not found with ID: 1", exception.getMessage());
	}

	// Test existsByEmail
	@Test
	public void testExistsByEmail_Exists() {
		String email = "test@example.com";
		when(employeeDao.existsByEmail(email)).thenReturn(true);

		boolean result = employeeService.existsByEmail(email);

		assertTrue(result);
		verify(employeeDao).existsByEmail(email);
	}

	@Test
	public void testExistsByEmail_NotExists() {
		String email = "nonexistent@example.com";
		when(employeeDao.existsByEmail(email)).thenReturn(false);

		boolean result = employeeService.existsByEmail(email);

		assertFalse(result);
		verify(employeeDao).existsByEmail(email);
	}

	@Test
	public void testUpdateEmployee_Success() {
		// Arrange
		Long employeeId = 1L;
		Employee updatedEmployee = new Employee(null, "updated@example.com", "Updated Employee", "New Location",
				Employee.EmploymentStatus.ACTIVE, new Role(1L, "Role1", null, null), null, null, null, null, null, null,
				null, null, null, null);

		// Create a sample existing employee object
		Employee existingEmployee = new Employee(employeeId, "existing@example.com", "Existing Employee",
				"Existing Location", Employee.EmploymentStatus.ACTIVE, null, null, null, null, null, null, null, null,
				null, null, null);

		when(employeeDao.getEmployeeById(employeeId)).thenReturn(existingEmployee);
		when(roleDao.getRoleById(updatedEmployee.getRole().getRoleId())).thenReturn(updatedEmployee.getRole());
		when(businessUnitDao.getBusinessUnitByLocation(updatedEmployee.getWorkLocation())).thenReturn(null); // Mock
																												// business
																												// unit
																												// return
																												// if
																												// applicable

		// Act
		String result = employeeService.updateEmployee(employeeId, updatedEmployee);

		// Assert
		assertEquals("Employee updated successfully.", result);
		assertEquals("Updated Employee", existingEmployee.getEmployeeName());
		assertEquals("New Location", existingEmployee.getWorkLocation());
		assertEquals("updated@example.com", existingEmployee.getEmployeeEmail());
		assertNull(existingEmployee.getBusinessUnit()); // Adjust as necessary based on your logic
		verify(employeeDao).updateEmployee(existingEmployee); // Verify that the update method was called
	}

	@Test
	public void testGetEmployeesByRoles_Success() {
		// Arrange
		when(employeeDao.getEmployeesByRoles()).thenReturn(Arrays.asList(testEmployee));

		// Act
		List<Employee> result = employeeService.getEmployeesByRoles();

		// Assert
		assertNotNull(result); // Ensure the result is not null
		assertEquals(1, result.size()); // Check the size of the result
		assertEquals(testEmployee, result.get(0)); // Verify the returned employee matches the mock
		verify(employeeDao).getEmployeesByRoles(); // Verify that the DAO method was called
	}

	@Test
	public void testGetRecruitingManagerByClientPartner_Success() {
		// Arrange
		Employee manager1 = new Employee();
		manager1.setEmployeeName("Manager One");
		manager1.setEmployeeId(3L);

		Employee manager2 = new Employee();
		manager2.setEmployeeName("Manager Two");
		manager2.setEmployeeId(4L);

		List<Employee> expectedManagers = Arrays.asList(manager1, manager2);
		when(employeeDao.findRecruitingManagerByClientPartner(testBuHeadId)).thenReturn(expectedManagers);

		// Act
		List<Employee> result = employeeService.getRecruitingManagerByClientPartner(testBuHeadId);

		// Assert
		assertNotNull(result);
		assertEquals(2, result.size()); // Check the size of the result
		assertTrue(result.containsAll(expectedManagers)); // Verify that the returned managers match the expected
		verify(employeeDao).findRecruitingManagerByClientPartner(testBuHeadId); // Verify DAO method call
	}

	@Test
	public void testGetRecruitingManagerByClientPartner_EmptyList() {
		// Arrange
		when(employeeDao.findRecruitingManagerByClientPartner(testBuHeadId)).thenReturn(Collections.emptyList());

		// Act
		List<Employee> result = employeeService.getRecruitingManagerByClientPartner(testBuHeadId);

		// Assert
		assertNotNull(result);
		assertTrue(result.isEmpty()); // Verify that the result is an empty list
		verify(employeeDao).findRecruitingManagerByClientPartner(testBuHeadId); // Verify DAO method call
	}

	@Test
	public void testFindRecruiterByRecruitingManager_Success() {
		// Arrange
		Employee recruiter1 = new Employee();
		recruiter1.setEmployeeName("Recruiter One");
		recruiter1.setEmployeeId(5L);

		List<Employee> expectedRecruiters = Collections.singletonList(recruiter1);
		when(employeeDao.findRecruiterByRecruitingManager(testEmployeeId)).thenReturn(expectedRecruiters);

		// Act
		List<Employee> result = employeeService.findRecruiterByRecruitingManager(testEmployeeId);

		// Assert
		assertNotNull(result);
		assertEquals(1, result.size()); // Check the size of the result
		assertEquals(recruiter1, result.get(0)); // Verify the returned recruiter
		verify(employeeDao).findRecruiterByRecruitingManager(testEmployeeId); // Verify DAO method call
	}

	@Test
	public void testFindRecruiterByRecruitingManager_EmptyList() {
		// Arrange
		when(employeeDao.findRecruiterByRecruitingManager(testEmployeeId)).thenReturn(Collections.emptyList());

		// Act
		List<Employee> result = employeeService.findRecruiterByRecruitingManager(testEmployeeId);

		// Assert
		assertNotNull(result);
		assertTrue(result.isEmpty()); // Verify that the result is an empty list
		verify(employeeDao).findRecruiterByRecruitingManager(testEmployeeId); // Verify DAO method call
	}

	@Test
	public void testGetEmployeesByRoles_NullResponse() {
		// Arrange
		when(employeeDao.getEmployeesByRoles()).thenReturn(null);

		// Act
		List<Employee> result = employeeService.getEmployeesByRoles();

		// Assert
		assertNull(result); // Ensure the result is null
		verify(employeeDao).getEmployeesByRoles(); // Verify that the DAO method was called
	}

	@Test
	public void testGetEmployeesByRoles_EmptyList() {
		// Arrange
		when(employeeDao.getEmployeesByRoles()).thenReturn(Collections.emptyList());

		// Act
		List<Employee> result = employeeService.getEmployeesByRoles();

		// Assert
		assertNotNull(result); // Ensure the result is not null
		assertTrue(result.isEmpty()); // Verify the result is an empty list
		verify(employeeDao).getEmployeesByRoles(); // Verify that the DAO method was called
	}

	@Test
	public void testGetEmployeesByRoles_FailedMock() {
		// Arrange
		when(employeeDao.getEmployeesByRoles()).thenThrow(new RuntimeException("Mock failed"));

		// Act and Assert
		assertThrows(RuntimeException.class, employeeService::getEmployeesByRoles);
		verify(employeeDao).getEmployeesByRoles(); // Verify that the DAO method was called
	}

	@Test
	public void testAddBulkEmployee_Success() {
		// Arrange
		Map<String, Object> expectedResponse = new HashMap<>();
		expectedResponse.put("success", true);
		when(employeeDao.saveBulk(bulkEmployeeList)).thenReturn(expectedResponse);

		// Act
		Map<String, Object> result = employeeService.addBulkEmployee(bulkEmployeeList);

		// Assert
		assertNotNull(result);
		assertTrue((Boolean) result.get("success")); // Check if the response indicates success
		verify(employeeDao).saveBulk(bulkEmployeeList); // Verify DAO method call
	}

	@Test
	public void testAddBulkEmployee_Failed() {
		// Arrange
		when(employeeDao.saveBulk(bulkEmployeeList)).thenThrow(new RuntimeException("Database error"));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> employeeService.addBulkEmployee(bulkEmployeeList));
		verify(employeeDao).saveBulk(bulkEmployeeList); // Verify DAO method call
	}

	@Test
	public void testGetAllEmployeeEmail_Success() {
		// Arrange
		List<String> expectedEmails = Arrays.asList("john@example.com", "jane@example.com");
		when(employeeDao.getAllEmployeeByEmails()).thenReturn(expectedEmails);

		// Act
		List<String> result = employeeService.getAllEmployeeEmail();

		// Assert
		assertNotNull(result);
		assertEquals(2, result.size()); // Check the size of the result
		assertTrue(result.containsAll(expectedEmails)); // Verify that the returned emails match the expected
		verify(employeeDao).getAllEmployeeByEmails(); // Verify DAO method call
	}

	@Test
	public void testGetAllEmployeeEmail_EmptyList() {
		// Arrange
		when(employeeDao.getAllEmployeeByEmails()).thenReturn(Arrays.asList()); // Return an empty list

		// Act
		List<String> result = employeeService.getAllEmployeeEmail();

		// Assert
		assertNotNull(result);
		assertTrue(result.isEmpty()); // Verify that the result is an empty list
		verify(employeeDao).getAllEmployeeByEmails(); // Verify DAO method call
	}

	@Test
	public void testGetAllEmployeeEmail_NoEmailsFound() {
		// Arrange
		when(employeeDao.getAllEmployeeByEmails()).thenReturn(null); // Simulate the case where null is returned

		// Act
		List<String> result = employeeService.getAllEmployeeEmail();

		// Assert
		assertNull(result); // Expect the result to be null
		verify(employeeDao).getAllEmployeeByEmails(); // Verify DAO method call
	}

	@Test
	public void testCheckEmployeeStatus_Success() {
		// Arrange
		String expectedStatus = "Active";
		when(employeeDao.checkEmployeeStatus(testEmail)).thenReturn(expectedStatus);

		// Act
		String result = employeeService.checkEmployeeStatus(testEmail);

		// Assert
		assertEquals(expectedStatus, result); // Verify that the returned status matches the expected
		verify(employeeDao).checkEmployeeStatus(testEmail); // Verify DAO method call
	}

	@Test
	public void testGetEmployeesByRoleName_Success() {
		// Arrange
		Employee employee1 = new Employee();
		employee1.setEmployeeName("John Doe");
		employee1.setEmployeeId(1L);

		Employee employee2 = new Employee();
		employee2.setEmployeeName("Jane Doe");
		employee2.setEmployeeId(2L);

		List<Employee> expectedEmployees = Arrays.asList(employee1, employee2);
		when(employeeDao.findEmployeesByRoleName(testRoleName)).thenReturn(expectedEmployees);

		// Act
		List<Employee> result = employeeService.getEmployeesByRoleName(testRoleName);

		// Assert
		assertNotNull(result);
		assertEquals(2, result.size()); // Check the size of the result
		assertTrue(result.containsAll(expectedEmployees)); // Verify that the returned employees match the expected
		verify(employeeDao).findEmployeesByRoleName(testRoleName); // Verify DAO method call
	}

	@Test
	public void testGetEmployeesByRoleName_EmptyList() {
		// Arrange
		when(employeeDao.findEmployeesByRoleName(testRoleName)).thenReturn(Collections.emptyList());

		// Act
		List<Employee> result = employeeService.getEmployeesByRoleName(testRoleName);

		// Assert
		assertNotNull(result);
		assertTrue(result.isEmpty()); // Verify that the result is an empty list
		verify(employeeDao).findEmployeesByRoleName(testRoleName); // Verify DAO method call
	}

	@Test
	public void testGetEmployeesByRecruiter_Success() {
		// Arrange
		Employee employee1 = new Employee();
		employee1.setEmployeeName("John Doe");
		employee1.setEmployeeId(1L);

		List<Employee> expectedEmployees = Collections.singletonList(employee1);
		when(employeeDao.findEmployeesByRecruiter(testRoleName, testEmployeeId)).thenReturn(expectedEmployees);

		// Act
		List<Employee> result = employeeService.getEmployeesByRecruiter(testRoleName, testEmployeeId);

		// Assert
		assertNotNull(result);
		assertEquals(1, result.size()); // Check the size of the result
		assertEquals(employee1, result.get(0)); // Verify the returned employee
		verify(employeeDao).findEmployeesByRecruiter(testRoleName, testEmployeeId); // Verify DAO method call
	}

	@Test
	public void testGetClientPartnerByBUHead_Success() {
		// Arrange
		Employee employee1 = new Employee();
		employee1.setEmployeeName("Client Partner");
		employee1.setEmployeeId(1L);

		List<Employee> expectedEmployees = Collections.singletonList(employee1);
		when(employeeDao.findClientPartnerByBUHead(testBuHeadId)).thenReturn(expectedEmployees);

		// Act
		List<Employee> result = employeeService.getClientPartnerByBUHead(testBuHeadId);

		// Assert
		assertNotNull(result);
		assertEquals(1, result.size()); // Check the size of the result
		assertEquals(employee1, result.get(0)); // Verify the returned employee
		verify(employeeDao).findClientPartnerByBUHead(testBuHeadId); // Verify DAO method call
	}

	@Test
	public void testUpdateEmployeeStatus_UpdateToSameStatus() {
		Long employeeId = 1L;
		when(employeeDao.getEmployeeById(employeeId)).thenReturn(testEmployee);

		employeeService.updateEmployeeStatus(employeeId, Employee.EmploymentStatus.ACTIVE); // Already active

		assertEquals(Employee.EmploymentStatus.ACTIVE, testEmployee.getEmployeeStatus()); // Status should remain the
																							// same
		verify(employeeDao, never()).updateEmployee(testEmployee); // No update should occur
	}

}