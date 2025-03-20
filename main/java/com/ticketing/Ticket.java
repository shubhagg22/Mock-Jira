package main.java.com.ticketing;

import java.util.ArrayList;
import java.util.List;

public abstract class Ticket {
    protected String title;
    protected Enum<?> status;
    protected List<SubTask> subTasks;
    protected String description;
    protected List<String> comments;
    protected User createdBy;

    public Ticket(String title, User createdBy) {
        this.title = title;
        this.createdBy = createdBy;
        this.subTasks = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public abstract List<Enum<?>> getAllowedStatuses();

    public synchronized boolean updateStatus(Enum<?> newStatus) {
        if (getAllowedStatuses().contains(newStatus)) {
            if (newStatus.name().equals("DEPLOYED") || newStatus.name().equals("COMPLETED")) {
                if (!canBeClosed()) {
                    System.out.println("Cannot close ticket. Sub-tasks are not completed.");
                    return false;
                }
            }
            this.status = newStatus;
            return true;
        }
        return false;
    }

    public synchronized void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
    }

    public synchronized void removeSubTask(SubTask subTask) {
        subTasks.remove(subTask);
    }

    public boolean canBeClosed() {
        return subTasks.stream().allMatch(subTask -> subTask.getStatus().name().equals("COMPLETED"));
    }

    public synchronized void setDescription(String description) {
        this.description = description;
    }

    public synchronized void addComment(String comment, User user) {
        comments.add(user.getName() + ": " + comment);
    }

    // Getters and setters
}