package io;

import exception.OutputFileException;
import model.DataLine;
import model.Metadata;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class is a data writer. It is used to write the result csv.
 */
public class DataWriter {

    //Create and write the result csv.
    public void createCSVFile(List<Metadata> metadataList, List<DataLine> dataLines) throws OutputFileException{
        try {
            String csvFile = "data/output.csv";
            FileWriter fileWriter = new FileWriter(csvFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(returnColumnsFromMetadataNamesForFirstLine(metadataList));
            for(DataLine dataLine : dataLines) {
                bufferedWriter.newLine();
                bufferedWriter.write(dataLine.print());
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new OutputFileException("Error. File not created at data/output.csv");
        }

    }

    //This method creates first line of file. It's a columns names.
    private String returnColumnsFromMetadataNamesForFirstLine(List<Metadata> metadataList) {
        String firstLine = "";
        for (Metadata metadata : metadataList) {
            firstLine += metadata.getName();
            firstLine += ",";
        }
        //Remove last character, cause it's a comma.
        return (firstLine == "") ? firstLine : firstLine.substring(0, firstLine.length()-1);
    }
}
