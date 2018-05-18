package io;

import model.Metadata;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MetadataReaderTest {

    List<Metadata> metadataList;
    MetadataReader metadataReader;

    @Before
    public void initializeVariables() {
        metadataList = new ArrayList<Metadata>();
        Metadata metadataBirthday = new Metadata("Birth date", 10, "date");
        metadataList.add(metadataBirthday);
        Metadata metadataFirstName = new Metadata("First name", 15, "string");
        metadataList.add(metadataFirstName);
        Metadata metadataLastName = new Metadata("Last name", 15, "string");
        metadataList.add(metadataLastName);
        Metadata metadataWeight = new Metadata("Weight", 5, "numeric");
        metadataList.add(metadataWeight);

        metadataReader = new MetadataReader();
    }

    @Test
    public void readAllMetadataFromCSVFileTest() {
        try{
            Assert.assertEquals("List of metadata must be equal.",
                    metadataReader.readAllMetadataFromCSVFile("data/test/metadata.csv"),(metadataList));
        } catch (Exception e) {
            System.out.print("Error test: " + e.getMessage());
        }

    }

}
