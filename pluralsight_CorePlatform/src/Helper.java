import java.io.*;

/**
 * Created by ezequiel on 05/08/16.
 */
public class Helper {

    public static Reader openReader(String s) throws FileNotFoundException {
        return new FileReader(s);
    }

    public static Writer openWriter(String s) throws IOException {
        return new FileWriter(s);
    }
}
