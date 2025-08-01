package Antonio.U5_W3_D5_progetto.payloads;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record NewEventDTO(
        @NotEmpty(message = "Il titolo è obbligatorio")
        String titolo,
        @NotEmpty(message = "La descrizione è obbligatoria")
        String descrizione,
        @NotEmpty(message = "La data va inserita pefforza")
        LocalDate date,
        @NotEmpty(message = "La location è importante")
        String location,
        @NotEmpty(message = "inserisci i posti totali")
        Integer totalSeats) {
}
