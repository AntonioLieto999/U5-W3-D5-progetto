package Antonio.U5_W3_D5_progetto.payloads;

import jakarta.validation.constraints.NotEmpty;

public record PostiEventoDTO(
        @NotEmpty(message = "ID è obbligatorio")
        Integer id
) {
}
