import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
// import com.google.gson.Gson;

import java.util.List;
import java.lang.*;

/** class TestsBoxes */
public class TestsBoxes {

    /** test_Thing_all */
    @Test
    public void test_Thing_all() {
        Thing truc = new Thing("Truc", 99);
        org.junit.Assert.assertEquals(truc.volume(), 99);
        org.junit.Assert.assertEquals(truc.getName(), "Truc");
    }

    /** test_Thing_name */
    @Test
    public void test_Thing_name() {
        Thing truc = new Thing("Truc");
        org.junit.Assert.assertEquals(truc.volume(), 1);
        org.junit.Assert.assertEquals(truc.getName(), "Truc");
    }

    /** test_Thing_vol */
    @Test
    public void test_Thing_vol() {
        Thing truc = new Thing(42);
        org.junit.Assert.assertEquals(truc.volume(), 42);
        org.junit.Assert.assertEquals(truc.getName(), "truc");
    }

    /** test_Thing_volume */
    @Test
    public void test_Thing_volume() {
        Thing truc = new Thing("Truc", 5);
        org.junit.Assert.assertEquals(truc.getName(), "Truc");
    }

    /** test_Thing_setName */
    @Test
    public void test_Thing_setName() {
        Thing truc = new Thing("Truc", 5);
        truc.setName("reuf");
        org.junit.Assert.assertEquals(truc.volume(), 5);
        org.junit.Assert.assertEquals(truc.getName(), "reuf");
    }

    /** test_Thing_getName */
    @Test
    public void test_Thing_getName() {
        Thing truc = new Thing("Truc", 5);
        org.junit.Assert.assertEquals(truc.volume(), 5);
        org.junit.Assert.assertEquals(truc.getName(), "Truc");
    }

    /** test_Thing_hasName */
    @Test
    public void test_Thing_hasName() {
        Thing truc = new Thing("truc", 5);
        org.junit.Assert.assertEquals(truc.hasName("false"), false);
        org.junit.Assert.assertEquals(truc.hasName("truc"), true);
    }

    /** test_Thing_forked */
    @Test
    public void test_Thing_forked() {
        org.junit.Assert.assertEquals(true, true);
    }

    /** test_Thing_toString */
    @Test
    public void test_Thing_toString() {
        Thing truc = new Thing("Truc", 5);
        org.junit.Assert.assertEquals(truc.toString(), "{name='Truc', vol='5'}");
    }

    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------

    /** test_Box_Box_cap */
    @Test
    public void test_Box_Box_cap() {
        Box b = new Box(1);
        org.junit.Assert.assertEquals(b.capacity(), 1);
        org.junit.Assert.assertEquals(b.isopen(), true);
    }

    /** test_Box_Box_open */
    @Test
    public void test_Box_Box_open() {
        Box b = new Box(false);
        org.junit.Assert.assertEquals(b.capacity(), -1);
        org.junit.Assert.assertEquals(b.isopen(), false);
    }

    /** test_Box_Box_open_cap */
    @Test
    public void test_Box_Box_open_cap() {
        Box b = new Box(false, 99);
        org.junit.Assert.assertEquals(b.capacity(), 99);
        org.junit.Assert.assertEquals(b.isopen(), false);
    }

    /** test_Box_Box */
    @Test
    public void test_Box_Box() {
        Box b = new Box(false, 99);
        org.junit.Assert.assertEquals(b.capacity(), 99);
        org.junit.Assert.assertEquals(b.isopen(), false);
    }

    /**
     * test_box_add
     * 
     * @throws Exception execpt
     */
    @Test
    public void test_box_add() throws Exception {
        Box b = new Box(1);
        org.junit.Assert.assertEquals(b.capacity(), 1);
        org.junit.Assert.assertEquals(b.hasRoomFor(new Thing(1)), true);
        b.add(new Thing(1));
        org.junit.Assert.assertEquals(b.hasRoomFor(new Thing(1)), false);
        try {
            b.remove(0);
        } catch (Exception e) {
            throw e;
        }
        org.junit.Assert.assertEquals(b.capacity(), 1);
        org.junit.Assert.assertEquals(b.isopen(), true);
    }

