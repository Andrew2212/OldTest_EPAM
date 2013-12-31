package com.playstation;

import com.entity.Entry;
import com.storage.Storage;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * Prints values of the Storage.listEntry as pairs 'Name' = 'Value'
 */
public class Printer {

    public static final String SKIP = "s";
    public static final String PRINT = "p";


//    ==================Prints some request================

    /**
     * Prints all entry from Storage.listEntry by request
     */
    public static void printStorageByRequest() {

        System.out.println("If you want to print what you have stored - press '" + PRINT + "'(if not - press any key)");
        String strEnter = new Scanner(System.in).next();

        if (!strEnter.equalsIgnoreCase(PRINT)) {
            System.out.println("You don't want to print values of Storage");
            return;
        }

        printListEntry(Storage.getListEntry());
    }

    public static void enterPathName() {
        System.out.println("Enter file pathName or '" + SKIP + "' if you wont to use default path");
    }

//    =========Prints come results====================

    /**
     * @param list list of 'Entry' for print
     *             Just prints listEntry values
     */
    public static void printListEntry(List<Entry> list) {
        //        Print all entry from list
        System.out.println("***Printed what you want to get******");
        for (Entry e : list) {
            System.out.println(e.getName() + " = " + e.getValue());
        }
        System.out.println("***");
    }

    public static void printFileName(File file) {
        System.out.println("You have chosen file = " + file.getAbsolutePath());
    }

    public static void printEntry(Entry entry) {
        System.out.println("Current used Entry: " + entry.getName() + "  = " + entry.getValue());
    }

    public static void printItIsInvalidEnter() {
        System.out.println("***You entered a little bit odd something!");
    }
}
