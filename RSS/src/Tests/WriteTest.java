package Tests;

import bin.Models.Feed;
import bin.Models.FeedMessage;
import bin.Writers.RSS_Feed_Writer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class WriteTest {
    public static void main(String[] args) {
        // create the rss feed
        String copyright = "Copyright hold by Dmytriy Vasilenko";
        String title = "RSS_parser java";
        String description = "RSS_parser java";
        String language = "en";
        String link = "xperiall.github.io";
        Calendar cal = new GregorianCalendar();
        Date creationDate = cal.getTime();
        SimpleDateFormat date_format = new SimpleDateFormat(
                "EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US);
        String pubdate = date_format.format(creationDate);
        Feed rssFeeder = new Feed(title, link, description, language,
                copyright, pubdate);

        // now add one example entry
        FeedMessage feed = new FeedMessage();
        feed.setTitle("RSSFeed");
        feed.setDescription("This is a description");
        feed.setAuthor("nonsense@somewhere.de (Dmytriy Vasilenko)");
        feed.setGuid("");
        feed.setLink("");
        rssFeeder.getMessages().add(feed);

        // now write the file
        RSS_Feed_Writer writer = new RSS_Feed_Writer(rssFeeder, "articles.rss");
        try {
            writer.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
