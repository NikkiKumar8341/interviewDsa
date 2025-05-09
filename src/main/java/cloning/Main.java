package cloning;

public class Main {

    public static void main(String[] args) {
        Human hi=new Human(15,"ram");

        try {
            Human clone =(Human)hi.clone();
            System.out.println(clone.name+" "+clone.age+" "+clone.arr[0]);
            clone.age=36;
            clone.arr[0]=65;

            System.out.println(hi.name+" hi name "+hi.age+" arr: "+hi.arr[0]);

            System.out.println("clone object "+clone.name+" "+clone.age+" arr:"+clone.arr[0]);

        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
