package Antonio.U5_W3_D5_progetto.services;

import Antonio.U5_W3_D5_progetto.entities.User;
import Antonio.U5_W3_D5_progetto.enums.Role;
import Antonio.U5_W3_D5_progetto.exceptions.BadRequestException;
import Antonio.U5_W3_D5_progetto.exceptions.NotFoundException;
import Antonio.U5_W3_D5_progetto.payloads.NewUserDTO;
import Antonio.U5_W3_D5_progetto.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(NewUserDTO payload) {

        Optional<User> existing = userRepository.findByEmail(payload.email());
        if (existing.isPresent()) {
            throw new BadRequestException("L'email " + payload.email() + " è già in uso!");
        }
        
        User newUser = new User(
                payload.username(),
                passwordEncoder.encode(payload.password()),
                Role.USER,
                payload.email()
        );

        User savedUser = userRepository.save(newUser);
        log.info("Utente con id: " + savedUser.getId() + " registrato correttamente.");
        return savedUser;
    }

    public Page<User> findAll(int pageNumber, int pageSize, String sortBy) {
        if (pageSize > 50) pageSize = 50;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        return userRepository.findAll(pageable);
    }

    public User findById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(userId.intValue()));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("L'utente con l'email " + email + " non è stato trovato!"));
    }
    public User findByIdAndUpdate(int userId, NewUserDTO payload) {

        User found = this.findById(userId);


        if (!found.getEmail().equals(payload.email()))
            this.userRepository.findByEmail(payload.email()).ifPresent(user -> {
                throw new BadRequestException("L'email " + user.getEmail() + " è già in uso!");
            });



        found.setEmail(payload.email());
        found.setPassword(payload.password());

        User modifiedUser = this.userRepository.save(found);


        return modifiedUser;
    }


}
