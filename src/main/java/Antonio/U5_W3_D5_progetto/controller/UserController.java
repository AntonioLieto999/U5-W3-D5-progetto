package Antonio.U5_W3_D5_progetto.controller;

import Antonio.U5_W3_D5_progetto.entities.User;
import Antonio.U5_W3_D5_progetto.payloads.NewUserDTO;
import Antonio.U5_W3_D5_progetto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utenti")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public User getCurrentUser(@AuthenticationPrincipal User currentUser) {
        return currentUser;
    }

    @PutMapping("/me")
    public User updateOwnProfile(@AuthenticationPrincipal User currentAuthenticatedUser, @RequestBody @Validated NewUserDTO payload) {
        return this.userService.findByIdAndUpdate(currentAuthenticatedUser.getId(), payload);
    }
}