import org.xmappr.Element;
import org.xmappr.RootElement;

import java.util.List;

/**
 * Created by c4q-george on 4/18/15.
 */
@RootElement
public class Feed {
    @Element
    public List<Entry> entry;

}
