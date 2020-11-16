package ir.ac.pgu.lms.domain;

public class NodeTwoSided {
    private int data;
    private NodeTwoSided next;
    private NodeTwoSided previous;

    public NodeTwoSided(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public boolean hasNext() {
        return getNext() != null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeTwoSided getNext() {
        return next;
    }

    public void setNext(NodeTwoSided next) {
        this.next = next;
    }

    public NodeTwoSided getPrevious() {
        return previous;
    }

    public void setPrevious(NodeTwoSided previous) {
        this.previous = previous;
    }
}
