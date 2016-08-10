package com.ezequiel.training.java8.pluralsight.coreplatform;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by ezequiel on 06/08/16.
 */
public class CommandLine {

    public static final String WELCOME_MESSAGE = "welcomeMessage";
    public static final String FAREWELL_MESSAGE = "farewellMessage";

    public static final String USER_PROPS_XML = "UserProps.xml";
    public static final String MY_DEFAULT_VALUES_XML = "MyDefaultValues.xml";
    public static final String IS_FIRST_RUN = "isFirstRun";

    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            showUsage();
            return;
        }
        String filename = args[0];

        if(!Files.exists(Paths.get(filename))){
            System.out.println(String.format("File %s does not exist", filename));
            return;
        }

        showFileLine(filename);
        writepropertiesXml();

        testLoadPropertiesFromResource();
    }

    private static void testLoadPropertiesFromResource() {
        Properties properties = loadFromClassResourceAsStream(MY_DEFAULT_VALUES_XML);

        if(properties == null){
            properties = createXml(MY_DEFAULT_VALUES_XML);
        }

        Properties userProps = new Properties(properties);
        loadUserProps(userProps);

        String welcomeMessage = userProps.getProperty(WELCOME_MESSAGE);
        String farewellMessage = userProps.getProperty(FAREWELL_MESSAGE);

        System.out.println(welcomeMessage);
        System.out.println(farewellMessage);

        if (!"Y".equalsIgnoreCase(userProps.getProperty(IS_FIRST_RUN))){
            userProps.setProperty(WELCOME_MESSAGE, "Welcome Back");
            userProps.setProperty(FAREWELL_MESSAGE, "Things will be familiar now");
            saveUserProps(userProps);
        } else {
            userProps.setProperty(IS_FIRST_RUN, "Y");
            saveUserProps(userProps);
        }
    }


    private static void saveUserProps(Properties userProps) {
        try (OutputStream out = Files.newOutputStream(Paths.get(USER_PROPS_XML))){
            userProps.storeToXML(out, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadUserProps(Properties userProps) {

        Properties properties = loadFromClassResourceAsStream(USER_PROPS_XML);

        if (properties == null){
            properties = createXml(USER_PROPS_XML);
        }

        try(InputStream in = Files.newInputStream(Paths.get(USER_PROPS_XML))){
            userProps.loadFromXML(in);
        } catch (IOException e) {
            System.out.println(
                    String.format(
                            "Exception <%s> %s", e.getClass().getSimpleName(), e.getMessage()));
        }
    }


    private  static void writeproperties(){
        Properties properties = new Properties();
        properties.setProperty("displayName", "Jim Wilson");
        properties.setProperty("accountNumber", "123-45-6789");


        try (Writer writer = Files.newBufferedWriter(Paths.get("xyz.properties"))){

            properties.store(writer, "My Comment");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private  static void loadproperties(){
        Properties properties = new Properties();

        try (Reader reader = Files.newBufferedReader(Paths.get("myapp.properties"))){
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  static void writepropertiesXml(){
        Properties properties = new Properties();
        properties.setProperty("displayName", "Jim Wilson");
        properties.setProperty("accountNumber", "123-45-6789");


        try (OutputStream os = Files.newOutputStream(Paths.get("xyz.xml"))){
            properties.storeToXML(os, "My Comment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void printArgs(String[] args){

        if(args != null && args.length > 0){
            for (final String a: args
                    ) {
                System.out.println(a);
            }
        }
    }

    private static void createPropertiesFromDefaultProperties(){
        Properties defaults = new Properties();
        defaults.setProperty("position", "1");

        Properties props = new Properties(defaults);
        String position = props.getProperty("position");
        System.out.println(position);

        props.setProperty("position", "2");
    }

    private static void showFileLine(final String filename){
        System.out.println();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))){
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (final IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
//            e.printStackTrace();
        }

    }

    private static void showUsage(){
        System.out.println();
        System.out.println("Please provide the filename to process on the command line");
    }

    private static Properties createXml(final String filename) {
        Properties properties = new Properties();
        try (OutputStream outputStream = Files.newOutputStream(Paths.get(filename))){
            properties.storeToXML(outputStream, "Created properties");
        } catch (Exception e) {
            System.out.println(
                    String.format(
                            "Exception <%s> %s", e.getClass().getSimpleName(), e.getMessage()));
            e.printStackTrace();
            return null;
        }
        return properties;
    }

    private static Properties loadFromClassResourceAsStream(final String filename){
        Properties properties = new Properties();
        try (InputStream inputStream = CommandLine.class.getResourceAsStream(filename)){
            properties.loadFromXML(inputStream);
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
        return properties;
    }

}
