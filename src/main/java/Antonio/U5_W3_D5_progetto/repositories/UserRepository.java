package Antonio.U5_W3_D5_progetto.repositories;

import Antonio.U5_W3_D5_progetto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
