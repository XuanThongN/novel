package com.xuanthongn.util;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;

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

    // Hàm chuẩn hóa chuỗi Tiếng Việt: chuyển về chữ thường, xóa dấu, ký tự đặc biệt
    public static String toNonAccentVietnamese(String str) {
        // Loại bỏ dấu
        str = Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        // Thay thế các ký tự Tiếng Việt có dấu
        str = str.replaceAll("[AÁÀÃẠÂẤẦẪẬĂẮẰẴẶ]", "A");
        str = str.replaceAll("[aáàãạâấầẫậăắằẵặ]", "a");
        str = str.replaceAll("[EÉÈẼẸÊẾỀỄỆ]", "E");
        str = str.replaceAll("[eéèẽẹêếềễệ]", "e");
        str = str.replaceAll("[IÍÌĨỊ]", "I");
        str = str.replaceAll("[iíìĩị]", "i");
        str = str.replaceAll("[OÓÒÕỌÔỐỒỖỘƠỚỜỠỢ]", "O");
        str = str.replaceAll("[oóòõọôốồỗộơớờỡợ]", "o");
        str = str.replaceAll("[UÚÙŨỤƯỨỪỮỰ]", "U");
        str = str.replaceAll("[uúùũụưứừữự]", "u");
        str = str.replaceAll("[YÝỲỸỴ]", "Y");
        str = str.replaceAll("[yýỳỹỵ]", "y");
        str = str.replaceAll("Đ", "D");
        str = str.replaceAll("đ", "d");

        // Bổ sung các ký tự chứa dấu hỏi
        str = str.replaceAll("[ẢẲẨẠ]", "A");
        str = str.replaceAll("[ảẳạ]", "a");
        str = str.replaceAll("[ỒỐỔỖỘ]", "O");
        str = str.replaceAll("[ồốổỗộ]", "o");
        str = str.replaceAll("[ỬỪỨỰỮ]", "U");
        str = str.replaceAll("[ừứửựữ]", "u");
        str = str.replaceAll("[ỲÝỶỸỴ]", "Y");
        str = str.replaceAll("[ỳýỷỹỵ]", "y");

        // Xóa các ký tự kết hợp
        str = str.replaceAll("\u0300|\u0301|\u0303|\u0309|\u0323", ""); // Huyền sắc hỏi ngã nặng
        str = str.replaceAll("\u02C6|\u0306|\u031B", ""); // Â, Ê, Ă, Ơ, Ư

        return str;
    }

}