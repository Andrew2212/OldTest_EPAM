package com.storage;

import com.entity.Entry;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 21.12.13
 * Time: 18:54
 * To change this template use File | Settings | File Templates.
 */
public class StorageSorter {

    public static List<Entry> list = Storage.getListEntry();

    public static Comparator<Entry> comparatorByName = new Comparator<Entry>() {
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
    };

    public static Comparator<Entry> comparatorByValue = new Comparator<Entry>() {

        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getValue().toLowerCase().compareTo(o2.getValue().toLowerCase());
        }
    };

    public static List sortByNameAscent() {
//      Sorts the specified list according to the order induced by the specified comparator.
        Collections.sort(list, comparatorByName);
        return list;
    }

    public static List sortByNameDescent() {

        Collections.reverse(sortByNameAscent());
        return list;
    }


    public static List sortByValueAscent() {
        //      Sorts the specified list according to the order induced by the specified comparator.
        Collections.sort(list, comparatorByValue);
        return list;
    }

    public static List sortByValueDescent() {

        Collections.reverse(sortByValueAscent());
        return list;
    }

}
