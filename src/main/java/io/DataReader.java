package io;

import exception.DataFileException;
import model.DataLine;
import model.Metadata;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a data reader. It is used to read data from an input file.
 */
public class DataReader {

    public List<DataLine> readAllDataFromFile(String fileUrl, List<Metadata> metadataList) throws DataFileException {
        try {
            DataLine line;
            List<DataLine> lines = new ArrayList<DataLine>();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fileUrl), "UTF8"));
            String currentLine;
            // reading line by line
            while ((currentLine = br.readLine()) != null) {
                line = new DataLine();
                line.getFieldsFromLine(currentLine, metadataList);
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            throw new DataFileException("Error. File not found at data/input.dat");
        }

    }
}
