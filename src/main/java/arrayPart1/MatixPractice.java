package arrayPart1;

public class MatixPractice {


    public static void linearSearch(int[][] a,int key){

        for (int j = 0; j < a[0].length; j++) { // columns first
            for (int i = 0; i < a.length; i++) { // then rows
                System.out.print(a[i][j] + " ");
            }
            System.out.println(); // move to next column line
        }



    }

    public static void compress(String s){

        StringBuilder str=new StringBuilder();


        for (int i=0;i<s.length();i++){
            Integer count=1;
           while (i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
               count++;
               i++;
           }
           str.append(s.charAt(i));
           if(count>1){
               str.append(count.toString());
           }
        }


        System.out.println(str);

    }


    public static int maxRowSum(int[][] a){

        int maxSum=Integer.MIN_VALUE;

        for (int i=0;i< a.length;i++){
            int sum=0;

            for (int j=0;j<a[0].length;j++){
                sum+=a[i][j];
            }
            maxSum=Math.max(sum,maxSum);
        }

        return maxSum;
    }

    public static void diagonalSum(int[][] a){

        int pd=0;
        int sd=0;
        int n=a[0].length;

        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                if (i==j){
                    pd+=a[i][j];
                } else if (i==n-i-1) {
                    sd+=a[i][j];
                }
            }
        }

        System.out.println("sum of pd :"+pd);
        System.out.println("sum of sd :"+sd);
    }


    public static void main(String[] args) {

        int[][] mat1={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};



        linearSearch(mat1,11);

        String s="aaabbbccdd";

        compress(s);

        int maxSum=maxRowSum(mat1);

        System.out.println(maxSum+" max sum");

        diagonalSum(mat1);

    }
}
