import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

/**
 * box
 */
public class Box {
    /** List<Thing> content */
    private List<Thing> content;
    /** boolean open */
    private boolean open;
    /** int capacity */
    private int capacity;
    
    /**
     * constructor
     * @param capacity int
     */
    Box(int capacity) {
        this.content = new ArrayList<>();
        this.capacity = capacity;
        this.open = true;
    }
    
    /**
     * constructor
     * @param open boolean
     */
    Box(boolean open) {
        this.content = new ArrayList<>();
        this.capacity = -1;
        this.open = open;
    }
    
    /**
     * constructor
     * @param open boolean
     * @param capacity int
     */
    Box(boolean open, int capacity) {
        this.content = new ArrayList<>();
        this.capacity = capacity;
        this.open = open;
    }

    /** constructor */
    Box() {
        this.content = new ArrayList<>();
        this.capacity = -1;
        this.open = true;
    }

    /**
     * add
     * @param truc Thing
     */
    public void add(Thing truc) {
        this.content.add(truc);
    }

    /**
     * remove
     * @param i int index
     * @return Thing at index
     * @throws Exception Exception
     */
    public Thing remove(int i) throws Exception {
        return this.content.remove(i);
    }

    /**
     * isopen
     * @return boolean isopen box
     */
    public boolean isopen() {
        return this.open;
    }

    /**
     * isclose
     * @return boolean isclose box
     */
    public boolean isclose() {
        return !this.open;
    }

    /**
     * open void open box
     */
    public void open() {
        this.open = true;
    }

    /**
     * close void close box
     */
    public void close() {
        this.open = false;
    }


    
    /**
     * setCapacity 
     * @param cap int
     */
    public void setCapacity(int cap) {
        this.capacity = cap;
    }

    /**
     * capacity
     * @return int
     */
    public int capacity() {
        return this.capacity;
    }

    /**
     * hasRoomFor
     * @param truc Thing
     * @return boolean
     */
    public boolean hasRoomFor(Thing truc) {
        if (this.capacity == -1) {
            return true;
        }
        return this.capacity >= this.content.size() + truc.volume();
    }

    /**
     * actionLook
     * @return String
     */
    public String actionLook() {
        if (this.isopen()) {
            return "la boite contient: " + this.content;
        } else {
            return "la boite est fermee";
        }
    }

    /**
     * actionAdd
     * @param truc Thing
     * @return boolean
     */
    public boolean actionAdd(Thing truc) {
        if (isclose()) {
            return false;
        }
        if (hasRoomFor(truc)) {
            add(truc);
            return true;
        }
        return false;
    }

    /**
     * contains
     * @param truc Thing
     * @return boolean
     */
    public boolean contains(Thing truc) {
        return this.content.contains(truc);
    }

    // find -> Exception if close
    /**
     * find
     * @param name String
     * @return Thing
     * @throws Exception dqd Exception
     */
    public Thing find(String name) throws Exception {
        for (Thing thing : this.content) {
            if (thing.hasName(name)) return thing;
        }
        return null;
    }

}