/*
 * Class: CMSC203 
 * Instructor: David Kuijt
 * Description: JUnit custom tests
 * Due: 10/20/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Rohith Athrey
*/
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
    CryptoManager cryptoManager;

    @BeforeEach
    public void setUp() throws Exception {
        cryptoManager = new CryptoManager();
    }

    @AfterEach
    public void tearDown() throws Exception {
        cryptoManager = null;
    }

    @Test
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("HELLO"));
        assertTrue(CryptoManager.isStringInBounds("\"HELLO WORLD\""));
        assertFalse(CryptoManager.isStringInBounds("hello"));
    }

    @Test
    public void testEncryptCaesar() {
        assertEquals("EFG", CryptoManager.caesarEncryption("BCD", 3));
        assertEquals("@8;5-", CryptoManager.caesarEncryption("WORLD", 105));
        assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("SOMETHING", CryptoManager.caesarDecryption("TPNFUIJOH", 1));
        assertEquals("GOOD MORNING", CryptoManager.caesarDecryption("3;;0L9;>:5:3", 300));
        assertEquals("THIS IS ANOTHER TEST", CryptoManager.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
    }

    @Test
    public void testEncryptBellaso() {
        assertEquals("P]Z,Y_$", CryptoManager.bellasoEncryption("EXAMPLE", "KEY_IS_LONGER_THAN_THE_PLAIN_TEXT"));
        assertEquals("PF\\\\((GU^#PIM%", CryptoManager.bellasoEncryption("HAPPY BIRTHDAY", "HELLO"));
        assertEquals("Y]T!YZL+Y!J8CR\\XF^T", CryptoManager.bellasoEncryption("TESTING THE BELLASO", "EXAMPLEKEY"));
    }

    @Test
    public void testDecryptBellaso() {
        assertEquals("EXAMPLE", CryptoManager.bellasoDecryption("P]Z,Y_$", "KEY_IS_LONGER_THAN_THE_PLAIN_TEXT"));
        assertEquals("HAPPY BIRTHDAY", CryptoManager.bellasoDecryption("PF\\\\((GU^#PIM%", "HELLO"));
        assertEquals("TESTING THE BELLASO", CryptoManager.bellasoDecryption("Y]T!YZL+Y!J8CR\\XF^T", "EXAMPLEKEY"));
    }
}
