package com.executors;

import com.entity.Entry;
import com.storage.Storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew2212
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
