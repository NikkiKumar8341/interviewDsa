package flowChart;

import java.util.Scanner;

public class SimpeInterest {


    public static double interst(double principal,double time, double rate ){


        double interest = (principal * time * rate) / 100;

        return interest;
    }


    public static void  isPrime(){
        Scanner input = new Scanner(System.in);

        System.out.println("enter the input");
        int n=input.nextInt();
        int div=2;

        while (div<n){

            if(n%div==0){
                System.out.print(n+" is not a prime");
                break;
            }else{
                div=div+1;
            }

            System.out.println(n+" is a prime number");
        }

    }

    public static void main(String[] args) {

        double a= interst(3600000,207,8.5);

        System.out.println(a);

        isPrime();
    }
}
