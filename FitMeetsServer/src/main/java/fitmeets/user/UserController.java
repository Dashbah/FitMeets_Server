package fitmeets.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/info/{id}")
    public User getInfo(@PathVariable(value = "id") Long id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                            @RequestBody User userDetails) {
        try {
            return userService.editUser(userId, userDetails);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user-events/{id}")
    public ResponseEntity<List<Long>> getUserEvents(@PathVariable(value = "id") Long userId) {
        return userService.getEvents(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId) {
        userService.deleteUser(userId);
    }
}
