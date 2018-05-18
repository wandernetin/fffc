package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetadataTest {

    private Metadata metadata;

    String typeString = "string";
    String typeNumeric = "numeric";
    String typeDate = "date";

    @Before
    public void initializeVariables() {
        metadata = new Metadata();
    }

    @Test
    public void setTypeString() {
        metadata.setType(typeString);
        Assert.assertTrue("setType is not setting a String TypeEnum", metadata.getType().equals(TypeEnum.STRING));
    }

    @Test
    public void setTypeDate() {
        metadata.setType(typeDate);
        Assert.assertTrue("setType is not setting a Date TypeEnum", metadata.getType().equals(TypeEnum.DATE));
    }

    @Test
    public void setTypeNumeric() {
        metadata.setType(typeNumeric);
        Assert.assertTrue("setType is not setting a Numeric TypeEnum", metadata.getType().equals(TypeEnum.NUMERIC));
    }
}
