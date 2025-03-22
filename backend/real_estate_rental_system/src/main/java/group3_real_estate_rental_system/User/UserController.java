package group3_real_estate_rental_system.User;

import group3_real_estate_rental_system.User.dto.UserDTO;
import group3_real_estate_rental_system.User.dto.UserRequest;
import group3_real_estate_rental_system.User.dto.UserResponse;
import group3_real_estate_rental_system.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "get list of users", description = "require ADMIN role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponse> getUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        UserResponse userresponse = BaseResponse.successResponse(UserResponse.class);
        userresponse.setUser(allUsers);
        return ResponseEntity.ok(userresponse);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TENANT', 'PROPERTIES_OWNER')")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        UserResponse userresponse = BaseResponse.successResponse(UserResponse.class);
        userresponse.setUser(List.of(user));
        return ResponseEntity.ok(userresponse);
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "require ADMIN role")
    public ResponseEntity<UserResponse> getUserByFirstName(@RequestParam String firstName) {
        List<UserDTO> users = userService.getUserByFirstName(firstName);
        UserResponse userresponse = BaseResponse.successResponse(UserResponse.class);
        userresponse.setUser(users);
        return ResponseEntity.ok(userresponse);
    }


    @PostMapping
    @PermitAll
    public ResponseEntity<?> addProperties(
            @Valid @NotNull @ModelAttribute("property") UserRequest user,
            @RequestParam(value = "userPhoto", required = false) MultipartFile userPhoto) {
        userService.addUser(user, userPhoto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // TODO allow only the logged in user edit their own
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TENANT', 'PROPERTIES_OWNER')")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO User, @PathVariable Long id) {
        userService.updateUser(id, User);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    // TODO only allow to delete other users
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TENANT', 'PROPERTIES_OWNER')")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

