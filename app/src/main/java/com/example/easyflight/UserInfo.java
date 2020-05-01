package com.example.easyflight;

public class UserInfo {

    private static String userName;

    public static String getUserName() {
        if (userName == null || userName.equals("")) {
            return "User";
        }
        return userName;
    }

    public static void setUserName(String userName) {
        UserInfo.userName = userName;
    }
}
