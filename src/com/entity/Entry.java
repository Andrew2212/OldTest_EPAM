package com.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew2212
 */
public class Entry {
    private String name = "name default";
    private String value = "value default";

    public Entry(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Entry() {

    }

//    ==========Equals and HashCode================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;

        Entry entry = (Entry) o;

        if (!name.equalsIgnoreCase(entry.name)) return false;
        if (!value.equalsIgnoreCase(entry.value)) return false;

        return true;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    //    ========Getters and Setters=====================

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
