package main.java.com.ticketing;

public class Main {
    public static void main(String[] args) {
        TicketManagementSystem system = new TicketManagementSystem();

        User user1 = new User("1", "Alice");
        User user2 = new User("2", "Bob");

        Story story = new Story("Implement login feature", user1);
        Epic epic = new Epic("User authentication", user2);
        OnCall onCall = new OnCall("Fix production bug", user1);

        system.createTicket(story);
        system.createTicket(epic);
        system.createTicket(onCall);

        system.updateTicketStatus(story, StoryStatus.IN_PROGRESS);

        system.addStoryToSprint(story);

        SubTask subTask = new SubTask("Design login UI", story.getAllowedStatuses());
        system.addSubTaskToTicket(story, "Design login UI");
        system.updateSubTaskStatus(subTask, StoryStatus.IN_PROGRESS);
        system.updateSubTaskStatus(subTask, StoryStatus.DEPLOYED);

        system.updateTicketStatus(story, StoryStatus.TESTING); // Should succeed now

        system.setTicketDescription(story, "This story is about implementing the login feature.");
        system.addCommentToTicket(story, "Initial design completed.", user1);
        system.addCommentToTicket(story, "Code review pending.", user2);

        system.removeStoryFromSprint(story);
    }
}