package group3_real_estate_rental_system.User.dto;

import group3_real_estate_rental_system.common.BaseResponse;

import java.util.List;

public class UserResponse extends BaseResponse {

    List<UserDTO> user;

    public List<UserDTO> getUser() {
        return user;
    }

    public void setUser(List<UserDTO> user) {
        this.user = user;
    }
}
