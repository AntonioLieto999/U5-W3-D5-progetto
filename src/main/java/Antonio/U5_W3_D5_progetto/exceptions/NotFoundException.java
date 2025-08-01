package Antonio.U5_W3_D5_progetto.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("La risorsa con id " + id + " non è stata trovata!");
    }
}
