package main.java.com.ticketing;

import java.util.Arrays;
import java.util.List;

public class Story extends Ticket {
    public Story(String title, User createdBy) {
        super(title, createdBy);
        this.status = StoryStatus.OPEN;
    }

    @Override
    public List<Enum<?>> getAllowedStatuses() {
        return Arrays.asList(StoryStatus.values());
    }
}
