import model.DataLine;
import model.Metadata;
import io.DataReader;
import io.MetadataReader;
import io.DataWriter;

import java.util.List;

public class FixedFileFormatConverter {

    public static void main(String args[]){
        try{
            System.out.println("Starting process!");
            String metadataFileUrl = "data/metadata.csv";
            String dataFileUrl = "data/input.dat";

            System.out.println("Reading metadata.");
            List<Metadata> metadataList = new MetadataReader().readAllMetadataFromCSVFile(metadataFileUrl);

            System.out.println("Reading Data.");
            List<DataLine> dataLines = new DataReader().readAllDataFromFile(dataFileUrl,metadataList);

            System.out.println("Writing into CSV.");
            new DataWriter().createCSVFile(metadataList, dataLines);

            System.out.println("Process done!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
