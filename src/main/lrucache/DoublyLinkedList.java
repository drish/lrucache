package lrucache;

class DoublyLinkedList {

    private final int capacity;
    private Entry head;
    private Entry tail;
    private int currSize;

    public DoublyLinkedList(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
    }

    public Entry getTail() {
        return this.tail;
    }

    public void printList() {
        if(this.head == null) {
            return;
        }
        Entry tmp = this.head;
        while(tmp != null) {
            System.out.print(tmp);
            tmp = tmp.getNext();
        }
    }

    public Entry addObjectToList(Entry entry) {

        if(this.head == null) {
            this.head = entry;
            this.tail = entry;
            this.currSize = 1;
            return entry;
        } else if(currSize < capacity) {
            this.currSize++;
        } else {
            this.tail = tail.getPrev();
            this.tail.setNext(null);
        }

        // add new entry to the head.
        entry.setNext(head);
        this.head.setPrev(entry);
        this.head = entry;
        return entry;
    }

    public void moveObjectToHead(Entry pageNode) {
        if(pageNode == null || pageNode == head) {
            return;
        }

        if(pageNode == this.tail) {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }

        Entry prev = pageNode.getPrev();
        Entry next = pageNode.getNext();
        prev.setNext(next);

        if(next != null) {
            next.setPrev(prev);
        }

        pageNode.setPrev(null);
        pageNode.setNext(this.head);
        this.head.setPrev(pageNode);
        this.head = pageNode;
    }

    public int getCurrSize() {
        return currSize;
    }

    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }

    public Entry getHead() {
        return head;
    }

    public void setHead(Entry head) {
        this.head = head;
    }

    public int getSize() {
        return capacity;
    }
}

