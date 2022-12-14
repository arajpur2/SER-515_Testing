import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("all")
class UrinalsTest {

    Urinals urinals = new Urinals();

    @Test
    void readFile() {
        assertEquals("File does not exist",urinals.readFile(), "Alok Rajpurohit, urinal count test case 10 successfully passed");
        assertEquals("File is Empty",urinals.readFile(),"Alok Rajpurohit, urinal count test case 12 successfully passed");
    }

    @Test
    void writeFile() {
        System.out.println("Test cases successfully checked from main method!");
    }

    @Test
    void countUrinals() {
        assertEquals(1, urinals.countUrinals("10001"), "Alok Rajpurohit, urinal count test case 1 successfully passed");
        assertEquals(0, urinals.countUrinals("1001"), "Alok Rajpurohit, urinal count test case 2 successfully passed");
        assertEquals(-1, urinals.countUrinals("111001"), "Alok Rajpurohit, urinal count test case 3 successfully passed");
        assertEquals(2, urinals.countUrinals("0000"), "Alok Rajpurohit, urinal count test case 4 successfully passed");
        assertEquals(1, urinals.countUrinals("0"), "Alok Rajpurohit, urinal count test case 5 successfully passed");
        assertEquals(-1,urinals.countUrinals("000001111110000000001000001"), "Alok Rajpurohit,Test case 6 successfully passed");
        assertEquals(-1, urinals.countUrinals("001100510"), "Alok Rajpurohit, urinal count test case 7 successfully passed");
        assertEquals(-1, urinals.countUrinals("001100f10"), "Alok Rajpurohit, urinal count test case 8 successfully passed");
        assertEquals(0, urinals.countUrinals("000100100"), "Alok Rajpurohit, urinal count test case 9 successfully passed");
    }
}