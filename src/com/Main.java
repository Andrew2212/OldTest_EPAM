package com;

import com.playstation.PlayStation;
import com.storage.Storage;
import com.executors.utils.FileChooser;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 13.12.13
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static String customPathForReading;

    public static void main(String[] args) {

//        args = new String[]{"src/com/res/Test.txt"};
        if (args.length != 0) customPathForReading = args[0];

        PlayStation.firstPlay();

        setDefaultSetting();
    }

    public static void setDefaultSetting(){
//        clear storage
        Storage.getListEntry().clear();
//        delete default file for writing
        File file = new File(FileChooser.FILE_PATH_CUSTOM);
        file.delete();
    }

    public static String getCustomPathForReading(){
        return customPathForReading;
    }
}
