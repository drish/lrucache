package lrucache;

import com.sun.source.tree.AssertTree;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest extends TestCase {

    @Test
    public void testAddObject() {
        LRUCache cache = new LRUCache(10);

        String data = "test cacheable data";
        assertTrue(cache.addObject(4, data).getData().equals(data));
    }

    @Test
    public void testGetObject() {
        LRUCache cache = new LRUCache(10);
        String data = "test cacheable data";
        cache.addObject(4, data);
        assertTrue(cache.getObject(4).getData().equals(data));
    }

    @Test
    public void testMostAccessedObject() {
        LRUCache cache = new LRUCache(10);
        String data = "gosling";
        String data2 = "woz";
        String data3 = "torvalds";
        cache.addObject(1, data);
        cache.addObject(2, data2);
        cache.addObject(3, data3);
        cache.getObject(2);
        assertTrue(cache.getMostAccessed().getData().equals(data2));
    }
}
