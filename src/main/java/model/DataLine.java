package model;

import util.DataUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents each line from input file.
 * Line is split in fields represented by each metadata.
 */
public class DataLine {

    final private static String SEPARATOR = ",";

    private List<String> fields = new ArrayList<String>();

    private void appendField(String field) {
        fields.add(field);
    }

    //Return a exact string that will be written into a csv file.
    public String print() {
        StringBuffer buffer = new StringBuffer();
        for (String field: fields) {
            buffer.append(field);
            buffer.append(SEPARATOR);
        }
        //Remove last character, cause it's a comma.
        return buffer.toString().substring(0, buffer.toString().length()-1);
    }

    //Extract fields from a line.
    public void getFieldsFromLine(String line, List<Metadata> metadataList ) {
        for(Metadata metadata : metadataList) {
            String data = line.substring(0, metadata.getLength());
            appendField(getStringFormatted(data, metadata.getType()));
            line = line.substring(metadata.getLength());
        }
    }

    private String getStringFormatted(String data, TypeEnum type) {
        switch (type){
            case STRING:
                return new DataUtil().stringFormatter(data);
            case DATE:
                return new DataUtil().dateFormatter(data);
            case NUMERIC:
                return new DataUtil().numericFormat(data);
            default:
                return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataLine dataLine = (DataLine) o;

        return fields != null ? fields.equals(dataLine.fields) : dataLine.fields == null;
    }

    @Override
    public int hashCode() {
        return fields != null ? fields.hashCode() : 0;
    }
}
