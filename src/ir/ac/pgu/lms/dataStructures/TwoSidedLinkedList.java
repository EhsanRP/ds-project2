package ir.ac.pgu.lms.dataStructures;

import ir.ac.pgu.lms.domain.NodeTwoSided;

public class TwoSidedLinkedList {

    private final boolean AUTO_SORT;
    private int size;
    private NodeTwoSided head;

    public TwoSidedLinkedList(boolean AUTO_SORT, int head) {
        this.AUTO_SORT = AUTO_SORT;
        this.size = 0;
        this.head = new NodeTwoSided(head);
    }

    public TwoSidedLinkedList(boolean AUTO_SORT) {
        this.AUTO_SORT = AUTO_SORT;
        size = 0;
    }

    public void insertFirst(int data) {

        NodeTwoSided newData = new NodeTwoSided(data);
        newData.setNext(head);
        head.setPrevious(newData);
        head = newData;

        size++;
    }

    public void insertAfter(int data, NodeTwoSided node) {

        if (node == null) {
            System.out.println("Previous Node can not be null");
            return;
        }

        NodeTwoSided newData = new NodeTwoSided(data);
        newData.setPrevious(node);
        newData.setNext(node.getNext());
        node.setNext(newData);

        size++;
    }

    public void insert(int data) {

        if (AUTO_SORT)
            Sortedinsert(data);
        else
            insertLast(data);
    }

    private void Sortedinsert(int data) {

        NodeTwoSided newData = new NodeTwoSided(data);
        NodeTwoSided ptr = head;

        if (isEmpty()) {
            head = newData;
            size++;
            return;
        }

        if (newData.getData() == ptr.getData())
            insertAfter(data, head);

        else if (data < ptr.getData())
            insertFirst(data);


        else if (data > ptr.getData())
            if (!ptr.hasNext())
                insertAfter(data, ptr);
            else {
                while (ptr.hasNext() && data >= ptr.getNext().getData()) {
                    ptr = ptr.getNext();
                }
                insertAfter(data, ptr);
            }
    }

    private void insertLast(int data) {

        if (isEmpty()) {
            insertFirst(data);
            return;
        }

        NodeTwoSided tail = getTail();

        NodeTwoSided newData = new NodeTwoSided(data);

        tail.setNext(newData);
        newData.setPrevious(tail);

        size++;
    }

    public void deleteNode(NodeTwoSided key) {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        NodeTwoSided temp = head;

        while (temp.hasNext()) {
            if (temp == key)
                break;

            if (!temp.hasNext() && temp != key) {
                System.out.println("Key Node Not found");
                return;
            }
            temp = temp.getNext();
        }

        temp.getPrevious().setNext(temp.getNext());
        temp.getNext().setPrevious(temp.getPrevious());

        size--;
    }

    public void deleteFirst() {

        if (head == null || isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        NodeTwoSided node = head;
        head = head.getNext();
        head.setNext(node.getNext());

        size--;
    }

    public void deleteIndexOf(int index) {

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        } else if (index >= size) {
            System.out.println("index out of bound");
            return;
        } else if (index == 0) {
            deleteFirst();
        } else if (index == size - 1)
            deleteLast();

        NodeTwoSided ptr = head;
        int counter = 1;

        while (counter <= size - 1) {

            if (counter == index) {
                ptr.setNext(ptr.getNext().getNext());
                ptr.getNext().getNext().setPrevious(ptr);
                size--;
                return;
            }

            ptr = ptr.getNext();
            counter++;
        }

    }

    public void deleteLast() {

        if (isEmpty())
            return;
        else if (!head.hasNext()) {
            head = null;
            size--;
            return;
        }

        NodeTwoSided temp = head;

        while (temp.hasNext())
            temp = temp.getNext();

        temp.getPrevious().setNext(null);
        temp = null;

        size--;
    }

    public void insertRec(int data) {

        NodeTwoSided newData = new NodeTwoSided(data);
        NodeTwoSided ptr = head;

        if (isEmpty()) {
            head = newData;
            size++;
            return;
        }

        if (newData.getData() == ptr.getData())
            insertAfter(data, head);

        else if (data < ptr.getData())
            insertFirst(data);


        else if (data > ptr.getData())
            if (!ptr.hasNext())
                insertAfter(data, ptr);
            else {
                ptr = insertRecHelper(data, ptr);
                insertAfter(data, ptr);
            }
    }

    private NodeTwoSided insertRecHelper(int data, NodeTwoSided ptr) {
        if (data >= ptr.getData() && ptr.hasNext()) {
            return insertRecHelper(data, ptr.getNext());
        }
        return ptr;
    }

    public static TwoSidedLinkedList sortRec(TwoSidedLinkedList linkedList) {
        TwoSidedLinkedList sorted = new TwoSidedLinkedList(true);

        NodeTwoSided ptr = linkedList.head;

        while (ptr != null) {
            sorted.insert(ptr.getData());
            ptr = ptr.getNext();
        }
        return sorted;
    }

    public NodeTwoSided search(int key) {

        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        NodeTwoSided ptr = head;

        for (int i = 1; i < size; i++) {
            if (ptr.getData() == key)
                return ptr;
            ptr = ptr.getNext();
        }

        System.out.println("Key not found");
        return null;
    }

    public boolean isPresent(int key) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return false;
        }

        NodeTwoSided ptr = head;

        for (int i = 1; i < size; i++) {
            if (ptr.getData() == key)
                return true;
            ptr = ptr.getNext();
        }

        System.out.println("Key not found");
        return false;
    }

    public NodeTwoSided indexOf(int index) {

        if (index > size) {
            System.out.println("Index out of bound");
            return null;
        }

        NodeTwoSided ptr = head;
        int counter = 0;

        while (counter < size) {
            if (counter == index)
                return ptr;
            ptr = ptr.getNext();
            counter++;
        }

        return null;
    }

    public void printList() {

        NodeTwoSided ptr = head;
        while (ptr != null) {
            System.out.print(ptr.getData() + " --> ");
            ptr = ptr.getNext();
        }

        System.out.println();
    }

    public NodeTwoSided getHead() {
        return head;
    }

    public NodeTwoSided getTail() {

        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        if (size == 1)
            return head;

        NodeTwoSided ptr = head;
        while (ptr.hasNext())
            ptr = ptr.getNext();
        return ptr;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

}