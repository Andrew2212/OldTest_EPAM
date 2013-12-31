package com;

import com.playstation.PlayStation;
import com.storage.Storage;
import com.executors.FileChooser;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew2212
 */
public class Main {

    private static String customPathForReading;

    public static void main(String[] args) {

//        args = new String[]{"src/com/res/Test.txt"};
        if (args.length != 0) customPathForReading = args[0];
        setDefaultSetting();

        PlayStation.firstPlay();
    }

    public static void setDefaultSetting(){
//        clear storage
        Storage.getListEntry().clear();
//        delete default file for writing
        File file = new File(FileChooser.FILE_PATH_CUSTOM);
        //noinspection ResultOfMethodCallIgnored
        file.delete();
    }

    public static String getCustomPathForReading(){
        return customPathForReading;
    }
}
