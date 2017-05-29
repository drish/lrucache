package lrucache;

// Class used to store an object id in a doubly linked list
public class Entry {

    // an id for the cached object
    private int obejctId;
    private Object data;
    private Entry prev;
    private Entry next;

    public Entry(int objectId, Object data) {
        this.obejctId = objectId;
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getObejctId() {
        return this.obejctId;
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