package MusicPlayList;

public class Test {
    public static void main(String[] args) {
        // Create list
        List list = new List();

        // Create Songs object
        Song s1 = new Song("Daisies", "Justin bibber");
        Song s2 = new Song("dive", "Olivia");
        Song s3 = new Song("Ordinary", "Warren");

//        // process
//        list.addLast(s1);
//        list.addLast(s2);
//        list.addLast(s3);
//
//        // output
//        System.out.println("Next song is: \n" + list.next());
//        System.out.println();
//        System.out.println("Previous song is: \n" + list.prev());
//        System.out.println();
//
//        System.out.println("Now the song is: \n"+list.getCurrent());
//        System.out.println();
//
//        list.printForward();
//        // addAt
//        System.out.println("======addAt======");
//        Song s4 = new Song("Adore You", "Harry Styles");
//        list.addAt(3,s4);
//        list.printForward();
//        // addFirst
//        System.out.println("======addFirst======");
//        Song s5 = new Song("A Little More", "Ed Sheeran");
//        list.addFirst(s5);
//        list.printForward();
//        // removeAt
//        System.out.println("======removeAt======");
//        list.removeAt(3);
//        list.printForward();
//        System.out.println(list.size);
//        System.out.println(list.isEmpty());

        // addAt test
        list.addAt(1,s1);
        list.printForward();
        list.addAt(2,s2);
        list.printForward();


    }
}
