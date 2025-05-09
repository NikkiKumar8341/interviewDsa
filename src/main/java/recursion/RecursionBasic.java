package recursion;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

public class RecursionBasic {

    static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void printDec(int n){

        if (n==1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }


    public static void printEven(int n){
        if (n <= 0) return;

        printEven(n - 1); // Always go down to 1 first

        if (n % 2 == 0) {
            System.out.println(n);
        }
    }

    public static int factOf(int n){
        if(n==1){
            return 1;
        }

        int fn1=factOf(n-1);
        int fn=n*fn1;

        return fn;
    }

    public static int fact(int n){
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        } else {
            // Recursive case: n * factorial of (n-1)
            return n * fact(n - 1);
        }
    }

    public static int sumOf(int n){
        if(n==1){
            return 1;
        }

        return n+sumOf(n-1);
    }

    public static void printFibonacciIterative(int n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }

    public static int fibonacciSerie(int n){
        if(n==0 || n==1){
            return n;
        }

        int fn1=fibonacciSerie(n-1);
        int fn2=fibonacciSerie(n-2);
        int fn=fn1+fn2;

        return fn;
    }


    public static int firstOccur(int[] arr,int key,int i){
        if(i==arr.length){
            return -1;
        }


        if (arr[i]==key){
            return i;
        }

        return firstOccur(arr,key,i+1);
    }

    public static int lastOccur(int arr[],int key,int i){

        if(i==arr.length){
            return -1;
        }
        int isFound=lastOccur(arr, key, i+1);

        if (isFound ==-1 && arr[i]==key){
            return i;
        }



        return isFound;
    }

    public static void removeDuplicateStr(String str,int idx,StringBuilder newStr,boolean map[]){
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }

        //logic
        char curChar=str.charAt(idx);

        if (map[curChar-'a']== true){
            //duplicate
            removeDuplicateStr(str, idx+1, newStr, map);
        }else {
            map[curChar-'a']=true;
            removeDuplicateStr(str, idx+1, newStr.append(curChar), map);
        }
    }


    public static int friendsPairing(int n){

        if(n==1 || n==2){
            return n;
        }

        //choice //single

        int fnm1=friendsPairing(n-1);


        //pair
        int fnm2=friendsPairing(n-2);
        int pairWays=(n-1)*fnm2;

        //toatl ways

        int totalWays=fnm1+pairWays;

        return totalWays;
    }

    public static void allOccurence(int[] arr,int key,int index){
        if (index== arr.length){
            return;
        }

        if (arr[index]==key){
            System.out.print(index+" ");
        }

        allOccurence(arr, key, index + 1);
    }

    public static ArrayList<Integer> allPossible(int[] arr, int key, int index, ArrayList<Integer> list){

        if (index==arr.length-1){
            return list;
        }

        if (arr[index]==key){
            list.add(index);
        }

      return allPossible(arr,key,index+1,list);
    }

    public static ArrayList<Integer> allPossibleList(int[] arr,int key,int index){
        ArrayList<Integer> list=new ArrayList<>();

        if (index==arr.length-1){
            return list;
        }
        if (arr[index]==key){
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = allPossibleList(arr, key, index + 1);
        list.addAll(ansFromBelowCalls);

        return list;
    }

    public static void printDigits(int number){
        if (number ==0){
            return;
        }


        int lastDigit=number%10;

        printDigits(number/10);

        System.out.print(digits[lastDigit]+" ");
    }


    public static void printNto1(int n){
        if (n==0){
            return;
        }

        System.out.print(n+" ");
        printNto1(n-1);
    }


    public static int sumOfDigits(int number){

        if (number==0){
            return 0;
        }

        int lastDigit=number%10;
        int remaining=number/10;

        int sumOfDigi=sumOfDigits(remaining)+lastDigit;

        return sumOfDigi;
    }

    static int reverse=0;

    public static int reverseNumber(int number){
        if (number == 0){
            return reverse;
        }

        int digit = number % 10;
        reverse = reverse * 10 + digit;
        return reverseNumber(number / 10);
    }

    public static boolean palindrome(int n){
        reverse = 0; // Reset before calling
        return n == reverseNumber(n);
    }

    public static int countZeroDigits(int num,int count){
        if (num==0){
            return count;
        }

       int lastDigit=num%10;

       if (lastDigit==0){
         return countZeroDigits(num/10,count+1);
       }

       return countZeroDigits(num/10,count);


    }

    public static int countSteps(int num,int step){
        if(num==0){
            return step;
        }


        if (num % 2 == 0) {
            return countSteps(num / 2, step + 1); // correct step for even
        }
        return countSteps(num-1,step+1);
    }

    public static boolean isSortedArr(int[] arr,int index){
        if (index==arr.length-1){
            return true;
        }

        return arr[index]<arr[index+1] && isSortedArr(arr,index+1);
    }





    public static void main(String[] args) {

        printDec(10);

        printEven(10);

        System.out.println(fact(5));


        System.out.println("factorial 5 :"+factOf(5));


        printFibonacciIterative(7);




        int[] arr={8,44,59,9,343,8,873};


        int i = firstOccur(arr, 343, 0);

        System.out.println("index of arr  is "+i);

        int j=lastOccur(arr,8,0);

        System.out.println("last index of arr "+j);


        String str="appnacollege";
        removeDuplicateStr(str,0,new StringBuilder(""),new boolean[26]);


        System.out.println("friends pairing : "+friendsPairing(2));

        allOccurence(arr,8,0);

        printDigits(1021);


        printNto1(5);



        for (int fin=0;fin<7;fin++){
            System.out.println(fibonacciSerie(fin));
        }

        int sumof = sumOfDigits(123);

        System.out.println(sumof+" sumo f");


        reverse = 0; // reset before call
        reverseNumber(121);
        System.out.println("Reversed number: " + reverse);


        boolean palindrome = palindrome(121);

        System.out.println("is palindrome"+palindrome);



        int countmy=countZeroDigits(102104,0);

        System.out.println("count zeros "+countmy);


        int countSteps=countSteps(14,0);

        System.out.println("count steps :"+countSteps);

        int[] arr1={1,2,3,4,5};

        System.out.println("array is sorted: "+isSortedArr(arr1,0));


        int[] arrayOf={1,2,1,2,1,2,6,15,25,4};
        ArrayList<Integer> arrayList = allPossible(arrayOf, 2, 0, new ArrayList<>());

        System.out.println("all possible of key 2 :"+arrayList);

//        arrayList.forEach(System.out::println);

    }
}
