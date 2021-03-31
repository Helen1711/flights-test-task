package ua.com.lena.flights.exceptions.messages;

public class ExceptionMessage {
    private ExceptionMessage() {
    }

    public static final String AIRCOMPANY_BY_ID_NOT_FOUND = "Not found aircompany with id ";
    public static final String AIRCOMPANY_WITH_NAME_EXISTS = "Aircompany with name already exists ";

    public static final String AIRPLANE_WITH_SERIAL_NUMBER_EXISTS = "Airplane with serial number already exists ";
    public static final String AIRPLANE_BY_ID_NOT_FOUND = "Not found airplane with id ";

    public static final String FLIGHT_DISTANCE_LENGTH_EXCESS = "Flight distance is too long ";
    public static final String FLIGHT_BY_ID_NOT_FOUND = "Not found flight with id ";

    public static final String FLIGHT_STATUS_NOT_FOUND = "Flight status not found  ";
}
