package linkedListPart1;

public class LL {

    private Node head;

    private Node tail;


    private int size;

    public LL() {
        this.size=0;
    }

    public void insertFirst(int val){
        Node node=new Node(val);

        //step2-change new node to head
        node.next=head;
//        System.out.println(node.next+"node next");
        //step 3 --> head =newNode
        head=node;
        if (tail==null){
            tail=head;
        }

        size+=1;

    }

    public void display(){
        Node temp=head;

        if (head== null){
            System.out.println("Linked list is empty");
        }

        while (temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }

        System.out.println("End");

    }

    public void insertLast(int val){

        Node node=new Node(val);

        if (tail==null){
            insertFirst(val);
            return;
        }

        //step 2
        tail.next=node;
        tail=node;
        size++;
    }

    public void insert(int val,int index){
        if (head==null){
            insertFirst(val);
            return;
        }

        if (index==size){
            insertLast(val);
            return;
        }

        Node temp=head;

        for (int i=1;i<index;i++){
            temp=temp.next;
        }

        Node newNode=new Node(val,temp.next);

        temp.next=newNode;
    }

    public int deleteFirst(){
        int val=head.value;

        head=head.next;

        if (head==null){
            tail=null;
        }

        size--;

        return val;
    }

    public Node get(int index){
        Node node=head;

        for (int i=0;i<index;i++){
            node=node.next;
        }

        return node;
    }

    public int deleteLast(){
        if (size<=1){
            return deleteFirst();
        }

        Node secondLast=get(size-1);
        int val=tail.value;

        tail=secondLast;
        tail.next=null;

        return val;
    }

    public int delete(int index){

        if (index==0){
            return deleteFirst();
        }

        if (index == size-1){
            return deleteLast();
        }

        Node prev=get(index-1);

        int val= prev.next.value;

        prev.next=prev.next.next;

        return val;
    }

    public Node find(int value){
        Node node=head;

        while (node!=null){
            if (node.value==value){
                return node;
            }
            node=node.next;
        }

        return null;
    }

    public void add(int idx,int data){

        if (idx==0){
            insertFirst(data);
            return;
        }

        Node newNode=new Node(data);
        size++;
        Node temp=head;

        int i=0;

        while (i<idx-1){
            temp=temp.next;
            i++;
        }

        //i =index-1 temp--->prev
        newNode.next=temp.next;

        temp.next=newNode;


    }

    public int search(int key){
        Node temp=head;
        int index=0;

        while (temp!=null){
            if (temp.value==key){
                return index;
            }
            temp=temp.next;
            index++;
        }

        return -1;
    }

    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }


    private class Node{
        private int value;
        private Node next;


        public Node(int value){
            this.value=value;
        }

        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
}
