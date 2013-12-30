package com.playstation;

import com.storage.StorageSorter;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 28.12.13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
public class PlayStationStorage {

    private static final int FIRST_CHAR = 0;
    private static final char N = 'N';
    private static final char V = 'V';
    private static final char A = 'A';
    private static final char D = 'D';

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
              break;
        }
         PlayStation.play();
    }

    public static void letFilterStorage(){
        System.out.println("Press either " + N + " to filter by 'name' or " + V + " to filter by 'value'");
        String enter = new Scanner(System.in).next().toUpperCase();

        switch(enter.charAt(FIRST_CHAR)){

            case N:
                filterByName();
                break;
            case V:
                filterByValue();
                break;
            default:
                Printer.printItIsInvalidEnter();
                break;
        }
        PlayStation.play();
    }

//    ======Private Methods===================

//    ------Sorting-------------

    private static void sortByName(){

        System.out.println("To sort by ascent press " + A + ", to sort by descent press " + D);
        String enter = new Scanner(System.in).next();

        switch(enter.toUpperCase().charAt(FIRST_CHAR)){
            case A:
                StorageSorter.sortByNameAscent();
                break;
            case D:
                StorageSorter.sortByNameDescent();
                break;
            default:
                Printer.printItIsInvalidEnter();
                break;
        }

        Printer.printStorageByRequest();
    }

    private static void sortByValue(){
        System.out.println("To sort by ascent press " + A + ", to sort by descent press " + D);
        String enter = new Scanner(System.in).next();

        switch(enter.charAt(FIRST_CHAR)){
            case A:
                StorageSorter.sortByValueAscent();
                break;
            case D:
                StorageSorter.sortByValueDescent();
                break;
            default:
                Printer.printItIsInvalidEnter();
                break;
        }

        Printer.printStorageByRequest();
    }

//    ---------Filtering-----------


    private static void filterByName() {
//        TODO
    }

    private static void filterByValue() {
//        TODO
    }
}
