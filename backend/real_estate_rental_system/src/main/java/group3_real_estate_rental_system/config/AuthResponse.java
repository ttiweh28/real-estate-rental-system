package group3_real_estate_rental_system.config;

import group3_real_estate_rental_system.common.BaseResponse;

public class AuthResponse extends BaseResponse {

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
