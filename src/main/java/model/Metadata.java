package model;

/**
 * This class represents a metadata.
 */
public class Metadata {

    private String name;

    private int length;

    private TypeEnum type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(String type) {
        if(type.equals("string")) {
            this.type = TypeEnum.STRING;
        } else if(type.equals("date")) {
            this.type = TypeEnum.DATE;
        } else if(type.equals("numeric")) {
            this.type = TypeEnum.NUMERIC;
        }
    }

    public Metadata(String name, int length, String type) {
        this.name = name;
        this.length = length;
        setType(type);
    }

    public Metadata() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Metadata metadata = (Metadata) o;

        if (length != metadata.length) return false;
        if (name != null ? !name.equals(metadata.name) : metadata.name != null) return false;
        return type == metadata.type;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + length;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
