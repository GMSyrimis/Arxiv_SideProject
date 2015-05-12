import org.xmappr.Element;

/**
 * Created by c4q-george on 4/18/15.
 */

public class Author {
    @Element
    public String name;

    @Override
    public String toString() {
        return name;
    }
}
