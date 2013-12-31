package com.entity;

import com.playstation.Printer;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew2212
 */
public class Validator {

    public static boolean validateLine(String[] stringArr) {

        return (stringArr.length >= CrudDaoEntry.VALUE + 1);
    }

    public static String checkOrUpdateName(String entryName) {
          String name = entryName.trim();
//        TODO *It'll be later* - correct check 'name'
        if(name.length() < 2){
            Printer.printItIsInvalidEnter();
            return CrudDaoEntry.getInvalidName() + name;
        }

     return name;
    }
}
