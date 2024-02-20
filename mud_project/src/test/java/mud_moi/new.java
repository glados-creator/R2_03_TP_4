@Test
    public void testBoxFromJSONSimple(){
        // use the file test1.json in ressources folder
        String path = TestBoxes.class.getClassLoader().getResource("test1.json").getFile();
        Box b = Box.fromJSON(path);
        assertEquals(b.capacity(), -1);
        assertTrue(b.isOpen());
    }