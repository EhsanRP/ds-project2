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

        NodeOneSided newData = new NodeOneSided(data, head);
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

    public void insert(int data){

        if (AUTO_SORT)
            inser(data);
        else
            insertLast(data);
    }

    private void inser(int data) {

        NodeOneSided newData = new NodeOneSided(data, null);
        NodeOneSided ptr = head;

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
                while (data >= ptr.getNext().getData() && ptr.hasNext()) {
                    ptr = ptr.getNext();
                }
                insertAfter(data, ptr);
            }
    }

    private void insertLast(int data){

        if (isEmpty())
            insertFirst(data);

        NodeOneSided newData = new NodeOneSided(data);

        getTail().setNext(newData);
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

        if (head == null || isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        NodeOneSided node = head;
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

        NodeOneSided previous = head;
        NodeOneSided next = head.getNext();
        NodeOneSided node;
        int counter = 1;

        while (counter <= size - 1) {

            if (counter == index) {
                previous.setNext(next.getNext());
                size--;
                return;
            }

            previous = next;
            next = next.getNext();
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

    public NodeOneSided swapNodes( NodeOneSided head_ref, NodeOneSided currX,
                                   NodeOneSided currY, NodeOneSided prevY) {
        head_ref = currY;

        prevY.setNext(currX);

        NodeOneSided temp = currY.getNext();
        currY.setNext(currX.getNext());
        currX.setNext(temp);
        return head_ref;
    }

    public NodeOneSided recurSelectionSort( NodeOneSided head) {
        if (head.getNext() == null)
            return head;

        NodeOneSided min = head;

        NodeOneSided beforeMin = null;
        NodeOneSided ptr;

        for (ptr = head; ptr.getNext() != null; ptr = ptr.getNext())
        {

            if (ptr.getNext().getData() < min.getData())
            {
                min = ptr.getNext();
                beforeMin = ptr;
            }
        }

        if (min != head)
            head = swapNodes(head, head, min, beforeMin);

        head.setNext(recurSelectionSort(head.getNext()));

        return head;
    }

    public NodeOneSided search(int key) {

        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        NodeOneSided ptr = head;

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

        NodeOneSided ptr = head;

        for (int i = 1; i < size; i++) {
            if (ptr.getData() == key)
                return true;
            ptr = ptr.getNext();
        }

        System.out.println("Key not found");
        return false;
    }

    public NodeOneSided indexOf(int index) {

        if (index > size) {
            System.out.println("Index out of bound");
            return null;
        }

        NodeOneSided ptr = head;
        NodeOneSided node;
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

        NodeOneSided ptr = head;
        for (int i = 0; i < size; i++) {
            System.out.print(ptr.getData() + "-->");
            ptr = ptr.getNext();
        }
    }

    public NodeOneSided getHead() {
        return head;
    }

    public NodeOneSided getTail() {

        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        NodeOneSided ptr = head;
        for (int i = 1; i < size; i++) {
            ptr = ptr.getNext();
        }
        return ptr;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

}
