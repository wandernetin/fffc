package util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataUtilTest {

    DataUtil dataUtil;

    @Before
    public void initializeVariables() {
        dataUtil = new DataUtil();
    }

    @Test
    public void stringFormatterWithCommaTest() {
        //dataUtil will receive this String
        String withCommaWithTrailingSpaces = "This phrase has comma,      ";
        //dataUtil must return this String
        String withCommaWithoutTrailingSpaces = "\"This phrase has comma,\"";

        Assert.assertEquals("Phrase has a comma, must has double quotes and trimmed", withCommaWithoutTrailingSpaces,
                dataUtil.stringFormatter(withCommaWithTrailingSpaces));
    }

    @Test
    public void stringFormatterWithoutCommaTest() {
        //dataUtil will receive this String
        String withoutCommaWithTrailingSpaces = "This phrase doesn't have comma     ";
        //dataUtil must return this String
        String withoutCommaWithoutTrailingSpaces = "This phrase doesn't have comma";

        Assert.assertEquals("Phrase doesn't have a comma, must has be trimmed", withoutCommaWithoutTrailingSpaces,
                dataUtil.stringFormatter(withoutCommaWithTrailingSpaces));
    }

    @Test
    public void dateFormatterTest() {
        String inputDate = "2018-05-18";
        String expectedDate = "18/05/2018";

        Assert.assertTrue("Expected date is not equal input date",
                expectedDate.equals(dataUtil.dateFormatter(inputDate)));
    }


}
