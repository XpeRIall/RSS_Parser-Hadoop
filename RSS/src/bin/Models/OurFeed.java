package bin.Models;

import java.util.ArrayList;
import java.util.List;


public class OurFeed {
    /*
     * Stores our RSS feed
     */
    final String title;
    final String description;


    final List<OurFeedMessage> entries = new ArrayList<>();

    public OurFeed(String title, String description) {
        this.title = title;

        this.description = description;

    }

    public List<OurFeedMessage> getMessages() {
        return entries;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Feed description=" + description + ", title=" + title + "]";
    }
}

