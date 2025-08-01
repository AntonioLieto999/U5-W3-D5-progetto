package Antonio.U5_W3_D5_progetto.services;

import Antonio.U5_W3_D5_progetto.entities.User;
import Antonio.U5_W3_D5_progetto.enums.Role;
import Antonio.U5_W3_D5_progetto.exceptions.BadRequestException;
import Antonio.U5_W3_D5_progetto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String email, String password, Role role) {
        if (userRepository.findAll().stream().anyMatch(u -> u.getUsername().equals(username)))
            throw new BadRequestException("Username già esistente!");

        User user = new User(username, passwordEncoder.encode(password), role, email);
        return userRepository.save(user);
    }
}
