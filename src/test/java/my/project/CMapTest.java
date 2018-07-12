package my.project;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CMapTest {

    @Test
    public void put() throws InterruptedException {
        CMap map = new CMap(100L);
        assertFalse(map.put("key1"));
        assertTrue(map.put("key1"));
        assertFalse(map.getNotDelayedKeys().isEmpty());
        assertFalse(map.put("key2"));
        Thread.sleep(100);
        assertFalse(map.put("key1"));
        assertTrue(map.put("key1"));

        Set<String> set = map.getNotDelayedKeys();
        assertEquals(1, set.size());
        assertTrue(set.iterator().next().equals("key1"));
    }

}