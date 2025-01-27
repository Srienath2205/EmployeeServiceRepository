

package com.rts.tap.constants;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

public class MessageConstants {
	public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MessageConstants.class);

	public static final String SUCCESS_MESSAGE = "Success";
	public static final String FAILURE_MESSAGE = "Failure";
	public static final String LOGIN_SUCCESS = "Login Success";
	public static final String LOGIN_NOT_FOUND = "Login credentials not found";
	public static final String OTP_SENT = "OTP sent to your email.";
	public static final String OTP_VERIFY = "OTP Verified";
	public static final String OTP_RESENT = "OTP Resend";
	public static final String HELLO_WORLD = "Hello world";
	public static final String EMAIL_EXIST = "Email Exist";
	public static final String EMPLOYEE_STATUS = "Employee INACTIVE";

	public static final String ORGIN = "http://localhost:3000";
	
	// TEAM - B
	
	// Client

	public static final String CLIENT_CREATED_SUCCESS = "Client created successfully!";
	public static final String CLIENT_UPDATED_SUCCESS = "Client updated successfully!";
	public static final String CLIENT_DELETED_SUCCESS = "Client deleted successfully!";
	public static final String CLIENT_FOUND_SUCCESS = "Client retrieved successfully!";
	public static final String CLIENT_LIST_RETRIEVED_SUCCESS = "All clients retrieved successfully!";

	public static final String CLIENT_NOT_FOUND = "Client not found!";
	public static final String CLIENT_CREATION_FAILED = "Failed to create client!";
	public static final String CLIENT_UPDATE_FAILED = "Failed to update client!";
	public static final String CLIENT_DELETION_FAILED = "Failed to delete client!";
	
	public static final String SUCCESSFULLY_UPDATING_CLIENT_DETAILS = "Client Details Updated Successfully";
	public static final String FAILED_UPDATING_CLIENT_DETAILS = "Failed to update Client Details";
	
	// Job Description
		
	public static final String JOB_DESCRIPTION_ADDED_SUCCESS = "New Job Description Added Successfully";
	public static final String JOB_DESCRIPTION_ADDED_FAILED = "Failed to Add Job Description";
	public static final String JOB_DESCRIPTION_NOT_FOUND = "No such Job Description is Found";
	public static final String JOB_DESCRIPTION_UPDATE_SUCCESS = "Job Description Updated Successfully";
	public static final String JOB_DESCRIPTION_UPDATE_FAILED = "Failed to Update Job Description";
	
	// MRF
	
	public static final String SUCCESSFULLY_SEND_FOR_APPROVAL = "Sent to BU Head Successfully";
	public static final String FAILED_SEND_FOR_APPROVAL = "Failed to Send for Approval to BU Head";

	public static final String SUCCESSFULLY_UPDATING_SOW_DOCUMENT = "SOW Document Updated Successfully";
	public static final String FAILED_UPDATING_SOW_DOCUMENT = "Failed to Update SOW Document";
	

	// Other Messages
	public static final String INVALID_CLIENT_DATA = "Invalid client data provided!";

	public static final String RECRUITMENT_PROCESS_ADDED = "Recruitment Process Added";
	public static final String RECRUITMENT_PROCESS_LEVEL_UPDATED = "Recruitment Process Level Updated";
	public static final String RECRUITMENT_PROCESS_LEVEL_DELETED = "Recruitment Process Level Deleted";
	public static final String SET_WORKFLOW_TYPE_RECRUITMENT_PROCESS = "Recruitment Process";
	public static final String SET_WORKFLOW_STATUS_AS_PENDING = "Approved";
	public static final String WORKFLOW_STATUS_UPDATED = "Workflow status updated";

	public static final String RECRUITMENT_PROCESS_LEVEL_INSERTED = "Recruitment Process Level Inserted";

	public static final String APPROVER_LEVEL_ADDED = "Approver Level Added";
	public static final String APPROVER_LEVEL_UPDATED = "Approver Level Updated";
	public static final String APPROVER_LEVEL_DELETED = "Approver Level Deleted";
	public static final String SET_WORKFLOW_TYPE_APPROVER_LEVEL = "Approver Level";
	
	public static final String  CANDIDATE_DOCUMENT_STATUS_UPDATE="Candidate Document Status Updated";
	 

	public static final String CLIENT_ADD_SUCCESS = "Client added Successfully!";
	public static final String CLIENT_ADD_FAILURE = "Client add failure!!";

	public static final String CLIENT_EMAIL_EXISTS = "Client email exists!";
	public static final String CLIENT_EMAIL_NOT_EXISTS = "Client email does not exists!";
	public static final String CLIENT_FORGOTPWD_OTP_SUCCESS = "OTP sent successfully!";

	public static final String DELETE_SUCCESS = "Delete Success";
	public static final String DELETE_FAILURE = "Delete Failure";

	public static final String UPDATE_SUCCESS = "Update Success";
	public static final String UPDATE_FAILURE = "Update Failure";

	public static final String ADD_REQUIREMENT_SUCCESS = "Add Requirement Success";
	public static final String ADD_REQUIREMENT_FAILURE = "Add Requirement Failure";

	public static final String CLIENT_PASSWORD_RESET_SUCCESS = "Password reset success!";
	public static final String CLIENT_PASSWORD_RESET_FAILURE = "Password reset failure!!";

	public static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

	// Recruiting Manager
	public static final String RECRUITING_MANAGER_ASSIGNED_MRF_SUCCESS = "MRF assigned to vendor successful";
	public static final String RECRUITING_MANAGER_ASSIGNED_MRF_FAILED = "MRF assigned to vendor Failed";
	public static final String RECRUITING_MANAGER_MRF_STATUS_ASSIGNED = "Assigned";

	// Recruiter
	public static final String RECRUITER_ASSIGNED_MRF_SUCCESS = "MRF assigned to Recruiter successful";
	public static final String RECRUITER_ASSIGNED_MRF_FAILED = "MRF assigned to Recruiter Failed";
	public static final String RECRUITER_MRF_STATUS_ASSIGNED = "Assigned";

	// vendor
	public static final String VENDOR_NOT_FOUND = "Vendor not found.";
	public static final String VENDOR_LOGIN_URL = "http://localhost:3000";

	public static final String VENDOR_CREATED_SUCCESS = "Vendor created successfully.";
	public static final String VENDOR_CREATED_FAILED = "Vendor created failed.";

	public static final String VENDOR_UPDATED_SUCCESS = "Vendor updated successfully.";
	public static final String VENDOR_UPDATED_FAILED = "Vendor updated failed.";

	public static final String VENDOR_DELETED_SUCCESS = "Vendor deleted successfully.";
	public static final String VENDOR_DELETED_FAILED = "Vendor deleted failed.";

	public static final String MESSAGE_SENT_SUCCESS = "Message Sent Successfully";
	public static final String MESSAGE_SENT_FAILED = "Message failed to sent";

	// Recruiter
	public static final String OFFER_APPROVAL_STATUS_UPDATED = "Updated Successfully";
	public static final String SET_OFFER_APPROVAL_STATUS = "Pending";

	public static final String ORG_LOCATION_CREATED_SUCCESS = "Organization Location created successfully!";
	public static final String ORG_LOCATION_CREATION_FAILED = "Failed to create Organization Location!";
	public static final String ORG_LOCATION_UPDATED_SUCCESS = "Organization Location updated successfully!";
	public static final String ORG_LOCATION_UPDATE_FAILED = "Failed to update Organization Location!";
	public static final String ORG_LOCATION_DELETED_SUCCESS = "Organization Location deleted successfully!";
	public static final String ORG_LOCATION_DELETION_FAILED = "Failed to delete Organization Location!";
	public static final String ORG_LOCATION_NOT_FOUND = "Organization Location not found with ID: ";
	public static final String ORG_LOCATIONS_RETRIEVED_SUCCESS = "All Organization Locations retrieved successfully!";
	public static final String ORG_LOCATION_RETRIEVED_SUCCESS = "Organization Location retrieved successfully!";

	// Error Messages
	public static final String INTERNAL_SERVER_ERROR = "Internal server error occurred!";

	public static final String RECRUITER_MRF_UPDATED = "ReAssignement Success";

	public static final String RECRUITER_MRF_NOT_FOUND = "Not Found";

	public static final String RECRUITER_MRF_UPDATE_FAILED = "Updation Failed";
	 public static final String CANDIDATE_UPDATED_SUCCESS = "Candidate has been successfully updated.";
	    public static final String CANDIDATE_UPDATE_FAILURE = "Failed to update candidate. Candidate is null.";
	public static final String GET_WORKFLOW_EMPLOYEE = "available workflow";

	public static final String WORKFLOW_APPROVAL_STATUS_SUCCESS = "Workflow Approval done";
	public static final String WORKFLOW_APPROVAL_STATUS_FAILURE = "Workflow Approval failed";

	public static final String RECRUITER_MRF_STATUS_REASSIGNED = null;
	// team D vendor
	public static final String CANDIDATE_ADDED_SUCCESS = "Candidate added successfully";
	public static final String CANDIDATE_ADDED_FAILURE = "Candidtae add failure!!";
	public static final String RESUME_UPLOAD_FAILURE = "error in adding resume ";
	public static final String FORGOTPWD_OTP_SUCCESS = "OTP sent successfully!";
    public static final String CANDIDATE_NOT_FOUND = "Candidate not found.";

	public static final String SUCCESS_ADDING_STATUS = "added successfully";
	
	public static final String JOB_TITLES_ADDED = "job titles added successfully";
	 
	public static final String JOB_TITLES_FAILED = "job titles failed to add";
 
 

}
