package com.entity;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 19.12.13
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
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

//    ===========Comparators========================
//    /**
//     * Next more than previous
//     */
//    public static Comparator<Entry> comparatorByNameLengthAscent;
//
//    static {
//        comparatorByNameLengthAscent = new Comparator<Entry>() {
//            @Override
//            public int compare(Entry o1, Entry o2) {
//                return o1.getName().length() - o2.getName().length();
//            }
//        };
//    }
//
//    /**
//     * Next less than previous
//     */
//    public static Comparator<Entry> comparatorByNameLengthDescent;
//
//    static {
//        comparatorByNameLengthDescent = new Comparator<Entry>() {
//            @Override
//            public int compare(Entry o1, Entry o2) {
//                return o2.getName().length() - o1.getName().length();
//            }
//        };
//    }

//    /**
//     * Next more than previous
//     */
//    public static Comparator<Entry> comparatorByValueAscent
//            = new Comparator<Entry>() {
//        @Override
//        public int compare(Entry o1, Entry o2) {
//            return o1.getValue().length() - o2.getValue().length();
//        }
//    } ;
//
//    /**
//     * Next less than previous
//     */
//    public static Comparator<Entry> comparatorByValueDescent
//            = new Comparator<Entry>() {
//        @Override
//        public int compare(Entry o1, Entry o2) {
//            return o2.getValue().length() - o1.getValue().length();
//        }
//    } ;


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

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
