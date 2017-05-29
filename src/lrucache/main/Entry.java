package lrucache.main;

// Class used to store an object id in a doubly linked list
public class Entry {

    // an id for the cached object
    private int obejctId;

    private Entry prev;
    private Entry next;

    public Entry(int objectId) {
        this.obejctId = objectId;
    }

    public int getObejctId() {
        return obejctId;
    }

    public void setObejctId(int obejctId) {
        this.obejctId = obejctId;
    }

    public Entry getPrev() {
        return prev;
    }

    public void setPrev(Entry prev) {
        this.prev = prev;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public String toString() {
        return this.obejctId + "  ";
    }
}