
import org.xmappr.Xmappr;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

/**
 * Created by c4q-george on 4/18/15.
 */
public class Arxiv {

    public static void main(String[] args) throws IOException {
        // URL
        URL url = HTTP.stringToURL("http://export.arxiv.org/api/query?search_query=all:electron+AND+all:neutron");
        String fetchedXML = HTTP.get(url);
        // type of reader, found it by looking at other readers that implement the abstract class
        StringReader reader = new StringReader(fetchedXML);

        Xmappr xm = new Xmappr(Feed.class);
        // found this on google search
        xm.addNamespace("http://www.w3.org/2005/Atom");
        Feed feed = (Feed) xm.fromXML(reader);

        System.out.println(feed.entry.size());
        for(Entry currentEntry : feed.entry){
            System.out.println(currentEntry.link.getPDF());
        }

        Download.downloadPDF(feed.entry.get(0).link.getPDF());
    }
}
