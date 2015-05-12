import org.xmappr.Attribute;
import org.xmappr.Element;
import org.xmappr.RootElement;

import java.util.List;

/**
 * Created by c4q-george on 4/18/15.
 */

public class Entry {
    @Element
    public String id;
    @Element
    public String title;
    @Element
    public List<Author> author;
    @Element
    public Link link;

}
