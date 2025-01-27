/**
* Author: Team A
*
* EmployeeController class handles all employee-related operations such as adding,
* updating, retrieving, and managing employee documents.
*
* This class interacts with the EmployeeService and CandidateService to perform the necessary
* business logic and return relevant HTTP responses.
*/
 
package com.rts.tap.controller;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rts.tap.constants.APIConstants;
import com.rts.tap.constants.MessageConstants;
import com.rts.tap.dto.BulkEmployeeCreationDto;
import com.rts.tap.dto.EmployeeDto;
import com.rts.tap.model.Employee;
import com.rts.tap.service.EmployeeService;

import jakarta.validation.Valid;
 
@RestController
@RequestMapping(APIConstants.BASE_URL)
@CrossOrigin(origins = APIConstants.FRONT_END_URL)
public class EmployeeController {
 
    private final EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
 
   
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	/**
     * Adds a new employee and returns a success or failure message.
     *
     * @param employee the Employee object to be added
     * @return success or failure message
     */
	 @PostMapping(APIConstants.ADD_EMPLOYEE_URL)
	    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
	        String response = employeeService.addEmployee(employee);
	        if ("Email Exist".equals(response)) {
	            return ResponseEntity.status(HttpStatus.CONFLICT) // Status 409 Conflict
	                    .body(MessageConstants.EMAIL_EXIST);
	        } else {
	            return ResponseEntity.status(HttpStatus.CREATED) // Status 201 Created
	                    .body(MessageConstants.SUCCESS_MESSAGE);
	        }
	    }
    /**
     * Adds a bulk of employees and returns detailed response.
     *
     * @param bulkEmployee list of employee creation data
     * @return response entity with success/failure information
     */
	 @PostMapping(APIConstants.ADD_BULK_EMPLOYEE_URL)
	 public ResponseEntity<Map<String, Object>> addBulkEmployee(@RequestBody List<BulkEmployeeCreationDto> bulkEmployee) {
	     Map<String, Object> response = employeeService.addBulkEmployee(bulkEmployee);
	     return ResponseEntity.ok(response); // assuming successful processing
	 }
 
    /**
     * Retrieves all employees.
     *
     * @return list of all employees
     */
    @GetMapping(APIConstants.GETALL_EMPLOYEE_URL)
    public List<Employee> viewAllEmployee() {
        return employeeService.getAllEmployee();
    }
 
    /**
     * Retrieves employees by business unit head ID.
     *
     * @param employeeId the ID of the business unit head
     * @return list of employees under the specified business unit head
     */
    @GetMapping(APIConstants.GET_EMPLOYEES_BY_BUSINESS_UNIT_HEAD)
    public List<Employee> viewEmployeesByBusinessUnitHead(@RequestParam Long employeeId) {
        return employeeService.getEmployeesByBusinessUnitHead(employeeId);
    }
 
    /**
     * Checks if an employee exists by email.
     *
     * @param email the email of the employee
     * @return boolean indicating employee existence
     */
    @GetMapping(APIConstants.GET_EMPLOYEE_BY_EMAIL)
    public boolean getEmployeeByEmail(@PathVariable String email) {
        return employeeService.existsByEmail(email);
    }
 
    /**
     * Retrieves all employee emails.
     *
     * @return list of employee emails
     */
    @GetMapping(APIConstants.GETALL_EMPLOYEE_EMAIL_URL)
    public List<String> getAllEmployeeByEmail() {
        return employeeService.getAllEmployeeEmail();
    }
 
    /**
     * Checks the status of an employee by email.
     *
     * @param email the email of the employee
     * @return the status of the employee
     */
    @GetMapping(APIConstants.CHECK_EMPLOYEE_STATUS_URL)
    public String checkEmployeeStatus(@PathVariable String email) {
        return employeeService.checkEmployeeStatus(email);
    }
 
    /**
     * Retrieves employee by their ID.
     *
     * @param employeeId the ID of the employee
     * @return response entity with employee data
     */
    @GetMapping(APIConstants.GET_EMPLOYEE_BY_ID)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employee);
    }
 
    /**
     * Updates an employee's information.
     *
     * @param employeeId the ID of the employee to be updated
     * @param employee   the updated Employee object
     * @return success or failure message
     */
    @PutMapping(APIConstants.UPDATE_EMPLOYEE_URL)
    public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        String result = employeeService.updateEmployee(employeeId, employee);
        return ResponseEntity.ok(result); // Status 200 OK
    }
 
    @GetMapping(APIConstants.GET_ALL_EMPLOYEE_BY_ROLE)
    public List<Employee> getEmployeesByRoles() {
        return employeeService.getEmployeesByRoles();
    }
 
    /**
     * Updates the status of the employee.
     *
     * @param employeeId the employee ID
     * @param employeeDto request body containing employee status
     * @return response entity with update status
     */
    @PutMapping(APIConstants.UPDATE_EMPLOYEE_STATUS_URL)
    public ResponseEntity<String> updateEmployeeStatus(@PathVariable("employeeId") Long employeeId,
                                                       @RequestBody @Valid EmployeeDto employeeDto) {
        employeeService.updateEmployeeStatus(employeeId, employeeDto.getEmployeeStatus());
        return ResponseEntity.ok("Employee status updated successfully.");
    }
 
    /**
     * Retrieves employees by recruiter role.
     *
     * @param roleName   the role name
     * @param employeeId optional employee ID
     * @return list of employees
     */
    @GetMapping(APIConstants.GET_EMPLOYEES_BY_RECRUITER)
    public ResponseEntity<List<Employee>> getEmployeesByRecruiter(@PathVariable String roleName,
                                                                  @RequestParam(required = false) Long employeeId) {
        List<Employee> employees = employeeService.getEmployeesByRecruiter(roleName, employeeId);
        return ResponseEntity.ok(employees);
    }
 
    
    @GetMapping(APIConstants.GET_CLIENTPARTNER_BY_BUSINESSUNITHEAD)
	public ResponseEntity<List<Employee>> getClientPartnerByBUHead(@PathVariable Long buHeadId) {
	    List<Employee> employees = new ArrayList<>();
 
	    // Step 1: Get the Client Partners under the Business Unit Head
	    List<Employee> clientPartners = employeeService.getClientPartnerByBUHead(buHeadId);
	    employees.addAll(clientPartners);
 
	    // Step 2: For each Client Partner, find the Recruiting Managers
	    for (Employee clientPartner : clientPartners) {
	        List<Employee> recruitingManagers = employeeService.getRecruitingManagerByClientPartner(clientPartner.getEmployeeId());
	        employees.addAll(recruitingManagers);
 
	        // Step 3: For each Recruiting Manager, find the Recruiters
	        for (Employee recruitingManager : recruitingManagers) {
	            List<Employee> recruiters = employeeService.findRecruiterByRecruitingManager(recruitingManager.getEmployeeId());
	            employees.addAll(recruiters);
	        }
	    }
 
	    return ResponseEntity.ok(employees);
	} 

}
 