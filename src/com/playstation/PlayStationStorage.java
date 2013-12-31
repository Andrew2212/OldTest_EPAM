package com.playstation;

import com.entity.Entry;
import com.storage.StorageFilter;
import com.storage.StorageSorter;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew2212
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

        switch(enter.toUpperCase().charAt(FIRST_CHAR)){
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
        System.out.println("Enter entry 'Name' for filter");
        String enter = new Scanner(System.in).next().trim();
        List<Entry> list = StorageFilter.obtainListEntryFilteredByName(enter);
        if(list.size() != 0){
            Printer.printListEntry(list);
        }else{
            Printer.printItIsInvalidEnter();
        }
    }

    private static void filterByValue() {
        System.out.println("Enter entry 'Value' for filter");
        String enter = new Scanner(System.in).next().trim();
        List<Entry> list = StorageFilter.obtainListEntryFilteredByValue(enter);
        if(list.size() != 0){
            Printer.printListEntry(list);
        }else{
            Printer.printItIsInvalidEnter();
        }
    }
}
