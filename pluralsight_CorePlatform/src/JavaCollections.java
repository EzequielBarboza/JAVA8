import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ezequiel on 06/08/16.
 */
public class JavaCollections {

    /**
     * Collections hold and organize values
     *
     * some provide ordering,
     * some prevent duplicate
     * some manage data as name/value pairs
     *
     * Collections use generics
     * */
    public static void main(String [] args){

        arraylist();


    }

    private static void arraylist() {

        ArrayList list = new ArrayList();
        list.add("Foo");
        list.add(1);

        System.out.println("Elements: " + list.size());

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Foo");
        list2.add("Bar");

        for(String o: list2){
            System.out.println(o);
        }
    }

    /**
     * Collections interface
     * size, clear, isEmpty
     *
     *
     * **/

    private static void collections() {
        ArrayList list = new ArrayList();
        list.add("Foo");
        list.add("Bar");

        System.out.println("Elements: " + list.size());

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Foo");
        list2.add("Bar");

        list.addAll(list2);

        for(Object o: list){
            System.out.println(o);
        }
    }


    /**
     * Collections interface
     * size, clear, isEmpty
     *
     *
     * Comparable
     *
     * **/

    private static void foreach() {
        ArrayList<MyClass> list = new ArrayList<>();
        list.add(new MyClass("1", "abc"));
        list.add(new MyClass("1", "def"));

        System.out.println("Elements: " + list.size());

        for(Object o: list){
            System.out.println(o);
        }
    }

    private static void map(){
        Map<String, String> map = new HashMap<>();

        map.put("222", "ghi");

        //bifunction
        map.forEach(
                (s, s2) -> System.out.println(s));

    }

    private static void sortedmap(){

    }

    private static class MyClass implements  Comparable<MyClass>{

        String label, value;

        public MyClass(String s, String abc) {

        }

        @Override
        public int compareTo(MyClass o) {
            return 0;
        }
    }

//    private class My
}
