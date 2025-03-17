package group3_real_estate_rental_system.User;

import group3_real_estate_rental_system.User.dto.UserDTO;
import group3_real_estate_rental_system.User.dto.UserRequest;
import group3_real_estate_rental_system.User.dto.UserResponse;
import group3_real_estate_rental_system.common.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        UserResponse userresponse = BaseResponse.successResponse(UserResponse.class);
        userresponse.setUser(allUsers);
        return ResponseEntity.ok(userresponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        UserResponse userresponse = BaseResponse.successResponse(UserResponse.class);
        userresponse.setUser(List.of(user));
        return ResponseEntity.ok(userresponse);
    }

    @GetMapping("/search")
    public ResponseEntity<UserResponse> getUserByFirstName(@RequestParam String firstName) {
        List<UserDTO> users = userService.getUserByFirstName(firstName);
        UserResponse userresponse = BaseResponse.successResponse(UserResponse.class);
        userresponse.setUser(users);
        return ResponseEntity.ok(userresponse);
    }


    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO User, @PathVariable Long id) {
        userService.updateUser(id, User);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}

