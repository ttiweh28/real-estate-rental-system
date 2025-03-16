package group3_real_estate_rental_system.User;

import group3_real_estate_rental_system.User.dto.UserBasicInfo;
import group3_real_estate_rental_system.User.dto.UserDTO;
import group3_real_estate_rental_system.User.dto.UserRequest;
import group3_real_estate_rental_system.User.entity.User;

import java.util.List;

public interface UserService {

    static UserDTO buildUserDtoFromUserEntity(User user) {
        return user != null ? new UserDTO(user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getPhoto(),
                user.getAddress()) : null;
    }

    static UserBasicInfo buildUserBasicInfoFromUserEntity(User user) {
        return user != null ? new UserBasicInfo(
                user.getFirstName(),
                user.getLastName(),
                user.getPhoto()) : null;
    }

    void addUser(UserRequest user);

    List<UserDTO> getAllUsers();

    User getUserByUsername(String username);

    UserDTO getUserById(Long id);

    UserBasicInfo getUserBasicInfoById(Long id);

    List<UserDTO> getUserByFirstName(String firstName);

    User updateUser(Long id, UserDTO User);

    void deleteUser(Long id);
}
 