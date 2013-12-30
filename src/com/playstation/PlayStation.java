package com.playstation;

import com.entity.CrudDaoEntry;
import com.executors.Reader;
import com.executors.Writer;

import java.util.Scanner;

/**
 * Introduces the game and chooses an executor of selected action
 */
public class PlayStation {

    private static final String WE_ARE_GOING_TO = "We are going to do an currentAction: ";
    private static Action currentAction;

    public enum Action {
        READ_FROM_FILE("read"), PRINT_STORAGE_VALUE("print"), WRITE_TO_FILE("write"), ADD_ENTRY("add"),
        DELETE_ENTRY("del"), DELETE_INVALID_ENTRIES("clear"), SORTING("sort"), FILTER("filter"), QUIT("quit");
        public String string;

        Action(String string) {
            this.string = string;
        }

        public String getString() {
            return string;
        }
    }

//=============Public Methods=========================

    public static void firstPlay() {
        System.out.println("Do you want to to read file? press Y/any key (if you don't)");
        String enter = new Scanner(System.in).next();
        if (enter.equalsIgnoreCase("Y")) {
            Reader.readFromFileAndLoadToStorage();
        }

    }


    public static void play() {

        boolean enterIsCorrect = false;
        printActionChoice();

//      Get user's entered string and choose 'currentAction'
        while (!enterIsCorrect) {
            String string = new Scanner(System.in).nextLine();
            enterIsCorrect = chooseAction(string);
        }

//     Whether user wants to quit
        if (currentAction.equals(Action.QUIT)) return;

//     Go to the current action executor
        goToActionExecutor(currentAction);
    }

//    =========Private Methods===========================

    /**
     * Just prints introductory text
     */
    private static void printActionChoice() {
        System.out.println("***\nChoose Action:");
        System.out.println("*Read from file and load to Storage: enter READ");
        System.out.println("*Storage - print values: enter PRINT");
        System.out.println("*Storage - write values into some other file: enter WRITE");
        System.out.println("*Storage - add new entry: enter ADD");
        System.out.println("*Storage - delete some entry: enter DEL");
        System.out.println("*Storage - delete all invalid entries: enter CLEAR");
        System.out.println("*Storage - sorting by some parameter: enter SORT");
        System.out.println("*Storage - filtering: enter FILTER");
        System.out.println("*Quit the game: enter QUIT");
    }

    /**
     * @param string user's entered string
     * @return true if string is correct (corresponds 'Action' strings)
     *         <b>Sets chosen action as value of 'currentAction'</b>
     */
    private static boolean chooseAction(String string) {
        for (Action a : Action.values()) {
            String s = a.getString();
            if (s.equalsIgnoreCase(string)) {
                currentAction = a;
                System.out.println(WE_ARE_GOING_TO + a.toString());
                return true;
            }
        }
        System.out.println("That'll never fly! Let's try again!");
        return false;
    }

    private static void goToActionExecutor(Action currentAction) {

        switch (currentAction) {
            case READ_FROM_FILE:
                Reader.readFromFileAndLoadToStorage();
                break;
            case PRINT_STORAGE_VALUE:
                Printer.printStorage();
                play();
                break;
            case WRITE_TO_FILE:
                Writer.writeToFileFromStorage();
                break;
            case ADD_ENTRY:
                CrudDaoEntry.addEntryToStorage();
                break;
            case DELETE_ENTRY:
                CrudDaoEntry.deleteEntryFromStorage();
                break;
            case DELETE_INVALID_ENTRIES:
                CrudDaoEntry.deleteAllInvalidEntriesFromStorage();
                break;
            case SORTING:
                PlayStationStorage.letSortStorage();
                break;
            case FILTER:
//                TODO filtering
                break;
        }

    }

    /**
     * @return entered Entry as <Name> = <Value>
     */
    public static String obtainEntryAsString() {
        System.out.println("Enter required Entry as <Name> = <Value>");
        String stringEntry = new Scanner(System.in).nextLine();
        return stringEntry;
    }

    /**
     * @return entered String 'name' for the new Entry
     */
    public static String obtainEntryName() {
        System.out.println("Enter 'name' for the required Entry");
        String entryName = new Scanner(System.in).nextLine();
        return entryName;
    }
}