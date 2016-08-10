package com.ezequiel.training.java.travel;

import java.util.Iterator;

/**
 * Created by ezequiel on 04/08/16.
 */
public class Flight implements Comparable<Flight>, Iterable<Person>{


    @Override
    public int compareTo(Flight o) {
        return 0;
    }

//    @Override
//    public Iterator<Person> iterator() {
//        return null;
//    }


    @Override
    public Iterator<Person> iterator() {
        return new Iterator<Person>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Person next() {
                return null;
            }
        };
    }



    private class FlightIterator implements Iterator{
        private int index = 0;


        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }

}
