package com.rts.tap.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.rts.tap.dto.BulkEmployeeCreationDto;
import com.rts.tap.model.Documents;
import com.rts.tap.model.Employee;


public interface EmployeeDao {

	void save(Employee employee);
	Map<String, Object> saveBulk(List<BulkEmployeeCreationDto> bulkEmployee);
	List<String> getAllEmployeeByEmails();
	List<Employee> getAllEmployee();
	List<Employee> getEmployeesByBusinessUnitHead(Long employeeId);
	void updateEmployee(Employee employee);
	List<Employee> findEmployeesByRoleName(String roleName);
	
	Employee getEmployeeById(Long employeeId);
	String checkEmployeeStatus(String email);
	boolean existsByEmail(String employeeEmail);
	
	
	//Code By velan
	List<Employee> getEmployeesByRoles();
	

	Employee findEmployeeByEmail(String email);
	Optional<Employee> findByempId(Long employeeId);
	List<Employee> findEmployeesByRecruiter(String roleName, Long employeeId);
	
	// Bu Head Hierarchy
	List<Employee> findClientPartnerByBUHead(Long buHeadId);
	List<Employee> findRecruitingManagerByClientPartner(Long buHeadId);
	List<Employee> findRecruiterByRecruitingManager(Long employeeId);
	void saveComplete(Employee existingEmployee);
//	Employee findByCandidateId(Long candidateId);
	Documents saveDocuments(Documents document);
	public List<Long> emplgetAllDocumentIdByEmployeeId(Long employeeId);
	Documents findByDocumentId(Long documentId);
	void saveProfile(Employee employee);
}

