package com.storage;

import com.entity.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew2212
 */
public class StorageFilter {

    public static List<Entry> obtainListEntryFilteredByName(String name){
         List<Entry> filteredList = new ArrayList<Entry>();
        for(Entry e: Storage.getListEntry()){
            if(e.getName().equalsIgnoreCase(name)){
                filteredList.add(e);
            }
        }
     return filteredList;
    }

    public static List<Entry> obtainListEntryFilteredByValue(String value){
        List<Entry> filteredList = new ArrayList<Entry>();
        for(Entry e: Storage.getListEntry()){
            if(e.getValue().equalsIgnoreCase(value)){
                filteredList.add(e);
            }
        }
        return filteredList;
    }
}