    /**
     * test_box_remove
     * 
     * @throws Exception execpt
     */
    @Test(expected = Exception.class)
    public void test_box_remove() throws Exception {
        Box b = new Box();
        try {
            b.remove(0);
        } catch (Exception e) {
            throw e;
        }
    }

    /** test_box_isopen */
    @Test
    public void test_box_isopen() {
        Box b = new Box();
        org.junit.Assert.assertEquals(b.isopen(), true);
        b.close();
        org.junit.Assert.assertEquals(b.isopen(), false);
        b.open();
        org.junit.Assert.assertEquals(b.isopen(), true);
        org.junit.Assert.assertEquals(b.capacity(), -1);
    }

    /** test_box_isclose */
    @Test
    public void test_box_isclose() {
        Box b = new Box();
        org.junit.Assert.assertEquals(b.isclose(), false);
        b.close();
        org.junit.Assert.assertEquals(b.isclose(), true);
        b.open();
        org.junit.Assert.assertEquals(b.capacity(), -1);
        org.junit.Assert.assertEquals(b.isopen(), true);
    }

    /** test_box_open */
    @Test
    public void test_box_open() {
        Box b = new Box();
        org.junit.Assert.assertEquals(b.isopen(), true);
        b.close();
        org.junit.Assert.assertEquals(b.isopen(), false);
        b.open();
        org.junit.Assert.assertEquals(b.isopen(), true);
        org.junit.Assert.assertEquals(b.capacity(), -1);
    }

    /** test_box_close */
    @Test
    public void test_box_close() {
        Box b = new Box();
        org.junit.Assert.assertEquals(b.isopen(), true);
        b.close();
        org.junit.Assert.assertEquals(b.isopen(), false);
        b.open();
        org.junit.Assert.assertEquals(b.isopen(), true);
        org.junit.Assert.assertEquals(b.capacity(), -1);
    }

    /** test_box_setCapacity */
    @Test
    public void test_box_setCapacity() {
        Box b = new Box();
        org.junit.Assert.assertEquals(b.capacity(), -1);
        b.setCapacity(1);
        org.junit.Assert.assertEquals(b.capacity(), 1);
        org.junit.Assert.assertEquals(b.isopen(), true);
    }

    /** test_box_capacity */
    @Test
    public void test_box_capacity() {
        Box b = new Box();
        org.junit.Assert.assertEquals(b.capacity(), -1);
        org.junit.Assert.assertEquals(b.isopen(), true);
    }

    /** test_box_hasRoomFor */
    @Test
    public void test_box_hasRoomFor() {
        Box b = new Box();
        org.junit.Assert.assertEquals(b.hasRoomFor(new Thing(99)), true);
        b.setCapacity(0);
        org.junit.Assert.assertEquals(b.hasRoomFor(new Thing(99)), false);
        org.junit.Assert.assertEquals(b.hasRoomFor(new Thing(1)), false);
        b.setCapacity(1);
        org.junit.Assert.assertEquals(b.hasRoomFor(new Thing(99)), false);
        org.junit.Assert.assertEquals(b.hasRoomFor(new Thing(1)), true);
        org.junit.Assert.assertEquals(b.isopen(), true);
    }

    /** test_box_actionLook */
    @Test
    public void test_box_actionLook() {
        Box b = new Box();
        org.junit.Assert.assertEquals(b.actionLook(), "la boite contient: []");
        b.close();
        org.junit.Assert.assertEquals(b.actionLook(), "la boite est fermee");
    }

    /**
     * test_box_actionAdd
     * 
     * @throws Exception execpt
     */
    @Test
    public void test_box_actionAdd() throws Exception {
        Box b = new Box();
        b.close();
        try {
            org.junit.Assert.assertEquals(b.actionAdd(new Thing(1)), false);
        } catch (Exception e) {
            throw e;
        }
        b.open();
        org.junit.Assert.assertEquals(b.actionAdd(new Thing(99)), true);
        try {
            b.remove(0);
        } catch (Exception e) {
            throw e;
        }
        org.junit.Assert.assertEquals(b.actionAdd(new Thing(1)), true);
        try {
            b.remove(0);
        } catch (Exception e) {
            throw e;
        }
        org.junit.Assert.assertEquals(b.capacity(), -1);
        org.junit.Assert.assertEquals(b.isopen(), true);
    }

