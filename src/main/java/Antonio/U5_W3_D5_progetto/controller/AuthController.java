package Antonio.U5_W3_D5_progetto.controller;

import Antonio.U5_W3_D5_progetto.entities.User;
import Antonio.U5_W3_D5_progetto.exceptions.ValidationException;
import Antonio.U5_W3_D5_progetto.payloads.LoginDTO;
import Antonio.U5_W3_D5_progetto.payloads.LoginRespDTO;
import Antonio.U5_W3_D5_progetto.payloads.NewUserDTO;
import Antonio.U5_W3_D5_progetto.payloads.NewUserRespDTO;
import Antonio.U5_W3_D5_progetto.services.AuthService;
import Antonio.U5_W3_D5_progetto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginRespDTO login(@RequestBody LoginDTO body) {
        String accessToken = authService.checkCredentialsAndGenerateToken(body);
        return new LoginRespDTO(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserRespDTO save(@RequestBody @Validated NewUserDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {

            throw new ValidationException(validationResult.getFieldErrors()
                    .stream().map(fieldError -> fieldError.getDefaultMessage()).toList());
        } else {
            User newUser = this.userService.save(payload);
            return new NewUserRespDTO(newUser.getId());
        }



    }
}
