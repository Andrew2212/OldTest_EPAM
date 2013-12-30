package com.playstation;

import com.storage.StorageSorter;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 28.12.13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
public class PlayStationStorage {
//    TODO interface for sorter and filter

    private static final int FIRST_CHAR = 0;
    private static final char N = 'N';
    private static final char V = 'V';

    public static void letSortStorage(){
        System.out.println("Press either " + N + " to sort by 'name' or " + V + " to sort by 'value'");
        String enter = new Scanner(System.in).next().toUpperCase();

        switch(enter.charAt(FIRST_CHAR)){

            case N:
                sortByName();
                break;
            case V:
                sortByValue();
                break;
            default:
                Printer.printItIsInvalidEnter();

        }
         PlayStation.play();
    }

    private static void sortByName(){
        StorageSorter.sortByNameAscent();

        Printer.printStorageByRequest();
    }

    private static void sortByValue(){
        StorageSorter.sortByValueAscent();

        Printer.printStorageByRequest();
    }
}
