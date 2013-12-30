package com.executors;

import com.entity.Entry;
import com.storage.Storage;
import com.playstation.PlayStation;
import com.executors.utils.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 21.12.13
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
public class Writer {

    public static void writeToFileFromStorage(){

        File file = FileChooser.chooseCustomFileForWriting();
        System.out.println("WRITER::file = " + file.getAbsolutePath());
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = null;

            for(Entry e: Storage.getListEntry()){
                line = e.getName() + " = " + e.getValue();
                bufferedWriter.write(line);
                bufferedWriter.newLine();

            }

            bufferedWriter.flush();
            if(bufferedWriter != null)bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
