package com.rts.tap.constants;

public class EmailConstants {
    public static final String LOGIN_CREDENTIALS_SUBJECT = "Your Login Credentials";
    public static final String LOGIN_CREDENTIALS_BODY_TEMPLATE = "Dear User,\n\n" +
            "Your account has been created successfully.\n" +
            "Username: %s\n" +
            "Password: %s\n\n" +
            "Please keep your credentials safe.\n\n" +
            "Best Regards,\n" +
            "Your Company Name";

    public static final String DEFAULT_EMAIL_SUBJECT = "Notification";
    public static final String DEFAULT_EMAIL_BODY_TEMPLATE = "Dear User,\n\n%s\n\nBest Regards,\nYour Company Name";
}