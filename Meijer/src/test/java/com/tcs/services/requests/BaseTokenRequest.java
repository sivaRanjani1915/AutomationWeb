package com.tcs.services.requests;

/**
 * Created by 1951272 on 10/4/16.
 */
public class BaseTokenRequest {

    protected static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
    protected static final String GRANT_TYPE_PASSWORD = "password";
    protected static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
    protected static final String SCOPE_OPEN_ID = "openid";

    public final String grantType;
    public final String scope;

    public BaseTokenRequest(String grantType) {
        this.grantType = grantType;
        this.scope = SCOPE_OPEN_ID;
    }
}