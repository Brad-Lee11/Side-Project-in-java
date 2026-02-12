package MusicPlayList;

public class List implements MusicInterface {
    // basic Variable
    private Node head;
    private Node tail;
    private Node current;
    int size;

    public List() {
    }

    public List(Node head, Node tail, Node current, int size) {
        this.head = head;
        this.tail = tail;
        this.current = current;
        this.size = size;
    }

    @Override
    // O(1)（必須維護 tail）
    public void addLast(Song s) {
        // Create new Node for the Song
        // size
        // set boundary
        if (isEmpty()) {
            Node newNode = new Node(s, null, null);
            head = tail = newNode;
            size++;
            return;
        }
        // update pointers (prev and next)
        Node newNode = new Node(s, tail, null);
        tail.setNext(newNode); // original tail <-> newNode(tail)
        tail = newNode; // newNode(tail)
        size++;
    }

    @Override
    // O(1)
    public void addFirst(Song s) {
        // Create new Node for the Song
        // size
        // set boundary
        if (isEmpty()) {
            Node newNode = new Node(s, null, null);
            head = tail = newNode;
            size++;
            return;
        }
        // update pointers (prev and next)
        Node newNode = new Node(s, null, head);
        head.setPrev(newNode); // original head <-> newNode
        head = newNode; // newNode(head)
        size++;

    }

    @Override
    // 1-based position：合法 1..size+1
    public void addAt(int position, Song s) {
        // Create a new Node for new song
        // update pointers
        // size
        // set boundary
        // empty case
        if (isEmpty() && position == 1) {
            Node newNode = new Node(s, null, null);
            tail = head = newNode;
            size++;
            return;
        }
        // over the size or less than 1
        if (position < 1 || position > size + 1) {
            System.out.println("It is out of  bounds ");
            return;
        }
        // head
        if (position == 1) {
            addFirst(s);
            return;
        }
        // tail
        if (position == size + 1) {
            addLast(s);
            return;
        }
        // Create a moveable pointer to traversal
        Node cursor = head;
        for (int i = 1; i < position; i++) {
            // traversal
            cursor = cursor.getNext();
        }

        // middle
        Node prev = cursor.getPrev();
        Node newNode = new Node(s, prev, cursor); //prev<- new-> cursor
        prev.setNext(newNode); // prev-> new
        cursor.setPrev(newNode);    // new <- cursor
        size++;
        // ensure head and tail
        head.setPrev(null);
        tail.setNext(null);

    }

    @Override
    // 回傳被刪 song（或回傳 boolean 也可）
    public boolean removeAt(int position) {
        // set boundary
        // list is empty
        if (size == 0) {
            System.out.println("The play list is empty.");
            return false;
        }
        // out of the size
        if (position < 1 || position > size) {
            System.out.println("The position didn't exist.");
            return false;
        }
        // one left
        if (size == 1) {
            head = tail = current = null;
            size = 0;
            return true;
        }

        // traversal to find target
        Node cursor = head;
        for (int i = 1; i < position; i++) {
            cursor = cursor.getNext();
        }
        // update pointers and skip the target
        Node prev = cursor.getPrev();
        Node next = cursor.getNext();
        // update current
        if (cursor == current) {
            current = (next != null) ? next : prev;
        }
        //head
        if (prev == null) {
            head = next;
            size--;
            if (head != null) {
                head.setPrev(null);
            }
            return true;
        }
        // tail
        if (next == null) {
            tail = prev;
            tail.setNext(null);
            size--;
            if (tail != null) {
                tail.setNext(null);
            }
            return true;
        }
        // middle
        prev.setNext(next);
        next.setPrev(prev);
        // size
        size--;
        return true;
    }

    @Override
    // 移動 cursor；到尾/頭要有明確行為（保持不動 or return null）
    public Song next() {
        // consider about current
        // move current
        // set boundary
        if (isEmpty()) {
            return null;
        }

        if (current == null || current == tail) {
            current = head;
            return current.getData();
        }
        // update current position
        current = current.getNext();
        return current.getData();
    }

    @Override
    //移動 cursor；到尾/頭要有明確行為（保持不動 or return null
    public Song prev() {
        // consider about current
        // move current
        if (isEmpty()) {
            return null;
        }
        // set boundary
        if (current == null || current == head) {
            current = tail;

            return current.getData();
        }
        // update current position
        current = current.getPrev();

        return current.getData();

    }

    @Override
    //若空清單回傳 null
    public Song getCurrent() {
        if (isEmpty()) return null;
        if (current == null) {
            current = head;
        }
        return current.getData();
    }

    @Override
    // 由 head 到 tail、由 tail 到 head
    public void printForward() {
        // consider about cursor
        // Create a new Node for temp cursor as a pointer
        Node cursor = head;
        while (cursor != null) {
            // print element
            Song song = cursor.getData();
            System.out.println(song.toString());
            // Move pointer
            cursor = cursor.getNext();
        }
    }

    @Override
    // 由 head 到 tail、由 tail 到 head
    public void printBackward() {
        // consider about cursor
        // Create a new Node for temp cursor as a pointer
        Node cursor = tail;
        while (cursor != null) {
            // print element
            Song song = cursor.getData();
            System.out.println(song.toString());
            // Move pointer
            cursor = cursor.getPrev();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
