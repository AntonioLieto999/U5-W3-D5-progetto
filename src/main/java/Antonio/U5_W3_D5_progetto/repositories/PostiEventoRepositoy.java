package Antonio.U5_W3_D5_progetto.repositories;

import Antonio.U5_W3_D5_progetto.entities.PostiEvento;
import Antonio.U5_W3_D5_progetto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostiEventoRepositoy extends JpaRepository<PostiEvento,Integer> {
    List<PostiEvento> findByUser(User user);
}
