package com.xuanthongn.util;

public class Constants {
    public static final String BASEURL = "https://www.api.xuanthongn.games";
    public static final String TOKEN = "93100dcd68e0b418cffab85db7da57e013d4f2f2";
    public static final String KEY_USERNAME = "USERNAME";
    public static final String KEY_TOKEN = "TOKEN";
    public static final String KEY_USER_ID = "USER_ID";
    public static String DB_NAME = "novel_db";
    public static String PREF_NAME = "LoginInfo";
    public static String KEY_LOGIN_STATUS = "IsLogin";
    public static String KEY_EMAIL = "EMAIL";
    public static String KEY_NAME = "NAME";

//    Dùng để loại bỏ tiếng việt có dấu
    public static String REGEX = "[^a-zA-Zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]";

    public enum LOGIN_STATUS {PASSWORD_ERROR, EMAIL_ERROR}

    public enum REGISTER_STATUS {INVALID_EMAIL, EMAIL_EXIST, NAME_INVALID, PASSWORD_INVALID}

    ;
}
