package mud_moi;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
// import com.google.gson.Gson;

import java.util.List;
import java.lang.*;

public class NewChange {

    /** test_true */
    @Test
    public void test_true() {
        org.junit.Assert.assertEquals(true, true);
    }

    /** testBoxFromJSONSimple*/
    @Test
    public void testBoxFromJSONSimple(){
        try {
            
            // use the file test1.json in ressources folder
            String path = NewChange.class.getClassLoader().getResource("test1.json").getFile();
            System.out.println("json path : '"+path+"'");
            Box b = Box.fromJSON(path);
            org.junit.Assert.assertEquals(b.capacity(), -1);
            org.junit.Assert.assertTrue(b.isopen());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}