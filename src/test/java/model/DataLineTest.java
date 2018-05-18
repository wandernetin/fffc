package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataLineTest {

    List<Metadata> metadataList;

    String line;
    String output;

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

        line = "1988-11-28Bob            Big            -92.4";

        output = "28/11/1988,Bob,Big,-92.4";
    }

    @Test
    public void printTest() {
        DataLine dataLine = new DataLine();
        dataLine.getFieldsFromLine(line, metadataList);

        Assert.assertEquals("DataLine Print is not correct", output, dataLine.print());
    }
}
