package com.entity;

import com.storage.Storage;
import com.playstation.PlayStation;
import com.playstation.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 21.12.13
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class CrudDaoEntry {
    private static final int NAME = 0;
    public static final int VALUE = 1;
    private static final String INVALID_NAME = "Invalid Entry::";

    /**
     * @param line is required Entry name
     * @return 'new Entry(stringArr[NAME], stringArr[VALUE])' where stringArr = line.split("=")
     */
    public static Entry createEntry(String line) {
        String[] stringArr = line.split("=");

        if (Validator.validateLine(stringArr)){
            String name = Validator.checkOrUpdateName(stringArr[NAME]);
            return new Entry(name, stringArr[VALUE].trim());

        } else {
            return new Entry(INVALID_NAME, line);
        }
    }


    public static void addEntryToStorage() {
        //Create Entry from String line that is entered into PlayStation
        Entry entry = createEntry();
        //Add Entry into Storage
        Storage.getListEntry().add(entry);
        Printer.printStorageByRequest();
    }

    public static void deleteEntryFromStorage() {

        //Get deleted entry name
        String deletedEntryName = PlayStation.obtainEntryName();
        deleteEntryFromStorage(deletedEntryName);
    }

    public static void deleteAllInvalidEntriesFromStorage() {
        String invalidName = INVALID_NAME;
        deleteEntryFromStorage(invalidName);

    }

//    =======Getters and Setters==========
    public static String getInvalidName(){
        return INVALID_NAME;
    }

//    =======Private Methods============

    private static Entry createEntry() {
        String line = PlayStation.obtainEntryAsString();
        return createEntry(line);
    }

    private static void deleteEntryFromStorage(String deletedEntryName) {

        List<Entry> tempList = new ArrayList<Entry>();
        //Add all entry with 'deletedEntryName' from Storage into the tempList
        for (int i = 0; i < Storage.getListEntry().size(); i++) {
            Entry entry = Storage.getListEntry().get(i);
            if (entry.getName().startsWith(deletedEntryName)) {
                Printer.printEntry(entry);
                tempList.add(entry);
            }
        }

        if (0 < tempList.size()) {
            Storage.getListEntry().removeAll(tempList);
        } else {
            Printer.printItIsInvalidEnter();
        }
    }

}
