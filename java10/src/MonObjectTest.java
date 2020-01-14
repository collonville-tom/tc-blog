import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MonObjectTest {

    @Test
    public void varJava9Way()
    {
        Object monObject=new Object() {
            public String toString()
            {
                return "Object";
            }
        };
        assertEquals("Object",monObject.toString());
    }
    @Test
    public void varJava10Way()
    {
        var monObject=new Object() {
            public String toString()
            {
                return "Object";
            }
        };
        assertEquals("Object",monObject.toString());
    }

    @Test
    public void subtilTest()
    {
        MonObject monObject=new MonObject();

        var obj1=monObject.moiDirect();
        var obj2=monObject.moiParInterface();

        obj1.moiDirect();
        obj1.moiParInterface();

        obj2.moiDirect();
        obj2.moiParInterface();
    }
}