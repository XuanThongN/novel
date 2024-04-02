package com.xuanthongn.util;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class Commons {

    //    Hàm dùng để lấy token từ SharedPreferences
    public static String getToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getString(Constants.TOKEN, null);
    }

    //    Hàm dùng dể mã hóa mật khẩu
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            // Convert byte array into signum representation
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    //    Hàm kiểm tra email hợp lệ
    public static boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    //    Hàm lấy nội dung của HttpException
    public static String getHttpExceptionMessage(Throwable e) {
        String errorMessage = e.getMessage();
        try {
            if (e instanceof HttpException) {
                HttpException httpException = (HttpException) e;
                ResponseBody errorBody = httpException.response().errorBody();
                errorMessage = errorBody.string();
            } else {
                // Handle other errors (network, etc.)
                errorMessage = e.getMessage(); // Could provide a more user-friendly message here
            }
        } catch (IOException ex) {
            errorMessage = ex.getMessage();
        }
        return errorMessage;
    }

}