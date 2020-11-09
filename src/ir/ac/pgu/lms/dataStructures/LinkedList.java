package ir.ac.pgu.lms.dataStructures;

import ir.ac.pgu.lms.domain.NodeOneSided;

public class LinkedList {

    private final boolean AUTO_SORT;
    private int size;
    private NodeOneSided head;

    public LinkedList(boolean AUTO_SORT, NodeOneSided head) {
        this.AUTO_SORT = AUTO_SORT;
        this.size = 0;
        this.head = head;
    }

    public LinkedList(boolean AUTO_SORT) {
        this.AUTO_SORT = AUTO_SORT;
        size = 0;
    }

    public void insertFirst(int data) {

        NodeOneSided newData = new NodeOneSided(data, head.getNext());
        head = newData;

        size++;
    }

    public void insertAfter(int data, NodeOneSided node) {

        if (node == null) {
            System.out.println("Previous Node can not be null");
            return;
        }

        NodeOneSided newData = new NodeOneSided(data, node.getNext());
        node.setNext(newData);

        size++;
    }

    public void insertLast(int data) {

        NodeOneSided newData = new NodeOneSided(data, null);

        if (isEmpty()) {

            head = newData;
            size++;
            return;
        }

        NodeOneSided temp = head;
        while (temp.hasNext()) {
            temp = temp.getNext();
        }

        temp.setNext(newData);

        size++;
    }

    public void deleteNode(NodeOneSided key) {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        NodeOneSided temp = head;
        NodeOneSided previous = null;

        while (temp.hasNext()) {
            if (temp == key)
                break;

            if (!temp.hasNext() && temp != key) {
                System.out.println("Key Node Not found");
                return;
            }

            previous = temp;
            temp = temp.getNext();
        }

        previous.setNext(temp.getNext());

        size--;
    }

    public void deleteFirst() {

        if (head==null || isEmpty()){
            System.out.println("List is empty");
            return;
        }

        NodeOneSided node = head;
        head = head.getNext();
        head.setNext(node.getNext());

        size--;
    }

    public void deleteLast() {

        if (isEmpty())
            return;
        else if (!head.hasNext()) {
            head = null;
            size--;
            return;
        }

        NodeOneSided previous = null;
        NodeOneSided temp = head;

        while (temp.hasNext()) {
            previous = temp;
            temp = temp.getNext();
        }

        previous.setNext(null);
        temp = null;

        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
