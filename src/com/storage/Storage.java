package com.storage;

import com.entity.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps in 'List<Entry>' entries from current file
 */
public class Storage {
    private static List<Entry> listEntry = new ArrayList();

    public static List<Entry> getListEntry() {
        return listEntry;
    }
}
