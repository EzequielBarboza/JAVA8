package com.ezequiel.training.java8.pluralsight.coreplatform;

/**
 * Created by ezequiel on 07/08/16.
 *
 *
 * the ways
 *
 * system properties
 *
 * System.getProperty
 *  user
 *  java installation
 *  os configuration information
 *
 */
public class ClassLoadingAndEnvironment {

    private static void main(String[] args){

        System.getProperty("user.name");
        System.getProperty("os.arch");
        System.getProperty("java.vendor");


        /**
         * sometimes
         *
         * */

        System.getenv();

//        COMPUTERNAME
//        SystemRoot

    }

}
