package com.executors;

import com.Main;
import com.playstation.Printer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *Chooses file for reading and file for custom actions
 */
public class FileChooser {
    public static final String FILE_PATH_DEFAULT = "src/com/res/Default.txt";
    public static final String FILE_PATH_CUSTOM = "src/com/res/Custom.txt";
    public static final String END_OF_FILE_NAME = ".txt";


    /**
     *
     * @return file by 'pathName' or defaultFile 'Default.txt'
     */
    public static File chooseOriginalFileForReading(){

        String pathForReading = Main.getCustomPathForReading();
        if(pathForReading == null)pathForReading = FILE_PATH_DEFAULT;
        File file = new File(choosePathName(pathForReading));

        if(!file.exists() || !file.isFile() || !file.getName().endsWith(END_OF_FILE_NAME)){
            Printer.printItIsInvalidEnter();
            file = new File(FILE_PATH_DEFAULT);
        }
        Printer.printFileName(file);
        return file;
    }

    /**
     *
     * @return file by 'chosen pathName' or defaultFile 'Custom.txt'
     */
    public static File chooseCustomFileForWriting(){

        File file = new File(choosePathName(FILE_PATH_CUSTOM));

        try {
//          Atomically creates a new, empty file named by this abstract pathName
//          if and only if a file with this name does not yet exist.
            //noinspection ResultOfMethodCallIgnored
            file.createNewFile();
        } catch (IOException e) {

//            TODO *It'll be later* - correct check file path out
            e.printStackTrace();
            file = new File(FILE_PATH_CUSTOM);

            Printer.printFileName(file);
            return file;
        }

        if(!file.isFile() || !file.getName().endsWith(END_OF_FILE_NAME)){
            //noinspection ResultOfMethodCallIgnored
            file.delete();
            file = new File(FILE_PATH_CUSTOM);
        }

        Printer.printFileName(file);
        return file;
    }

//  =================Private Methods===============

    private static String choosePathName(String pathName){

        Printer.enterPathName();
        String enter = new Scanner(System.in).nextLine();

        if(!enter.equalsIgnoreCase(Printer.SKIP))pathName = enter;

        return pathName;
    }

}
