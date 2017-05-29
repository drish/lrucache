package lrucache.main;

import java.util.HashMap;

/**
 * LRU stands for Least Recently Used.
 * An LRU Cache is a cache where we always remove the less used/accessed item from it
 * when it's full.
 *
 * example:
 *
 *  initialize LRU Cache with capacity of 3
 *
 *  [] [] []
 *
 *  add "data 1"
 *
 *  ["data 1"] [] []
 *
 * add "data 2"
 *
 * ["data 2"] ["data 1"] []
 *
 * add "data 3"
 *
 * ["data 3"] ["data 2"] ["data 1"]
 *
 * add "data 4"
 *
 * ["data 3"] ["data 2"] ["data 4"]
 *
 * A doubly linked list is used to store object ids in a insert-on-head fashion
 * so that only ids are stored into the doubly linked list
 * and these ids are used as keys in the hash map
 *
 * The doubly linked list is initialized with a capacity required for the LRU cache to work.
 *
 */
public class LRUCache {

    private DoublyLinkedList list;
    private HashMap<Integer, Entry> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.list = new DoublyLinkedList(capacity);
        this.cache = new HashMap<Integer, Entry>();
        this.capacity = capacity;
    }

    public Entry getObject(int objectIndex) {

       Entry entry = null;
        if (cache.containsKey(objectIndex)) {

            // id is present in cache, move the page to head
            entry = this.cache.get(objectIndex);
            this.list.movePageToHead(entry);
            return entry;
        } else {

            // not cached, add to the tail
            if (this.list.getCurrSize() == this.list.getSize()) {
                // if full, remove tail(lru) from the cache list
                // and hash map
                this.cache.remove(this.list.getTail().getObejctId());
            }
            entry = this.list.addPageToList(objectIndex);
            this.cache.put(objectIndex, entry);
            return entry;
        }
    }

    public void printCacheState() {
        this.list.printList();
        System.out.println();
    }
}
