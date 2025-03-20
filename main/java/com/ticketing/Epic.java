package main.java.com.ticketing;

import java.util.Arrays;
import java.util.List;

public class Epic extends Ticket {
    public Epic(String title, User createdBy) {
        super(title, createdBy);
        this.status = EpicStatus.OPEN;
    }

    @Override
    public List<Enum<?>> getAllowedStatuses() {
        return Arrays.asList(EpicStatus.values());
    }
}
