package main.java.com.ticketing;

import java.util.ArrayList;
import java.util.List;

public class TicketManagementSystem {
    private List<Ticket> tickets;
    private Sprint currentSprint;

    public TicketManagementSystem() {
        this.tickets = new ArrayList<>();
        this.currentSprint = new Sprint();
    }

    public void createTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void updateTicketStatus(Ticket ticket, Enum<?> newStatus) {
        if (ticket.updateStatus(newStatus)) {
            System.out.println("Status updated successfully.");
        } else {
            System.out.println("Invalid status transition.");
        }
    }

    public void addStoryToSprint(Story story) {
        if (tickets.contains(story)) {
            currentSprint.addStory(story);
            System.out.println("Story added to sprint.");
        } else {
            System.out.println("Story not found.");
        }
    }

    public void removeStoryFromSprint(Story story) {
        currentSprint.removeStory(story);
        System.out.println("Story removed from sprint.");
    }

    public void addSubTaskToTicket(Ticket ticket, String subTaskTitle) {
        SubTask subTask = new SubTask(subTaskTitle, ticket.getAllowedStatuses());
        ticket.addSubTask(subTask);
        System.out.println("Sub-task added.");
    }

    public void updateSubTaskStatus(SubTask subTask, Enum<?> newStatus) {
        if (subTask.updateStatus(newStatus)) {
            System.out.println("Sub-task status updated successfully.");
        } else {
            System.out.println("Invalid sub-task status transition.");
        }
    }

    public void removeSubTaskFromTicket(Ticket ticket, SubTask subTask) {
        ticket.removeSubTask(subTask);
        System.out.println("Sub-task removed.");
    }

    public void setTicketDescription(Ticket ticket, String description) {
        ticket.setDescription(description);
        System.out.println("Description not set");
    }

    public void addCommentToTicket(Ticket ticket, String comment, User user) {
        ticket.addComment(comment, user);
        System.out.println("Comment add.");
    }

    // Additional methods for managing tickets and sub-tasks
}