package main.java.com.ticketing;

import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private List<Story> stories;

    public Sprint() {
        this.stories = new ArrayList<>();
    }

    public void addStory(Story story) {
        stories.add(story);
    }

    public void removeStory(Story story) {
        stories.remove(story);
    }

    public List<Story> getStories() {
        return stories;
    }
}
