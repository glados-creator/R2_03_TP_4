package mud_moi;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("hello from mud_moi");
        Box b = new Box();
        Thing truc = new Thing("truc");
        Thing machin = new Thing("machin");
        b.add(truc);
        b.add(machin);
        b.actionLook();

        System.out.println(b.toJSON());

        try {
            
            // use the file test1.json in ressources folder
            String path = "/media/o22302615/PAVARDARTHU/iuto/2_semestre/cour/qualitate/R2_03_TP_4/mud_project/src/test/resources/test1.json";
            System.out.println("json path : '"+path+"'");
            Box test = Box.fromJSON(path);
            assert test.capacity() == -1;
            assert test.isopen();
            System.out.println("boite : "+test.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
