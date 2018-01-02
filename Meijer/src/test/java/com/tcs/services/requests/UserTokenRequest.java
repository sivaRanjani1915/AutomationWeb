package com.tcs.services.requests;

/**
 * Created by 1951272 on 10/5/16.
 */
public class UserTokenRequest extends BaseTokenRequest {

    public UserTokenRequest() {
        super(GRANT_TYPE_PASSWORD);
    }
}
