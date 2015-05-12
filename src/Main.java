import org.xmappr.Xmappr;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

/**
 * Created by c4q-george on 4/18/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Xmappr xm = new Xmappr(Feed.class);
        xm.addNamespace("http://www.w3.org/2005/Atom");
        URL url = HTTP.stringToURL("http://export.arxiv.org/api/query?search_query=all:electron+AND+all:neutron");
        String fetchedXML = HTTP.get(url);
        StringReader reader = new StringReader(fetchedXML);
        Feed feed = (Feed) xm.fromXML(reader);

        System.out.println(feed.entry.size()+" Results");

        for(Entry currentEntry : feed.entry){
            System.out.println(currentEntry.title);
            System.out.println(currentEntry.author);
            System.out.println(currentEntry.link.getPDF());
            System.out.println(currentEntry.id);
            System.out.println("");
        }

        //Code below to be implemented later
        //Download.downloadPDF(feed.entry.get(0).link.getPDF());
    }
}
