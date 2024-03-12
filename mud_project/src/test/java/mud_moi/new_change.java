package mud_moi;


import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
// import com.google.gson.Gson;

import java.util.List;
import java.lang.*;

/** class new_change */
public class new_change {

    /** test_true */
    @Test
    public void test_true() {
        org.junit.Assert.assertEquals(true,true);
    }
}

// @Test
//     public void testBoxFromJSONSimple(){
//         // use the file test1.json in ressources folder
//         String path = TestBoxes.class.getClassLoader().getResource("test1.json").getFile();
//         Box b = Box.fromJSON(path);
//         assertEquals(b.capacity(), -1);
//         assertTrue(b.isOpen());
//     }