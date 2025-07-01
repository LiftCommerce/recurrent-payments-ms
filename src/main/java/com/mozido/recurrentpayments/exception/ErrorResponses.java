package com.mozido.recurrentpayments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by Rafael Richards on 06/25.
 */

@Component
public class ErrorResponses extends ErrorResponse {


    public static final ErrorResponses INTERNAL_SERVER_ERROR = new ErrorResponses(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal error please try again. If the error persist contact us to solve the problem");

    public static final ErrorResponses SESSION_EXPIRED = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "Session expired, please login again");

    public static final ErrorResponses INVALID_SESSION_TOKEN = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "Invalid session token");

    public static final ErrorResponses TENANT_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Tenant not found");

    public static final ErrorResponses TRANSACTION_ID_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Transaction Id not found");

    public static final ErrorResponses ENTITY_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company not found");

    public static final ErrorResponses USER_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "User not found");

    public static final ErrorResponses USER_ALREADY_ASSIGNED_TO_GROUP = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "User already assigned to Group");

    public static final ErrorResponses QR_ID_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "QR id not found");

    public static final ErrorResponses ENTITY_QR_ID_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Entity does not have Qr ids configured");

    public static final ErrorResponses LABEL_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Label not found");
    public static final ErrorResponses DESCRIPTION_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Description not found");

    public static final ErrorResponses STATUS_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Status not found");

    public static final ErrorResponses USER_INFO_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The user Additional Information is not Registered");

    public static final ErrorResponses ANNOUNCEMENT_GROUP_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The Announcement Group is not Registered");

    public static final ErrorResponses ANNOUNCEMENT_GROUP_USER_RECORDS_FOUND = new ErrorResponses(HttpStatus.NOT_ACCEPTABLE, HttpStatus.NOT_ACCEPTABLE.value(),
            "There are still users associated with this Group, cannot delete the Group...");

    public static final ErrorResponses ANNOUNCEMENT_GROUP_USER_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The Announcement Group - User relationship is not Registered");

    public static final ErrorResponses USER_NOT_REGISTERED_KYC = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The user is not Registered on kyc");

    public static final ErrorResponses ERROR_EXECUTING_PAYMENT = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "ERROR_EXECUTING_PAYMENT");

    public static final ErrorResponses USER_UUID_EMPTY = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "The userUuid can't be empty");

    public static final ErrorResponses KYC_LEVEL_BELOW = new ErrorResponses(HttpStatus.EXPECTATION_FAILED, HttpStatus.EXPECTATION_FAILED.value(),
            "User kyc level is not allowed");

    public static final ErrorResponses PAYMENT_PROCESSOR_NOT_CONFIGURED = new ErrorResponses(HttpStatus.EXPECTATION_FAILED, HttpStatus.EXPECTATION_FAILED.value(),
            "Payment processor not configured for that currency");
    public static final ErrorResponses INSURANCE_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The Insurance does not exist");

    public static final ErrorResponses AMOUNT_NOT_VAILD = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "Amount of transactions does not reach the goal");

    public static final ErrorResponses PENDING_REQUEST = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "You already have a pending request for this transaction");

    public static final ErrorResponses ISSUES_UPDATING_ROLE = new ErrorResponses(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(),
            "ISSUES UPDATING User ROLE");

    public static final ErrorResponses NOT_VALID_COMPANYID = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Format company ID invalid");

    public static final ErrorResponses USER_REGISTRATION_INCOMPLETE = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "The user is not Fully Registered");

    public static final ErrorResponses INVALID_PASSWORD_REGISTRATION_INCOMPLETE = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "Invalid Password");

    public static final ErrorResponses BUDDIE_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The buddie is not Registered");

    public static final ErrorResponses BUDDIE_NOT_YOURS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The username is not on your buddies list");

    public static final ErrorResponses USER_NOT_BLOCKED = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The username is not on your blocked list");

    public static final ErrorResponses BUDDIE_UUID = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The buddie UUId not valid");

    public static final ErrorResponses REQUEST_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The send money request is not Found");

    public static final ErrorResponses USER_BLOCKED_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The transaction is not available.");

    public static final ErrorResponses USER_LOCKED_BY_FRAUD = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "The user is not able to register, please call support.");

    public static final ErrorResponses TERMS_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Terms and Conditions not Found");

    public static final ErrorResponses POLICY_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Policy not Found");

    public static final ErrorResponses USER_CONFLICT = new ErrorResponses(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(),
            "This email address is in use. If you are the account holder, please proceed to Login and continue with validation");

    public static final ErrorResponses USERNAME_CONFLICT = new ErrorResponses(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(),
            "This username is in use. If you are the account holder, please proceed to Login and continue with validation");

    public static final ErrorResponses USER_CREATE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill all the requirements values to create a User");

    public static final ErrorResponses EMPLOYEE_CREATE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill all the requirements values to create a employee");

    public static final ErrorResponses PAYMENT_MERCHANT_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill all the values to pay a merchant");
    public static final ErrorResponses PAYMENT_PERSON_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill all the values to pay a person");

    public static final ErrorResponses ADD_TELEPHONE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill telephone property");

    public static final ErrorResponses ADD_TELEPHONE_TYPE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill the telephone type property (HOME,MOBILE, FAX, WORK)");

    public static final ErrorResponses ADD_EMAIL_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill email");

    public static final ErrorResponses ADD_ADDR_STREET_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill street1 property");

    public static final ErrorResponses ADD_ADDR_CITY_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill city property");

    public static final ErrorResponses ADD_ADDR_STATE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill state property");

    public static final ErrorResponses ADD_ADDR_COUNTRY_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill country property");

    public static final ErrorResponses CURRENCY_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill currency property");

    public static final ErrorResponses CAMPAIGN_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill campaign property");

    public static final ErrorResponses ADD_ADDR_ZIPCODE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill zipCode property");

    public static final ErrorResponses ADD_ADDR_NAME_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill name property");

    public static final ErrorResponses ADD_ADDR_TYPE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill type property");

    public static final ErrorResponses ADD_ADDR_DEFAULT_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill isDefault property");
    public static final ErrorResponses ADD_ADDR_CREATE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill address information");

    public static final ErrorResponses USER_REGISTRATION_ERROR = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "There was an error on user Registration. reg-ms");

    public static final ErrorResponses SERVICE_GENERAL_ERROR = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "there was an error on the service");

    public static final ErrorResponses PHONE_NUMBER_USED = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Phone number is already in use, please use a new one");

    public static final ErrorResponses GET_TOKEN_ERROR = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Error obtaining token");

    public static final ErrorResponses CREATE_SVA_ERROR = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Error creating user sva");

    public static final ErrorResponses CREATE_USER_ERROR = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Error creating user");

    public static final ErrorResponses CREATE_SVA_ERROR_NULL = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Error creating user sva Null");

    public static final ErrorResponses SVA_CREATE_ERROR = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Error creating SVA");

    public static final ErrorResponses SVA_ID_EMPTY = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Please fill SVA");

    public static final ErrorResponses EVENT_CREATE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill all the requirements values to create a Fund");

    public static final ErrorResponses EVENT_CREATE_MISSING_COMPANY = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Company Id is missing");

    public static final ErrorResponses EVENT_UPDATE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill all the requirements values to update a Fund");

    public static final ErrorResponses EVENT_INVITE_CONTRIBUTOR_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill all the requirements values to invita a user to contribute");

    public static final ErrorResponses CONTRIBUTE_TO_EVENT_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill all the requirements values to contribute to a Fund");

    public static final ErrorResponses VALIDATE_PIN_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill all the requirements values to validate pin");

    public static final ErrorResponses EVENT_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Fund not found");


    public static final ErrorResponses FAVORITE_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Favorite not found");

    public static final ErrorResponses APPOINTMENT_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Appointment not found");


    public static final ErrorResponses SETTING_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Setting not found");

    public static final ErrorResponses APP_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "APP not found");

    public static final ErrorResponses INVITE_YOURSELF = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "You can't invite yourself");

    public static final ErrorResponses INVALID_PIN = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "Invalid Pin");
    public static final ErrorResponses ERROR_ADDING_CREDENTIAL = new ErrorResponses(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(),
            "Error adding credential on auth");

    public static final ErrorResponses NO_PHONE_REGISTERED = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "No phone registered");

    public static final ErrorResponses NO_EMAIL_REGISTERED = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "No Email registered");

    public static final ErrorResponses PIN_EXPIRED = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "Pin expired");

    public static final ErrorResponses UNAUTHORIZED = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "Unauthorized");

    public static final ErrorResponses KYC_PROVIDER_NEEDED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Kyc provider needed");

    public static final ErrorResponses KYC_SCORE_NEEDED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Kyc score needed");

    public static final ErrorResponses STATUS_CHANGE_NOT_ALLOWED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Event Status Change not allowed");

    public static final ErrorResponses EVENT_NOT_ALLOW = new ErrorResponses(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value(),
            "You are not allow to update this fund");

    public static final ErrorResponses EVENT_INVALID_DELETED_STATUS = new ErrorResponses(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value(),
            "Invalid status Fund, only Active and Reached Fund can be delete");

    public static final ErrorResponses EVENT_WITHDRAW_BAD_STATUS = new ErrorResponses(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value(),
            "Fund have to be on Reached status to withdraw money");

    public static final ErrorResponses EVENT_NOT_AVAILABLE = new ErrorResponses(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value(),
            "This Fund has been cancelled or has expired");

    public static final ErrorResponses EVENT_CANT_CONTRIBUTE = new ErrorResponses(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value(),
            "Please join to the Fund before to accepted");

    public static final ErrorResponses EVENT_INVALID_AMOUNT = new ErrorResponses(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value(),
            "The amount you try to contribute exceed fund goal");

    public static final ErrorResponses INVALID_SVA = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Your default SVA does not match the currency of the Basket.");

    public static final ErrorResponses DELETE_NOTIFICATION_NOT_ALLOW = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "You are not allow to delete this notification");

    public static final ErrorResponses NOTIFICATION_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Notification not found");

    public static final ErrorResponses DELETE_INSURANCE_NOT_ALLOW = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "You are not allow to delete this Insurance");

    public static final ErrorResponses TENANT_NOT_ALLOW = new ErrorResponses(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value(),
            "You are not allow to use this tenant");

    public static final ErrorResponses PERMISSION_NOT_ALLOW = new ErrorResponses(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value(),
            "You are not allow to use this API");

    public static final ErrorResponses TENANT_SETTING_NOT_EXIST = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "The tenant that you are using it is not set properly, please contact you System administrator to fix this");

    public static final ErrorResponses APIKEY_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "APIKEY is required");

    public static final ErrorResponses USERNAME_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Username is required");

    public static final ErrorResponses BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Bad Request");

    public static final ErrorResponses TENANT_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Tenant is required");

    public static final ErrorResponses TENANT_INTERFACE_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Tenant interface is required");


    public static final ErrorResponses TENANT_EMAIL_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Tenant email is required");

    public static final ErrorResponses HOST_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Email Host is required");

    public static final ErrorResponses PORT_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Email Port is required");

    public static final ErrorResponses REQUIRED_KYC_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Kyc required is required");

    public static final ErrorResponses REQUIRED_KYC_SCORE = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Kyc score required is required");

    public static final ErrorResponses REQUIRED_KYC_REQUIRED_LEVEL = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Kyc Level required is required");

    public static final ErrorResponses REQUIRED_KYC_PROVIDER = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Kyc Provider is required");

    public static final ErrorResponses PASSWORD_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Password is required");

    public static final ErrorResponses AUTHORIZATION_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Authorization is required");

    public static final ErrorResponses INVALID_DATE_FORMAT = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Invalid date format the right format to use is yyyy-MMM-dd HH:mm:ss");

    public static final ErrorResponses INVALID_DATE = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Date must be higher than current date");

    public static final ErrorResponses INVALID_AMOUNT = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Amount must be higher than zero");

    public static final ErrorResponses MISSING_USER_SVA = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "User SVA is required");

    public static final ErrorResponses INVALID_EVENT_TYPE = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Type property must set (FIXED = 0, OPEN = 1");

    public static final ErrorResponses ESTIMATED_CONTRIBUTORS_REQUIRED = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Estimated contributors property is required for Fixed Fundz");

    public static final ErrorResponses VERSION_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill Version property");
    public static final ErrorResponses OS_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill OS property");
    public static final ErrorResponses APPID_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill APPID property");

    public static final ErrorResponses GET_VERSION_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill all the requirements values");

    public static final ErrorResponses DAY_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please provide day");

    public static final ErrorResponses DAY_RANGE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please provide day range from and to");

    public static final ErrorResponses COMPANY_SVA_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Merchant does not have any matching sva or no sva still created");

    public static final ErrorResponses SVA_NOT_MERCHANT = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Sender sva is not a Merchant.");

    public static final ErrorResponses COMPANY_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company does not exist");

    public static final ErrorResponses PRE_REG_NOT_FOUND = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Pre-registration does not exist");

    public static final ErrorResponses COMPANY_CODE_IN_USE = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company code is already in use");

    public static final ErrorResponses USERNAME_IN_USE = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Username is already in use");

    public static final ErrorResponses ADDRESS_NOT_VALID = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Address is not valid");

    public static final ErrorResponses COMPANY_CAMPAIGN = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company does not have assigned campaign");

    public static final ErrorResponses COMPANY_NOT_VALID_ASURA = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company does not exist for Asura");

    public static final ErrorResponses COMPANY_EMPTY_ASURA = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company name empty, please fill");

    public static final ErrorResponses COMPANY_CODE_ASURA = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company code empty, please fill");

    public static final ErrorResponses COMPANY_ID = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company id empty, please fill");

    public static final ErrorResponses CATEGORY_CODE_ASURA = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Category empty, please fill");

    public static final ErrorResponses HEALTHCARE_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Healthcare empty, please fill");

    public static final ErrorResponses USER_NOT_HEALTHCARE = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "User has no healthcare assigned");

    public static final ErrorResponses ADDRESS_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Address empty, please fill");

    public static final ErrorResponses CYTY_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "City empty, please fill");

    public static final ErrorResponses STATE_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "State empty, please fill");

    public static final ErrorResponses POSTAL_CODE_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Postal code empty, please fill");

    public static final ErrorResponses TIMEZONE_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Timezone empty, please fill");

    public static final ErrorResponses FIRST_NAME_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "First Name empty, please fill");

    public static final ErrorResponses LAST_NAME_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Last Name empty, please fill");

    public static final ErrorResponses FULL_NAME_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Customer full Name empty, please fill");

    public static final ErrorResponses ACCOUNT_NAME_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Account name empty, please fill");

    public static final ErrorResponses DESCRIPTION_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Description empty, please fill");

    public static final ErrorResponses ACCOUNT_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Account empty, please fill");

    public static final ErrorResponses ROUTING_NUMBER_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Routing Number empty, please fill");

    public static final ErrorResponses COMPANY_NAME_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company Name must be 2 characters at least ");

    public static final ErrorResponses COMPANY_NAME_EMPTY = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company Name empty, please fill ");

    public static final ErrorResponses COMPANY_CODE_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Company Code must be 2 characters at least ");

    public static final ErrorResponses COMPANY_ADDRESS_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Address must be 5 characters at least ");

    public static final ErrorResponses CITY_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "City must be 2 characters at least ");

    public static final ErrorResponses POSTAL_CODE_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Postal code must be 5 characters at least ");

    public static final ErrorResponses FIRST_NAME_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "First name must be 2 characters at least ");

    public static final ErrorResponses LAST_NAME_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Last name must be 2 characters at least ");

    public static final ErrorResponses BANK_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Bank must be 2 characters at least ");

    public static final ErrorResponses ACCOUNT_NUMBER_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Account number must be 5 characters at least ");

    public static final ErrorResponses ACCOUNT_NUMBER_MAX_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Account number must be 12 characters maximun ");

    public static final ErrorResponses ROUTING_NUMBER_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Routing number must be 9 characters fixed");

    public static final ErrorResponses BAD_EMAIL_FORMAT = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Not valid email format");

    public static final ErrorResponses TITLE_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Title must be 2 characters at least ");

    public static final ErrorResponses PASSWORD_MINIMUN_CHARACTERS = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Password must be 8 characters at least ");

    public static final ErrorResponses PASSWORD_FORMAT = new ErrorResponses(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
            "Password must have at least: one uppercase, one lowercase and one number. ");


    public static final ErrorResponses CANCEL_NOT_ALLOWED = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "Cannot cancel transaction as it has been cancelled already");


    public static final ErrorResponses ERROR_CREATING_COMPANY = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "Error creating company");

    public static final ErrorResponses REFUND_NOT_ALLOWED = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "Cannot refund transaction as it has been refunded already");

    public static final ErrorResponses SS_UPDATE_CAMPAIGN_ERROR = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "SS_UPDATE_CAMPAIGN_ERROR");

    public static final ErrorResponses SS_GET_REWARDS_ERROR = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "SS_GET_REWARDS_ERROR");

    public static final ErrorResponses SS_CREATE_REWARDS_ERROR = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "SS_CREATE_REWARDS_ERROR");

    public static final ErrorResponses SS_CREATE_CUSTOM_FIELD_ERROR = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "SS_CREATE_CUSTOM_FIELD_ERROR");

    public static final ErrorResponses SS_UPDATE_REWARDS_ERROR = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "SS_UPDATE_REWARDS_ERROR");

    public static final ErrorResponses SS_DELETE_REWARDS_ERROR = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "SS_DELETE_REWARDS_ERROR");

    public static final ErrorResponses SS_UPDATE_USER_INFO_ERROR = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "Error updating user info in SS");

    public static final ErrorResponses MONEY_CONTAINER_ID_ERROR = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Please fill moneyContainerId field");

    public static final ErrorResponses GET_MONEY_CONTAINER_ERROR = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Error getting money containers");

    public static final ErrorResponses USER_WITHOUT_CURRENCY_MONEY_CONTAINER = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "This user don't have default money container of this currency");

    public static final ErrorResponses USER_SUBSCRIPTION_ALREADY_ASSIGNED = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "user already assigned to this subscription");

    public static final ErrorResponses USER_SUBSCRIPTION_NOT_EXIST = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "user not assigned to this subscription");

    public static final ErrorResponses INVALID_PIN_2FA = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "Invalid pin two factor authentication");

    public static final ErrorResponses TWO_FACTOR_AUTHENTICATION_BAD_REQUEST = new ErrorResponses(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(),
            "two factor authentication bad request");

    public static final ErrorResponses EMPTY_ADDRESS_FIELD_ADD1 = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Address 1 can't be empty ");

    public static final ErrorResponses EMPTY_ADDRESS_FIELD_CITY = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "City can't be empty ");

    public static final ErrorResponses EMPTY_ADDRESS_FIELD_STATE = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "State can't be empty ");

    public static final ErrorResponses EMPTY_ADDRESS_FIELD_POSTAL = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Postal code can't be empty ");

    public static final ErrorResponses EMPTY_ADDRESS_FIELD_COUNTRY_CODE = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Country code can't be empty ");

    public static final ErrorResponses NICKNAME_ALREADY_TAKEN = new ErrorResponses(HttpStatus.FAILED_DEPENDENCY, HttpStatus.FAILED_DEPENDENCY.value(),
            "Nickname is already in use, please select a different one.");


    public static final ErrorResponses USER_HAS_NOT_ADMIN_PRIVILEGES = new ErrorResponses(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
            "User has not privileges to execute this transaction, should be an Administrator");

    public static final ErrorResponses DESTINATION_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill destination field properly");

    public static final ErrorResponses DESTINATION_USERNAME_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill destination username field properly");

    public static final ErrorResponses DESTINATION_BANK_NUMBER_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill destination bank number field properly");

    public static final ErrorResponses DESTINATION_ACCOUNT_NUMBER_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill destination account number field properly");

    public static final ErrorResponses DESTINATION_ACCOUNT_TYPE_BAD_REQUEST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Please fill destination account type field properly");
    public static final ErrorResponses TEMPLATE_DOES_NOT_EXIST = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Template doesn't exist");

    public static final ErrorResponses TEMPLATE_BODY_EMPTY = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Body of email template cannot be null or empty.");

    public static final ErrorResponses EMAIL_RECIPIENTS_EMPTY = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "recipients field cannot be null or empty");

    public static final ErrorResponses TEMPLATE_ID_EMPTY = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "templateId field cannot be null or empty");

    public static final ErrorResponses EMAIL_SUBJECT_EMPTY = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "subject field cannot be null or empty");

    public static final ErrorResponses USER_RECEIVER_NOT_FOUND = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Username receiver was not found");
    public static final ErrorResponses SVA_NOT_VALID = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Sva receiver doesn't belongs to username");
    public static final ErrorResponses SVA_NOT_DEFAULT = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "Sva sender is not the default sva of the merchant");
    public static final ErrorResponses USER_COMPANY_NOT_FOUND = new ErrorResponses(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
            "User not found in company.");

    public ErrorResponses() {
    }


    public ErrorResponses(HttpStatus httpStatus, Integer code, String... message) {
        super(httpStatus, code, message);
    }

}