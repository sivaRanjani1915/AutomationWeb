package com.tcs.services;

/**
 * Created by 1951272 on 10/4/16.
 */
public class AuthData {

    private static AuthData authData = null;
    public String tokenType;
    public int expiresIn;
    public String accessToken;

    protected AuthData() {

    }

    public static AuthData getInstance() {

        if (authData == null) {
            authData = new AuthData();
        }

        return authData;
    }

}
