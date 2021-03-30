package ua.com.lena.flights.service.util;

import ua.com.lena.flights.entities.FlightStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StatusFactory {
    static Map<FlightStatus, Status> statusMap = new HashMap<>();
    static {
        statusMap.put(FlightStatus.DELAYED, new Delayed());
        statusMap.put(FlightStatus.ACTIVE, new Active());
        statusMap.put(FlightStatus.COMPLETED, new Completed());
    }

    public static Status getStatus(FlightStatus status) {
        return Optional.ofNullable(statusMap.get(status))
                .orElseThrow(() -> new RuntimeException());
    }
}
