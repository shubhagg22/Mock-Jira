package main.java.com.ticketing;

import java.util.List;

public class SubTask {
    private String title;
    private Enum<?> status;
    private List<Enum<?>> allowedStatuses;

    public SubTask(String title, List<Enum<?>> allowedStatuses) {
        this.title = title;
        this.status = allowedStatuses.get(0); // Default to the first status
        this.allowedStatuses = allowedStatuses;
    }

    public Enum<?> getStatus() {
        return status;
    }

    public boolean updateStatus(Enum<?> newStatus) {
        if (allowedStatuses.contains(newStatus)) {
            this.status = newStatus;
            return true;
        }
        return false;
    }

    // Getters and setters
}
