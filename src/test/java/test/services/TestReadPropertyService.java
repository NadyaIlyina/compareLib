package test.services;

import org.junit.Test;
import util.ReadPropertyService;

import static org.junit.Assert.assertEquals;

public class TestReadPropertyService {

    private final ReadPropertyService service = new ReadPropertyService();

    @Test
    public void testReadIntProperty() {
        System.setProperty("testIntProperty", "20");
        assertEquals(20,  service.readProperty("testIntProperty"));
    }

    @Test
    public void testNoProperty(){
        assertEquals(100,service.readProperty("testIntProperty"));
    }
}
