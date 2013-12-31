package com.executors;

import com.entity.Entry;
import com.storage.Storage;
import com.entity.CrudDaoEntry;
import com.playstation.Printer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads file by path and stores its entries to Storage.listEntry
 */
public class Reader {


    /**
     *
     *<b>Reads file by path and stores its entries to Storage.listEntry</b>
     */
    public static void readFromFileAndLoadToStorage(){

//        Clear Storage
        Storage.getListEntry().clear();

        File file = FileChooser.chooseOriginalFileForReading();
        String line;

        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){

                Entry entry = CrudDaoEntry.createEntry(line);
                if(entry != null) Storage.getListEntry().add(entry);
            }

            bufferedReader.close();
            Printer.printStorageByRequest();

        }catch(IOException e){
            e.printStackTrace();
        }

    }


}
