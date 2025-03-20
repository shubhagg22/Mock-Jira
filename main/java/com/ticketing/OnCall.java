package main.java.com.ticketing;

import java.util.Arrays;
import java.util.List;

public class OnCall extends Ticket {
    public OnCall(String title, User createdBy) {
        super(title, createdBy);
        this.status = OnCallStatus.OPEN;
    }

    @Override
    public List<Enum<?>> getAllowedStatuses() {
        return Arrays.asList(OnCallStatus.values());
    }
}