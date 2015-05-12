import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by c4q-george on 4/19/15.
 */
public class Download {

    public static void downloadPDF(String pdfURL) throws IOException {

        System.out.println("opening connection");
        URL url = new URL(pdfURL);
        InputStream in = url.openStream();
        System.out.println("reading file...");
        int length = -1;
        byte[] buffer = new byte[1024];
        FileOutputStream fos = new FileOutputStream(new File("yourFile.pdf"));
        while((length=in.read(buffer))>-1){
            fos.write(buffer, 0, length);
        }
        fos.close();
        in.close();
        System.out.println("file was downloaded");
    }




}
