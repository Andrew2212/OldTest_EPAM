package com.entity;

import com.playstation.Printer;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 21.12.13
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
public class Validator {

    public static boolean validateLine(String[] stringArr) {

        if ((stringArr.length < CrudDaoEntry.VALUE + 1)) return false;

        return true;
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
