package Antonio.U5_W3_D5_progetto.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        @NotEmpty(message = "L'indirizzo email è obbligatorio")
        @Email(message = "L'indirizzo email inserito non è nel formato giusto")
        String email,
        @NotEmpty(message = "il nome utente è necessario")
        String username,
        @NotEmpty(message = "La password è obbligatoria!")
        String password,
        @NotEmpty(message = "aggiungi il ruolo")
        String role
) {
}
