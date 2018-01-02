package com.tcs.services.requests;

/**
 * Created by 1951272 on 10/4/16.
 */
public class SystemTokenRequest extends BaseTokenRequest {

    public SystemTokenRequest() {
        super(GRANT_TYPE_CLIENT_CREDENTIALS);
    }
}