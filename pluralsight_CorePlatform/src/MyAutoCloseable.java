import java.io.IOException;

/**
 * Created by ezequiel on 05/08/16.
 */
public class MyAutoCloseable implements AutoCloseable{
    @Override
    public void close() throws Exception {
        throw new IOException();
    }
}
