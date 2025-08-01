package Antonio.U5_W3_D5_progetto.repositories;

import Antonio.U5_W3_D5_progetto.entities.PostiEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepositoy extends JpaRepository<PostiEvento, Integer> {
}
