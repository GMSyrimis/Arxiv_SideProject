import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by c4q-george on 3/31/15.
 */
public class WebSanitizer {

    public class Papers{

        HashMap<String,URL> papersByAuthor;

        public Papers(){
            this.papersByAuthor = new HashMap<String, URL>();
        }

        public void addPaper(String title, URL address){
            this.papersByAuthor.put(title,address);
        }

        public URL getPaperURL(String title){
            return this.papersByAuthor.get(title);
        }

    }


    public static String getENTRY(String website){

        URL url = HTTP.stringToURL(website);
        String fetchedURL = HTTP.get(url);

        while(fetchedURL.indexOf("</entry>")!=-1){
            // The structure of XML is:
            // entry
            // id
            // title
            // author
            // name
            // end of entry
            int currentEntry = fetchedURL.indexOf("<entry>");

            // ID
            int startID =fetchedURL.indexOf("<id>",currentEntry)+4;
            int endID= fetchedURL.indexOf("</id>",startID);
            URL idURL = HTTP.stringToURL(fetchedURL.substring(startID,endID));

            // TITLE
            int startTITLE = fetchedURL.indexOf("<title>",currentEntry)+7;
            int endTITLE = fetchedURL.indexOf("</title>",startTITLE);
            String title = fetchedURL.substring(startTITLE,endTITLE);
            // AUTHOR
            int startAUTHOR = fetchedURL.indexOf("<author>")+8;
            int endAUTHOR = fetchedURL.indexOf("</author>");
            String authorBLOCK = fetchedURL.substring(startAUTHOR,endAUTHOR);
            while(authorBLOCK.indexOf("</name>")!=-1){
                int startNAME = authorBLOCK.indexOf("<name>")+6;
                int endNAME = authorBLOCK.indexOf("</name>");
                String authorNAME = authorBLOCK.substring(startNAME,endNAME);
                authorBLOCK = authorBLOCK.replace(authorNAME,"");
            }

            // end of entry
            int endCurrentEntry = fetchedURL.indexOf("</entry>",currentEntry)+8;
            String fullEntry = fetchedURL.substring(currentEntry,endCurrentEntry);


            fetchedURL = fetchedURL.replace(fullEntry,"");

        }

        return fetchedURL;
    }

    public static void main(String[] args){

        System.out.println(getENTRY("http://export.arxiv.org/api/query?search_query=all:electron+AND+all:proton"));
    }
}
