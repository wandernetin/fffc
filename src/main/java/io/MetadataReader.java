package io;

import exception.MetadataFileException;
import model.Metadata;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a metadata reader. It is used to read metadata from an input csv file.
 */
public class MetadataReader {

    public List<Metadata> readAllMetadataFromCSVFile(String csvFile) throws IOException, MetadataFileException {
        try{
            List<Metadata> metadataList = new ArrayList<Metadata>();
            Metadata metadata;
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";

            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(csvFile), "UTF8"));
            while ((line = br.readLine()) != null) {

                String[] fields = line.split(cvsSplitBy);

                if(fields.length == 3) {
                    metadata = new Metadata(fields[0], Integer.parseInt(fields[1]), fields[2]);
                    metadataList.add(metadata);
                }
            }
            return metadataList;
        } catch (IOException e) {
            throw new MetadataFileException("Error. File not found at data/metadata.csv");
        }

    }
}
