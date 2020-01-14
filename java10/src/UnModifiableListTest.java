import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnModifiableListTest {

    @Test
    public void vueNonModifiableTest()
    {
        var maList= new ArrayList<>(List.of("Premier", "second", "troisieme"));
        var vue= Collections.unmodifiableList(maList);
        maList.set(1, "Insert");

        assertEquals("Insert",maList.get(1));
        assertEquals("Insert",vue.get(1));
    }

    @Test
    public void essaiModifVueNonModifiable()
    {
        var maList= new ArrayList<>(List.of("Premier", "second", "troisieme"));
        var vue= Collections.unmodifiableList(maList);
        assertThrows(UnsupportedOperationException.class,() -> vue.set(1, "Insert"));
    }
}