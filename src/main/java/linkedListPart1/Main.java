package linkedListPart1;

public class Main {

    public static void main(String[] args) {

        LL linkList = new LL();
        linkList.insertLast(55);
        linkList.insertFirst(40);
        linkList.insertFirst(50);
        linkList.insertFirst(41);

        linkList.insertLast(65);
        linkList.display();

        linkList.insert(2, 2);

        linkList.display();

        System.out.println( linkList.deleteFirst());

        linkList.display();

        linkList.insert(80,4);

         linkList.display();

        System.out.println( linkList.deleteLast());

        linkList.display();

        System.out.println(linkList.delete(2));

        linkList.display();

        System.out.println(linkList.search(65));

        linkList.reverse();

        linkList.display();

    }
}
