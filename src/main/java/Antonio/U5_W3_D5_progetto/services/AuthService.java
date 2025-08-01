package Antonio.U5_W3_D5_progetto.services;

import Antonio.U5_W3_D5_progetto.Security.JWTTools;
import Antonio.U5_W3_D5_progetto.entities.User;
import Antonio.U5_W3_D5_progetto.exceptions.UnauthorizedException;
import Antonio.U5_W3_D5_progetto.payloads.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private PasswordEncoder bcrypt;

    public String checkCredentialsAndGenerateToken(LoginDTO body) {

        User found = this.userService.findByEmail(body.email());
        if (bcrypt.matches(body.password(), found.getPassword())) {
            return jwtTools.createToken(found);
        } else {
            throw new UnauthorizedException("Credenziali errate!");
        }
    }
}
