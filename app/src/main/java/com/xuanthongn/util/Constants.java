package com.xuanthongn.util;

public class Constants {
    public static String DB_NAME = "novel_db";
    public static String PREF_NAME = "LoginInfo";
    public static String KEY_LOGIN_STATUS = "IsLogin";
    public static String KEY_EMAIL = "Email";
    public static String KEY_NAME = "Name";

    public enum LOGIN_STATUS {PASSWORD_ERROR, EMAIL_ERROR}

    public enum REGISTER_STATUS {INVALID_EMAIL, EMAIL_EXIST, NAME_INVALID, PASSWORD_INVALID}

    ;
}
