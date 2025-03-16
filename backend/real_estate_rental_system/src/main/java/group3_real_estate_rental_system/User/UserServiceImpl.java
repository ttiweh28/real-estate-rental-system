package group3_real_estate_rental_system.User;

import group3_real_estate_rental_system.User.dto.UserBasicInfo;
import group3_real_estate_rental_system.User.dto.UserDTO;
import group3_real_estate_rental_system.User.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(UserDTO user) {

        //TODO check for admin user only or unauthenticated user

        User saveUser = new User(
                user.getLastName(),
                user.getUserName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getPhoto(),
                user.getAddress());
        saveUser.setRole(user.getRole());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(u-> UserService.buildUserDtoFromUserEntity(u)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return UserService.buildUserDtoFromUserEntity(user.get());
        }
       return null;
    }
    @Override
    public UserBasicInfo getUserBasicInfoById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return UserService.buildUserBasicInfoFromUserEntity(user.get());
        }
       return null;
    }

    @Override
    public List<UserDTO> getUserByFirstName(String firstName) {
        return List.of();
    }

    @Override
    public User updateUser(Long id, UserDTO User) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
    }

}
