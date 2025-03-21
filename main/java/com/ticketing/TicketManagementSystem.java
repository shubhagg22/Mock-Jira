package main.java.com.ticketing;

import java.util.ArrayList;
import java.util.List;

public class TicketManagementSystem {
    private List<Ticket> tickets;
    private Sprint currentSprint;

    public TicketManagementSystem() {
        this.tickets = new ArrayList<>();
        this.currentSprint = new Sprint();
        System.out.println("Ticket Management System initialized.");
    }

    public void createTicket(Ticket ticket) {
        tickets.add(ticket);
        System.out.println("Ticket created: " + ticket.getClass().getSimpleName() +
                " - \"" + ticket.title + "\" by " + ticket.createdBy.getName());
    }

    public void updateTicketStatus(Ticket ticket, Enum<?> newStatus) {
        System.out.println("Attempting to update " + ticket.getClass().getSimpleName() +
                " \"" + ticket.title + "\" status from " +
                ticket.status + " to " + newStatus);

        if (ticket.updateStatus(newStatus)) {
            System.out.println("Status updated successfully to " + newStatus);
        } else {
            System.out.println("Invalid status transition. Status remains " + ticket.status);
        }
    }

    public void addStoryToSprint(Story story) {
        System.out.println("Attempting to add Story \"" + story.title + "\" to sprint");

        if (tickets.contains(story)) {
            currentSprint.addStory(story);
            System.out.println("Story successfully added to sprint. Current sprint now has " +
                    currentSprint.getStories().size() + " stories.");
        } else {
            System.out.println("Story not found in the system. Cannot add to sprint.");
        }
    }

    public void removeStoryFromSprint(Story story) {
        System.out.println("Attempting to remove Story \"" + story.title + "\" from sprint");

        currentSprint.removeStory(story);
        System.out.println("Story successfully removed from sprint. Current sprint now has " +
                currentSprint.getStories().size() + " stories.");
    }

    public void addSubTaskToTicket(Ticket ticket, String subTaskTitle) {
        System.out.println("Adding sub-task \"" + subTaskTitle + "\" to " +
                ticket.getClass().getSimpleName() + " \"" + ticket.title + "\"");

        SubTask subTask = new SubTask(subTaskTitle, ticket.getAllowedStatuses());
        ticket.addSubTask(subTask);
        System.out.println("Sub-task successfully added. Status: " + subTask.getStatus());
    }

    public void updateSubTaskStatus(SubTask subTask, Enum<?> newStatus) {
        System.out.println("Attempting to update sub-task status from " +
                subTask.getStatus() + " to " + newStatus);

        if (subTask.updateStatus(newStatus)) {
            System.out.println("Sub-task status successfully updated to " + newStatus);
        } else {
            System.out.println("Invalid sub-task status transition. Status remains " +
                    subTask.getStatus());
        }
    }

    public void removeSubTaskFromTicket(Ticket ticket, SubTask subTask) {
        System.out.println("Removing sub-task from " + ticket.getClass().getSimpleName() +
                " \"" + ticket.title + "\"");

        ticket.removeSubTask(subTask);
        System.out.println("Sub-task successfully removed.");
    }

    public void setTicketDescription(Ticket ticket, String description) {
        System.out.println("Setting description for " + ticket.getClass().getSimpleName() +
                " \"" + ticket.title + "\"");

        ticket.setDescription(description);
        System.out.println("Description successfully set.");
    }

    public void addCommentToTicket(Ticket ticket, String comment, User user) {
        System.out.println("Adding comment by " + user.getName() + " to " +
                ticket.getClass().getSimpleName() + " \"" + ticket.title + "\"");

        ticket.addComment(comment, user);
        System.out.println("Comment successfully added: \"" + comment + "\"");
    }

    // Added method to display system state
    public void displaySystemState() {
        System.out.println("\n====== TICKET MANAGEMENT SYSTEM STATE ======");

        System.out.println("\n--- TICKETS (" + tickets.size() + " total) ---");
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getClass().getSimpleName() + " - \"" +
                    ticket.title + "\" (Status: " + ticket.status +
                    ", Created by: " + ticket.createdBy.getName() + ")");

            if (ticket.description != null && !ticket.description.isEmpty()) {
                System.out.println("  Description: " + ticket.description);
            }

            if (!ticket.comments.isEmpty()) {
                System.out.println("  Comments (" + ticket.comments.size() + "):");
                for (String c : ticket.comments) {
                    System.out.println("    - " + c);
                }
            }

            if (!ticket.subTasks.isEmpty()) {
                System.out.println("  Sub-tasks (" + ticket.subTasks.size() + "):");
                for (SubTask subTask : ticket.subTasks) {
                    System.out.println("    - \"" + subTask.getTitle() +
                            "\" (Status: " + subTask.getStatus() + ")");
                }
            }
        }

        System.out.println("\n--- CURRENT SPRINT ---");
        List<Story> stories = currentSprint.getStories();
        if (stories.isEmpty()) {
            System.out.println("No stories in current sprint.");
        } else {
            System.out.println("Stories in sprint (" + stories.size() + "):");
            for (Story story : stories) {
                System.out.println("  - \"" + story.title + "\" (Status: " +
                        story.status + ")");
            }
        }

        System.out.println("\n===========================================");
    }
}
