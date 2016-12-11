package exec;

import bin.Models.OurFeed;
import bin.Models.OurFeedMessage;
import bin.Readers.RSS_Feed_Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class hdfsSender {
    public static void main(String[] args) throws IOException{
        RSS_Feed_Parser parser =
                new RSS_Feed_Parser("http://news.liga.net/all/rss.xml");
        List<String> lines = Files.readAllLines(Paths.get("/home/xperiall/RSS/src/out.txt"));
        OurFeed feed = parser.GetNeeded();
        lines.addAll(feed.getMessages().stream().map(OurFeedMessage::toString).collect(Collectors.toList()));
        Files.write(Paths.get("/home/xperiall/RSS/src/out.txt"), lines);
    }
}