    /** test_box_contains */
    @Test
    public void test_box_contains() {
        Box b = new Box();
        org.junit.Assert.assertEquals(b.contains(new Thing(1)), false);
        org.junit.Assert.assertEquals(b.capacity(), -1);
        org.junit.Assert.assertEquals(b.isopen(), true);
    }

    /**
     * test_box_find
     * 
     * @throws Exception exe
     */
    @Test
    public void test_box_find() throws Exception {
        Box b = new Box();
        b.add(new Thing("truc"));
        try {
            org.junit.Assert.assertEquals(b.find("truc"), new Thing("truc"));
        } catch (Exception e) {
            throw e;
        }
    }

    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------

    /** user_utilisateur */
    @Test
    public void user_utilisateur() {
        utilisateur user = new utilisateur("builder", "bob", 0);
        org.junit.Assert.assertEquals(user.getNom(), "builder");
        org.junit.Assert.assertEquals(user.getPrenom(), "bob");

    }

    /** user_getNom */
    @Test
    public void user_getNom(){
        utilisateur user = new utilisateur("builder", "bob", 0);
        org.junit.Assert.assertEquals(user.getNom(),"builder");
        org.junit.Assert.assertEquals(user.getPrenom(),"bob");
    }

    /** user_setNom */
    @Test
    public void user_setNom(){
        utilisateur user = new utilisateur("builder", "bob", 0);
        user.setNom("wonder");
        org.junit.Assert.assertEquals(user.getNom(),"wonder");
        org.junit.Assert.assertEquals(user.getPrenom(),"bob");
    }

    /** user_getPrenom */
    @Test
    public void user_getPrenom(){
        utilisateur user = new utilisateur("builder", "bob", 0);
        org.junit.Assert.assertEquals(user.getNom(),"builder");
        org.junit.Assert.assertEquals(user.getPrenom(),"bob");
    }

    /** user_setPrenom */
    @Test
    public void user_setPrenom(){
        utilisateur user = new utilisateur("builder", "bob", 0);
        user.setPrenom("alice");
        org.junit.Assert.assertEquals(user.getNom(),"builder");
        org.junit.Assert.assertEquals(user.getPrenom(),"alice");
    }

    /** user_getId */
    @Test
    public void user_getId(){
        utilisateur user = new utilisateur("builder", "bob", 0);
        org.junit.Assert.assertEquals(user.getId(),0);
        org.junit.Assert.assertEquals(user.getNom(),"builder");
        org.junit.Assert.assertEquals(user.getPrenom(),"bob");
    }

    /** user_toString */
    @Test
    public void user_toString(){
        utilisateur user = new utilisateur("builder", "bob", 0);
        org.junit.Assert.assertEquals(user.toString(),"{id='0', nom='builder', prenom='bob'}");
        org.junit.Assert.assertEquals(user.getNom(),"builder");
        org.junit.Assert.assertEquals(user.getPrenom(),"bob");
    }

    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    /** salle */
    @Test
    public void salle_salle(){
        salle s = new salle("salle");
        org.junit.Assert.assertEquals(s.getNom(),"salle");
    }
    /** getNom */
    @Test
    public void salle_getNom(){
        salle s = new salle("salle");
        org.junit.Assert.assertEquals(s.getNom(),"salle");
    }
    /** place */
    @Test
    public void salle_place(){
        salle s = new salle("salle");
        utilisateur user = new utilisateur("builder", "bob", 0);
        Box b = new Box(false, 99);
        s.place(user,b);
        org.junit.Assert.assertEquals(s.getNom(),"salle");
    }
    /** find */
    @Test
    public void salle_find(){
        salle s = new salle("perso");
        org.junit.Assert.assertEquals(salle.find("perso"),s);
        
    }
}