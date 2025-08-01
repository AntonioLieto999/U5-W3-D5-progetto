package Antonio.U5_W3_D5_progetto.repositories;

import Antonio.U5_W3_D5_progetto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
