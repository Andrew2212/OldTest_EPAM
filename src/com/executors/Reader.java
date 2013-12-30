package com.executors;

import com.entity.Entry;
import com.storage.Storage;
import com.playstation.PlayStation;
import com.entity.CrudDaoEntry;
import com.executors.utils.FileChooser;
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
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);

                Entry entry = CrudDaoEntry.createEntry(line);
                if(entry != null) Storage.getListEntry().add(entry);
            }

            if(bufferedReader != null)bufferedReader.close();
            Printer.printStorageByRequest();

        }catch(IOException e){
            e.printStackTrace();
        }

    }


}
