package Antonio.U5_W3_D5_progetto.payloads;

public record PostiEventoRespDTO(
        Integer id,
        Integer eventId,
        String eventTitle,
        Integer bookingDate
) {
}
