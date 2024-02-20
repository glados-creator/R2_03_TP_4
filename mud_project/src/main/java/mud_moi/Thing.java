package mud_moi;


/**class Thing */
public class Thing {
    /** String name */
    private String name;
    /** int vol */
    private int vol;

    /**
     * Thing
     * 
     * @param name String
     * @param vol  int Volume
     */
    public Thing(String name, int vol) {
        this.name = name;
        this.vol = vol;
    }

    /**
     * Thing
     * 
     * @param name String
     */
    public Thing(String name) {
        this.name = name;
        this.vol = 1;
    }

    /**
     * Thing
     * 
     * @param vol Volume int
     */
    public Thing(int vol) {
        this.name = "truc";
        this.vol = vol;
    }

    /**
     * volume
     * 
     * @return this.volume
     */
    public int volume() {
        return this.vol;
    }

    /**
     * setName
     * 
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * String
     * 
     * @return this.name
     */
    public String getName() {
        return this.name;
    }

    /**
     * hasName
     * 
     * @param name String
     * @return boolean
     */
    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    /**
     * forked
     */
    public void forked() {
    }

    /**
     * toString
     * 
     * @return String String
     */
    @Override
    public String toString() {
        return "{" +
                "name='" + getName() + "'" +
                ", vol='" + volume() + "'" +
                "}";
    }

    /**
     * equals
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Thing)) {
            return false;
        }
        // typecast o to Complex so that we can compare data members 
        Thing c = (Thing) o;
        // Compare the data members and return accordingly 
        return this.name == c.name && this.vol == c.vol;
    }
}