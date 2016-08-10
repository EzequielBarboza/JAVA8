import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formattable;
import java.util.Formatter;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ezequiel on 05/08/16.
 */
public class Main2 {


    public static void  main(String[] args){

        StringJoiner stringJoiner = new StringJoiner("], [", "[", "]");

        int david =  13, dawson = 11, gordon = 2;

        String s2 = String.format("My newphews are %d, %d, %d years old", david, dawson, gordon);

        String hash = "#";

        for (int i = 0 ; i < 6; i++){
            System.out.println(String.format("%6s", hash));
            hash += "#";
        }

//        Formatter
    }

    void doWrite() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("file10.txt"));
        try (Formatter f = new Formatter(writer)){

        }
    }

    /***/
    static {
        String s1 = "apple apple and orange please";

        String[] s2 = s1.split("\\b");

//        for (:
//             ) {
//
//        }


//        Dedicated REgular expression

        Pattern pattern = Pattern.compile("\\w+");

        Matcher matcher = pattern.matcher(s1);

        while (matcher.find()){
            System.out.println(matcher.group());
        }


    }

    private class MyFormattable implements Formattable{

        @Override
        public void formatTo(Formatter formatter, int flags, int width, int precision) {

        }
    }

}
