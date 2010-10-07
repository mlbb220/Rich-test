package rich.java;

import java.util.*;
import java.text.*;

/**
 */

public class Env {
    /**
     *  main entrance
     */
    public static void main(String[] args) {

        System.out.println("Hello, it's: " +  new Date());

        //print available locales
        Locale list[] = DateFormat.getAvailableLocales();
        System.out.println("======System available locales:======== ");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].toString() + "\t" + list[i].getDisplayName());
        }

        //print JVM default properties
        System.out.println("======System property======== ");
        System.getProperties().list(System.out);
    }
}

