
package com.rts.tap.serviceimplementation;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rts.tap.dao.BusinessUnitDao;
import com.rts.tap.dao.EmployeeDao;
import com.rts.tap.dao.LoginCredentialsDao;
import com.rts.tap.dao.RoleDao;
import com.rts.tap.dto.BulkEmployeeCreationDto;
import com.rts.tap.exception.EmployeeNotFoundException;
import com.rts.tap.model.Employee;
import com.rts.tap.model.Employee.EmploymentStatus;
import com.rts.tap.model.LoginCredentials;
import com.rts.tap.service.EmployeeService;

@Service
public class EmployeeServiceImpl1 implements EmployeeService {

	private EmployeeDao employeeDao;

	private LoginCredentialsDao loginCredentialsDao;

	private BusinessUnitDao businessUnitDao;

	private RoleDao roleDao;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl1.class);

	public EmployeeServiceImpl1(EmployeeDao employeeDao, LoginCredentialsDao loginCredentialsDao,
			BusinessUnitDao businessUnitDao, RoleDao roleDao) {
		super();
		this.employeeDao = employeeDao;
		this.loginCredentialsDao = loginCredentialsDao;
		this.businessUnitDao = businessUnitDao;
		this.roleDao = roleDao;
	}

	@Override
	public String addEmployee(Employee employee) {
		try {
			// Check if email already exists
			if (employeeDao.existsByEmail(employee.getEmployeeEmail())) {
				logger.warn("Email already exists: {}", employee.getEmployeeEmail());
				return "Email Exist";
			} else {
				employeeDao.save(employee);
				logger.info("Employee added: {}", employee);
				return "Employee Added";
			}
		} catch (Exception e) {
			logger.error("Error occurred while adding employee: {}", e.getMessage(), e);
			throw new RuntimeException("Error occurred while adding employee", e);
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public List<Employee> getEmployeesByBusinessUnitHead(Long employeeId) {
		return employeeDao.getEmployeesByBusinessUnitHead(employeeId);
	}

	@Override
	public String updateEmployee(Long employeeId, Employee updatedEmployee) {
	    Employee existingEmployee = employeeDao.getEmployeeById(employeeId);
	    if (existingEmployee != null) {
	        logger.info("Updating employee with ID: {}", employeeId);
	        existingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
	        existingEmployee.setWorkLocation(updatedEmployee.getWorkLocation());
	        existingEmployee.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
	        existingEmployee.setManagerId(updatedEmployee.getManagerId());
	        existingEmployee.setRole(roleDao.getRoleById(updatedEmployee.getRole().getRoleId()));
	        existingEmployee.setBusinessUnit(businessUnitDao.getBusinessUnitByLocation(updatedEmployee.getWorkLocation()));
	        employeeDao.updateEmployee(existingEmployee);
	        return "Employee updated successfully.";
	    } else {
	        throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
	    }
	}
	
	@Override
	public void addLoginCredentials(LoginCredentials loginCredentials) {
		loginCredentialsDao.save(loginCredentials);
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	// code by Velan
	@Override
	public List<Employee> getEmployeesByRoles() {
		return employeeDao.getEmployeesByRoles();
	}

	@Override
	public Map<String, Object> addBulkEmployee(List<BulkEmployeeCreationDto> bulkEmployee) {
	    try {
	        return employeeDao.saveBulk(bulkEmployee);
	    } catch (Exception e) {
	        logger.error("Error while adding bulk employees: {}", e.getMessage(), e);
	        throw new RuntimeException("Failed to add employees. Error: " + e.getMessage(), e);
	    }
	}
	@Override
	public List<String> getAllEmployeeEmail() {
		return employeeDao.getAllEmployeeByEmails();
	}

	@Override
	public void updateEmployeeStatus(Long employeeId, EmploymentStatus status) {
	    Employee employee = employeeDao.getEmployeeById(employeeId);
	    if (employee != null) {
	        if (!employee.getEmployeeStatus().equals(status)) {
	            employee.setEmployeeStatus(status);
	            employeeDao.updateEmployee(employee);
	            logger.info("Updated employee status for ID {} to {}", employeeId, status);
	        } else {
	            logger.warn("Employee status for ID {} is already {}", employeeId, status);
	        }
	    } else {
	        throw new RuntimeException("Employee not found with ID: " + employeeId);
	    }
	}

	@Override
	public String checkEmployeeStatus(String email) {
		return employeeDao.checkEmployeeStatus(email);
	}

	@Override
	public boolean existsByEmail(String email) {
		return employeeDao.existsByEmail(email);
	}

	@Override
	public List<Employee> getEmployeesByRoleName(String roleName) {
		return employeeDao.findEmployeesByRoleName(roleName);
	}

	@Override
	public List<Employee> getEmployeesByRecruiter(String roleName, Long employeeId) {
		return employeeDao.findEmployeesByRecruiter(roleName, employeeId);
	}

	@Override
	public List<Employee> getClientPartnerByBUHead(Long buHeadId) {
		return employeeDao.findClientPartnerByBUHead(buHeadId);
	}

	@Override
	public List<Employee> getRecruitingManagerByClientPartner(Long buHeadId) {
		return employeeDao.findRecruitingManagerByClientPartner(buHeadId);
	}

	@Override
	public List<Employee> findRecruiterByRecruitingManager(Long employeeId) {
		return employeeDao.findRecruiterByRecruitingManager(employeeId);
	}

}
