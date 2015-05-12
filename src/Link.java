import org.xmappr.Attribute;

/**
 * Created by c4q-george on 4/18/15.
 */
public class Link {
    @Attribute
    public String href;
    public String getPDF(){
        return href + ".pdf";
    }
}
