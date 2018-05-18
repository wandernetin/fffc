package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

    public String stringFormatter(String data) {
        if(data.contains(",")) {
            data = data.trim();
            return "\"" + data + "\"";
        }
        return data.trim();
    }

    public String dateFormatter(String data) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/mm/yyyy");

        try{
            Date date = inputDateFormat.parse(data);
            return outputDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String numericFormat(String data) {
        return data;
    }
}
