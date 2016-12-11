package Tests;

import bin.Models.OurFeed;
import bin.Readers.RSS_Feed_Parser;

public class ReadTest {
    public static void main(String[] args) {
        RSS_Feed_Parser parser =
                new RSS_Feed_Parser("http://news.finance.ua/ru/rss");

        OurFeed feed = parser.GetNeeded();
        System.out.println(feed);
        feed.getMessages().forEach(System.out::println);

    }
}
