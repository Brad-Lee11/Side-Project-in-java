package MusicPlayList;

public class Node {
    private Song data;
    private Node prev;
    private Node next;

    public Node() {
    }

    public Node(Song data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Song getData() {
        return data;
    }

    public void setData(Song data) {
        this.data = data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
