package Antonio.U5_W3_D5_progetto.payloads;

import java.time.LocalDate;

public record NewEventRespDTO(
        Integer id,
        String title,
        String description,
        LocalDate date,
        String location,
        Integer totalSeats,
        String availableSeats,
        Integer organizerId
) {
}
