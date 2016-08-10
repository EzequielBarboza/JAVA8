import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ezequiel on 04/08/16.
 */
public class Main {

    private static final String FILE_1 = "/desenvolvimento/TREINAMENTO/JAVA8/pluralsight_CorePlatform/file1.txt";
    private static final String FILE_NAME2 = "/desenvolvimento/TREINAMENTO/JAVA8/pluralsight_CorePlatform/file2.txt";
    private static final String ZIP_FILE = "/desenvolvimento/TREINAMENTO/JAVA8/pluralsight_CorePlatform/zipFile.zip";;

    public static void doTryCatchFinallyReadingChars() {
        char[] buff = new char[8];
        int length;

        Reader reader = null;

        try {
            reader = Helper.openReader(FILE_1);
            while ((length = reader.read(buff)) > 0){
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++ ) {
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * We can never rely
     *
     * */
    public static void doTryWithResources(){
        char[] buff = new char[8];
        int length;

        //because we used the try with the resources
        try (Reader reader = Helper.openReader(FILE_1);){
            while ((length = reader.read(buff)) > 0){
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++ ) {
                    System.out.print(buff[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static FileSystem openZip(Path path) throws URISyntaxException, IOException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");
        URI zipUri = new URI("jar:file", path.toUri().getPath(), null);

        FileSystem fileSystem = FileSystems.newFileSystem(zipUri, providerProps);
        return fileSystem;
    }

    private static void copyToZip(FileSystem zipFs) throws IOException {
        Path path = Paths.get(FILE_1);
//        Path path = FileSystems.getDefault().getPath("file1____.txt");

        Path destFile = zipFs.getPath("/zip1Copied.txt");

        Files.copy(path, destFile, StandardCopyOption.REPLACE_EXISTING);

    }
/**
 * zips files are file system in
 *
 * */
    public static void main(String[] args) throws IOException {

        String[] data = {
          "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 5"
        };


        try (FileSystem zipFs = openZip(Paths.get(ZIP_FILE));){
            copyToZip(zipFs);
            writeToFileInZip1(zipFs, data);
            writeToFileInZip2(zipFs, data);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        doTryCatchFinallyReadingChars();

        doTryWithResources();

        doTryWithResourcesMulti();

        //Streams
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        inputStream.read();


        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };

        Closeable closeable = outputStream;

        AutoCloseable autoCloseable = outputStream;


    }

    private static void writeToFileInZip2(FileSystem zipFs, String[] data) throws IOException {
        Files.write(
                zipFs.getPath("/newFile2.txt"),
                Arrays.asList(data),
                Charset.defaultCharset(),
                StandardOpenOption.CREATE);
    }

    private static void writeToFileInZip1(FileSystem zipFs, String[] data) throws IOException {

        try (BufferedWriter writer  = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"))){
            for (String d: data){
                writer.write(d);
                writer.newLine();
            }
        }
    }


    private static void doTryWithResourcesMulti() {
        char[] buff = new char[8];
        int length;

        //because we used the try with the resources
        try (Reader reader = Helper.openReader(FILE_1);
             Writer writer = Helper.openWriter(FILE_NAME2)
        ){
            while ((length = reader.read(buff)) > 0){
                System.out.println("\nlength: " + length);
                writer.write(buff, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void doCloseThings(){
        try (MyAutoCloseable closeable = new MyAutoCloseable()){
            System.out.println();
        } catch (IOException e){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * java.io are deprecated
     *
     * BefferedStreams  improve eficiency
     * */

    /**
     *

     * FilterReader
     * */
    void doChain(InputStream in) throws  IOException{

    }

    void writeData(String[] data) throws  IOException{

            try {

                BufferedReader bufferedReader = (BufferedReader) Helper.openReader(FILE_1);


            } catch (Exception e){

            }
        }

    /**
     * Deprecated FileReader, FileWriter
     *
     * Files types
     * static methods for
     * */

    void readData(){


        FileSystem fileSystem;

        FileSystems fileSystems;



    }


}
