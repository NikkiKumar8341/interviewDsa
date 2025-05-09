package flowChart;

public class FunMeth {



    public int mutiple(int a,int b){
        return a*b;
    }

    public float mutiple(float a,float b){
        return a*b;
    }


    public static boolean prime(int n){

        if(n==2){
            return true;
        }

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }

       return true;
    }

    public static void primeRange(int n){

        for (int i=2;i<=n;i++){
            if (prime(i)){
                System.out.println(i+" ");
            }
        }
        System.out.println();
    }
    public static void  binaryToDec(int n){
        int myNum=n;
        int pow=0;
        int dec=0;

        while(n!=0){
            int last_digit=n%10;
            dec= dec+(last_digit* (int) Math.pow(2,pow));
            pow++;
            n/=10;

        }

        System.out.println("binary to decimal number is "+myNum+"  ="+dec);


    }

    public static void decToBinary(int n){

        int myNum=n;
        int pow=0;
        int binNum=0;
        while (n!=0){
            int rem=n%2;

            binNum=binNum+(rem*(int)Math.pow(10,pow));
            pow++;
            n=n/2;
        }

        System.out.println(" binary form of  number is "+myNum+"  =" +binNum);

    }


    public static void main(String[] args) {
      boolean checkPrime=  prime(11);

        primeRange(25);
        double pow = Math.pow(10, 0);

        System.out.println(pow+" pow");

        System.out.println("given number is prime "+checkPrime);


        System.out.println("===============");

        binaryToDec(101);


        System.out.println("======= jbjnnl ==");

        decToBinary(5);
    }
}
