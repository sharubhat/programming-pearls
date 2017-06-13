package com.coffee.code.repeat.programmingpearls.column1.memoryconstrainedsort;

import com.coffee.code.repeat.programmingpearls.column1.lowmemoryfastsort.ShuffleArray;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ref: http://www.ashishsharma.me/2011/08/external-merge-sort.html and https://github.com/marceldiass/java-external-sorting
 * Not complete yet
 */
public class ExternalSort {
    private static final int MAX_INT = 10_000_000;
    private static final int MIN_INT = 0;
    private static final String INPUT = "/var/tmp/input.txt";
    private static final String OUTPUT = "/var/tmp/output.txt";
    private static final long AVAILABLE_MEMORY = 1024 * 1024;

    public static void main(String[] args) {
        prepareInputFile();
        List<File> l = sortInBatch(new File(INPUT)) ;
        mergeSortedFiles(l, new File(OUTPUT));
    }

    private static void mergeSortedFiles(List<File> files, File file) {

    }

    private static List<File> sortInBatch(File file) {
        List<File> files  = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<Integer> tmpList =  new ArrayList<>();
            String line = "";
            try {
                while(line != null) {
                    long usedMemory = 0;// in bytes
                    while((usedMemory < AVAILABLE_MEMORY)
                            &&((line = br.readLine()) != null) ){ // as long as you have 1MB
                        tmpList.add(Integer.parseInt(line));
                        usedMemory += 32; // we are dealing with 32 bit integer
                    }
                    files.add(sortAndSave(tmpList));
                    tmpList.clear();
                }
            } catch(EOFException oef) {
                if(tmpList.size()>0) {
                    files.add(sortAndSave(tmpList));
                    tmpList.clear();
                }
            }
        } catch (IOException e) {

        }

        return null;
    }

    private static File sortAndSave(List<Integer> shortList) throws IOException {
        // need fast sort here
        Collections.sort(shortList);
        File newTmpFile = File.createTempFile("sortInBatch", "flatFile");
        newTmpFile.deleteOnExit();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(newTmpFile))) {
            for(int i : shortList) {
                bw.write(i);
                bw.newLine();
            }
        }
        return newTmpFile;
    }

    private static void prepareInputFile() {
        int[] arr = ShuffleArray.getShuffledArray(MIN_INT, MAX_INT);

        try(Writer fileWriter = new FileWriter(INPUT)) {
            for(int i = 0; i < arr.length; i++)
                fileWriter.write(arr[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
