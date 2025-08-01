package Antonio.U5_W3_D5_progetto.repositories;

import Antonio.U5_W3_D5_progetto.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepositoy extends JpaRepository<Booking, Integer> {
}
