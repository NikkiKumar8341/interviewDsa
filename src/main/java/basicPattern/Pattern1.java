package basicPattern;

public class Pattern1 {

    public static void square(){

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern2(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if (i==0 || i==3 || j==0 || j==3){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void pattern3(){
        for(int i=0;i<4;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern4(){
        for(int i=0;i<4;i++){
            for (int j=4;j>i;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern5(){
       for(int i=4;i>0;i--){
           for(int j=0;j<i;j++){
               System.out.print("*");
           }

           System.out.println();
       }
    }


    public static void pattern6(){

        for(int i=4;i>=1;i--){

            for(int j=1;j<=i;j++){
                System.out.print(" ");
            }

            for(int j=4;j>=i;j--){
                System.out.print("*");
            }

            System.out.println();

        }
    }


    public static void pattern7(){
        int n=4;
        for (int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println(" ");
        }
    }

    public static void pattern8(){
        int n=4;
        for (int i=n;i>=1;i--){

            for (int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern9(){
        int num=1;
        int n=5;


        for (int i=1;i<=n;i++){

            for (int j=1;j<=i;j++){
                System.out.print(num+" ");
                num++;
            }

            System.out.println(" ");
        }
    }

    public static void pattern10(){
        int n=5;
        int start=1;

        for(int i=1;i<=n;i++){

            if(i%2==0){
                start=0;
            }else{
                start=1;
            }

            for (int j=1;j<=i;j++){
                System.out.print(start+" ");
                start=1-start;
            }

            System.out.println();
        }
    }

    public static void pattern11(){
        int n=5;
        for (int i=1;i<=5;i++){
            for (int j=1;j<=i;j++){
                int sum=(i+j);

                if (sum%2==0){
                    System.out.print("1 ");
                }else {
                    System.out.print("0 ");
                }


            }
            System.out.println();
        }
    }

    public static void pattern12(){
        int n=3;
        for (int i=1;i<=n;i++){

            for (int j=1;j<=i;j++){
                System.out.print("*");
            }

            for (int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }

            for (int j=1;j<=i;j++){
                System.out.print("*");
            }

            System.out.println();
        }

        //2 half reverse

        for (int i=n;i>=1;i--){

            for (int j=1;j<=i;j++){
                System.out.print("*");
            }

            for (int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }

            for (int j=1;j<=i;j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void pattern13(){

        int n=4;

        for(int i=1;i<=n;i++){

            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            for (int j=1;j<=n;j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void pattern14(){
        int n=5;
        for (int i=1;i<=n;i++){

            for (int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            for (int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }


    public static void pattern15(){
        int n=4;
        for (int i=1;i<=n;i++){

            for (int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            for (int j=i;j>=1;j--){
                System.out.print(j);
            }

            for (int j=2;j<=i;j++){
                System.out.print(j);
            }

            System.out.println();
        }
    }

    public static void pattern16(){
        int n=4;

        for (int i=1;i<=n;i++){

            for (int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            for (int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }

            System.out.println();
        }


        for (int i=n;i>=1;i--){
            for (int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            for (int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }

            System.out.println();
        }


    }

    public static int fact(int n){
        int f=1;

        for (int i=1;i<=n;i++){
            f=f*i;
        }

        return f;
    }


    public static int bioCoe(int n,int r){

        int nfact=fact(n);

        int rfact=fact(r);

        int mrfact=fact(n-r);

        int bio_coe=nfact/(rfact*mrfact);

       return bio_coe;

    }

    public static void hallowRectangle(){

        int n=5;

        for (int row=1;row<=n;row++){
            for (int j=1;j<=n;j++){

                if (row==1 || row==5 || j==1 || j==5 ){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }

            System.out.println();
        }
    }

    public static void hallowRambus(){

        int n=5;

        for (int row=1;row<=n;row++){
            int space=n-row;

            for (int j=1;j<=space;j++){
                System.out.print(" ");
            }

            for (int j=1;j<=n;j++){
                if(row==1 || row ==5 || j==1 || j==5){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }

            System.out.println();
        }
    }





    public static void main(String[] args) {
        square();

        System.out.println("=======pattern 2======");

        pattern2();

        System.out.println("=======pattern 3======");

        pattern3();

        System.out.println("=======pattern 4======");

        pattern4();

        System.out.println("=======pattern 5======");

        pattern5();

        System.out.println("=======pattern 6======");

        pattern6();

        System.out.println("=======pattern 7======");

        pattern7();

        System.out.println("=======pattern 8======");

        pattern8();

        System.out.println("=======pattern 9======");

        pattern9();


        System.out.println("=======pattern 10======");

        pattern10();

        System.out.println("========pattern 11======");

        pattern11();

        System.out.println("========pattern 12======");

        pattern12();

        System.out.println("========pattern 13======");

        pattern13();


        System.out.println("========pattern 14======");

        pattern14();

        System.out.println("========pattern 15======");

        pattern15();

        System.out.println("========pattern 16======");

       pattern16();

       int bioCoe= bioCoe(5,2);

        System.out.println("=====binomial coefficient=====");

        System.out.println(bioCoe);


        System.out.println("====hallow reactangle ====");

        hallowRectangle();


        System.out.println("=====hallow rambus =====");

        hallowRambus();


    }


}
