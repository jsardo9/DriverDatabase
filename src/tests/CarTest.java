import static org.junit.Assert.*;
import org.junit.*;

public class CarTest {
    // Creating sample car
    static final String MODEL = "Impreza";
    static final String MAKE = "Subaru";
    static final Car TESTCAR = new Car(MAKE, MODEL);

    @Test // testing that car was created correctly
    public void testCarConstructor() {
        assertEquals(MODEL, TESTCAR.getModel());
    }
}
