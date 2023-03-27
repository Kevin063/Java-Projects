package PA3;

public class item {
    protected String name;
    protected int value;
    protected String type;
    protected String description;
    
    //getter for name
    public String getName() {
        return name;
    }
    //setter for name
    public void setName(String name) {
        this.name = name;
    }
    //getter for value
    public int getValue() {
        return value;
    }
    //setter for value
    public void setValue(int value) {
        this.value = value;
    }
    //getter for type
    public String getType() {
        return type;
    }
    //setter for type
    public void setType(String type) {
        this.type = type;
    }
    //getter for description
    public String getDescription() {
    	return this.description;
    }
    //Setter for description
    public void setDescription(String s) {
    	this.description=s;
    }
}