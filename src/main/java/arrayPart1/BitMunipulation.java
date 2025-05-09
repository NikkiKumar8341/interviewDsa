package arrayPart1;

public class BitMunipulation {


    public static void evenOrOdd(int n){
        int bitMask=1;

        if ((n & bitMask)==0){
            System.out.println("Even number");
        }else {
            System.out.println("Odd Number");
        }
    }

    public static int getIthBit(int n,int i){

        int bitMask=1<<i;

        if ((n & bitMask)==0){
            return 0;
        }else {
            return 1;
        }
    }


    public static void main(String[] args) {
        evenOrOdd(6);

        getIthBit(10,2);
    }
}
