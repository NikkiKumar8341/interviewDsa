package cloning;

public class Human implements Cloneable{

    int age;
    String name;
    int[] arr;

    Human(){
        this.age=age;
        this.name=name;
    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr=new int[]{4,67,98,56,85};
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone(); // returns a shallow copy
//    }

    @Override
    protected  Object clone() throws CloneNotSupportedException{

    Human twin = (Human) super.clone(); // shallow copy first

    // Deep copy of the arr field
    twin.arr = new int[this.arr.length];
    for (int i = 0; i < this.arr.length; i++) {
        twin.arr[i] = this.arr[i];
    }

    return twin;
    }



}
