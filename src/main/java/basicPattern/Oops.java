package basicPattern;

import static basicPattern.Student.Percentage;

public class Oops {



    public static void main(String[] args) {

        BankAccount myAccount=new BankAccount();

        myAccount.userName="nikhil";

        Student st1=new Student();

        Student st2=new Student(12,"nikhil","1234");
        st2.marks[0]=100;
        st2.marks[1]=35;
        st2.marks[2]=36;



        Student st3=new Student(st2);
        st3.password="45151";
        st3.marks[2]=89;

        try {
            int percentage = Percentage(st2.marks);
            System.out.println(percentage + " percent");
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i=0;i<3;i++){
           System.out.print(st3.marks[i]+" ");
       }



    }
}

class  BankAccount{
    public String userName;

    private String password;

    private void setPassword(String pwd){
        password=pwd;
    }

    public static void main(String[] args) {
        BankAccount ourBank=new BankAccount();

        ourBank.setPassword("nikhil@1234");

        System.out.println(ourBank.password);
    }
}


class Student{
    int rollNo;
    String name;
    String password;
    int[] marks;

    // shallow copy constructor
//    Student(Student s){
//       marks=new int[5];
//        this.name=s.name;
//        this.rollNo=s.rollNo;
//        this.marks=s.marks;
//    }

    //deeep copy constructor
    Student(Student s){
        marks=new int[3];
        this.name=s.name;
        this.rollNo=s.rollNo;
        for (int i=0;i< marks.length;i++){
            this.marks[i]=s.marks[i];
        }

    }

    public static int Percentage(int[] marks){
       int sum=0;
       for (int i=0;i<marks.length;i++){
           sum+=marks[i];
       }

       return sum/marks.length;
    }
    Student(){
        this.marks=new int[3];
        System.out.println("Student constructor");
    }

    Student(int rollNo,String name,String pwd){
        this.rollNo=rollNo;
        this.name=name;
        this.password=pwd;
        this.marks=new int[3];
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

abstract class AutoMobile{

    AutoMobile(){
        System.out.println("a Abstract class");
    }

    void drive(){
        System.out.println("we can drive");
    }

    abstract void breaks();
}
interface AutoPlot{

    abstract void autoPlot();
}
class Bike extends AutoMobile{

    @Override
    void breaks() {
        System.out.println("disc breaks");
    }
}

class Car extends AutoMobile{

    @Override
    void breaks() {
        System.out.println("oil breaks 4 wheels");
    }

    public static void main(String[] args) {
        Bike bike=new Bike();
//        bike.drive();
        bike.breaks();
    }
}

class Animals{

    Animals(){
        System.out.println("constructor Animals");
    }

    void eat(){
        System.out.println("eat anyThings");
    }
}

class Dog extends Animals{

    void bark(){
        System.out.println("bobo ");
    }

    //overRidding
    void eat(){
        System.out.println("Non-veg");
    }

    Dog(){
        System.out.println("its a dog");
    }

    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.eat();
    }
}


