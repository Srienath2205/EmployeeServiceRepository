package com.rts.tap.constants;

public class APIConstants {
	public static final String BASE_URL = "/tap";
//	public static final String FRONT_END_URL = "http://192.168.8.90:3003";
	public static final String FRONT_END_URL = "http://localhost:3000";


	// TEAM - A
	public static final String ADD_ADMIN_URL = "/createadmin";
	public static final String GET_ADMIN_URL = "/admin";

//	public static final String CROSS_ORIGIN_URL = "http://192.168.8.90:3003";
	public static final String CROSS_ORIGIN_URL = "http://localhost:3000";


	// EMPLOYEE
	public static final String ADD_EMPLOYEE_URL = "/createemployee";
	public static final String ADD_BULK_EMPLOYEE_URL = "/createbulkemployee";
	public static final String GETALL_EMPLOYEE_URL = "/getallemployee";
	public static final String GET_EMPLOYEES_BY_BUSINESS_UNIT_HEAD = "/getemployeesbybusinessunithead";
	public static final String UPDATE_EMPLOYEE_URL = "/updateemployee/{employeeId}";
	public static final String UPDATE_EMPLOYEE_COMPLETE_URL = "/updateemployeecompletely/{employeeId}";
	public static final String GET_EMPLOYEE_BY_ID = "/getEmployeeById/{employeeId}";
	public static final String GETALL_EMPLOYEE_EMAIL_URL = "/getAllEmployeeEmail";
	public static final String CHECK_EMPLOYEE_STATUS_URL = "/checkEmployeeStatus";
	public static final String UPDATE_EMPLOYEE_STATUS_URL = "/updateEmployeeStatus/{employeeId}";
	public static final String GET_EMPLOYEE_BY_EMAIL = "/checkemailexist/{email}";
	public static final String GET_EMPLOYEES_BY_RECRUITER = "/by-role-name/{roleName}";
	public static final String GET_CLIENTPARTNER_BY_BUSINESSUNITHEAD = "/getclientpartnerbybusinessunithead/{buHeadId}";
	public static final String UPDATE_EMPLOYEE_PROFILE_URL = "/updateEmployeeProfileById/{employeeId}";
	public static final String GET_EMPLOYEE_DOCUMENT_BY_ID = "/fetch-documents/byEmployee/{employeeId}";
	public static final String UPLOAD_EMPLOYEE_DOCUMENT_BY_ID = "/upload-documents/byEmployee/{employeeId}";
	public static final String Request_Reschedule_Reason_for_Interview_URL = "/rescheduleReason/{interviewId}";
	public static final String UPDATE_INTERVIEW_FEEDBACK_URL = "/updateOthers/{interviewId}";
	public static final String UPDATE_INTERVIEW_STATUS_BY_EMPLOYEE_URL = "/updateStatus/{interviewId}";
	public static final String GET_INTERVIEW_BY_EMPLOYEE_ID = "/interview/employee/{employeeId}";

	public static final String GET_ALL_EMPLOYEE_BY_ROLE = "/getEmployeesByRoles";
	

	// Fetch employee based on candidate ID
	public static final String GET_EMPLOYEE_BY_CANDIDATE_ID = "findEmployeeByCandidateId/{employeeId}";

	
	 
	
 
	
	
}
