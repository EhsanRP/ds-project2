package ir.ac.pgu.lms.dataStructures;

import ir.ac.pgu.lms.domain.NodeOneSided;
import org.w3c.dom.Node;

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

    public void insert(int data) {

        NodeOneSided newData = new NodeOneSided(data, null);
        NodeOneSided ptr = head;

        if (isEmpty()) {

            head = newData;
            size++;
            System.out.println(data);
            return;


        }

        if (newData.getData() == ptr.getData()) {
            System.out.println(data);
            insertAfter(data, head);

        } else if (data < ptr.getData()){
            insertFirst(data);
            System.out.println(data);
        }

        else if(data > ptr.getData()) {
            for (int i = 0; i < size; i++) {

                if (data >= ptr.getData()) {
                    System.out.println(data);
                    insertAfter(data, ptr);
                    break;
                }

                ptr = ptr.getNext();
            }
        }
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

    public void swapNodes(NodeOneSided a, NodeOneSided b) {
        int temp = a.getData();
        a.setData(b.getData());
        b.setData(temp);
    }

    public NodeOneSided recurSelectionSort(NodeOneSided head) {

        if (!head.hasNext())
            return head;

        NodeOneSided min = head;

        NodeOneSided beforeMin = null;
        NodeOneSided ptr;

        for (ptr = head; !ptr.hasNext(); ptr = ptr.getNext()) {

            if (ptr.getNext().getData() < min.getData()) {
                min = ptr.getNext();
                beforeMin = ptr;
            }
        }

        if (min != head)
            head = swapNodes(head, head, min, beforeMin);

        head.setNext(recurSelectionSort(head.getNext()));

        return head;
    }

    public NodeOneSided swapNodes(NodeOneSided head_ref, NodeOneSided currX,
                                  NodeOneSided currY, NodeOneSided prevY) {
        head_ref = currY;

        prevY.setNext(currX);

        NodeOneSided temp = currY.getNext();
        currY.setNext(currX.getNext());
        currX.setNext(temp);
        return head_ref;
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(head.getData() + "-->");
            head = head.getNext();
        }
    }

    public NodeOneSided getHead() {
        return head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }


}
