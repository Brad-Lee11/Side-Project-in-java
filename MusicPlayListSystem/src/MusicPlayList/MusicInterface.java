package MusicPlayList;

public interface MusicInterface {
    public void addLast(Song s);
    // O(1)（必須維護 tail）

    public void addFirst(Song s);
    // O(1)

    public void addAt(int position, Song s);
    // 1-based position：合法 1..size+1

    public boolean removeAt(int position);
    // 回傳被刪 song（或回傳 boolean 也可）

    public Song next();
    // 移動 cursor；到尾/頭要有明確行為（保持不動 or return null）

    public Song prev();
    //移動 cursor；到尾/頭要有明確行為（保持不動 or return null

    public Song getCurrent();
    //若空清單回傳 null

    public void printForward();
    // 由 head 到 tail、由 tail 到 head

    public void printBackward();
    // 由 head 到 tail、由 tail 到 head

    public int size();

    public boolean isEmpty();

}
