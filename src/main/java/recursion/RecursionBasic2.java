package recursion;

import java.util.ArrayList;

public class RecursionBasic2 {


    public  static void mergeSort(int[] arr,int start,int end){
        if (start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        mergeSort(arr,start,mid);//left sort
        mergeSort(arr,mid+1,end);//right sort
        merge(arr,start,mid,end);

    }

    public static void merge(int[] arr,int start,int mid,int end){
        int[] temp=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;


        while (i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
            }else {
                temp[k]=arr[j];
                j++;
            }
            k++;
        }


        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=end){
            temp[k++]=arr[j++];
        }
        for (k = 0,i=start; k < temp.length; k++,i++) {
            arr[i] = temp[k];
        }
    }


    public static String removeCharacter(String str,char c,String results){

        if (str.isEmpty()){
            return results;
        }

        char first=str.charAt(0);

        if (first!=c){
            results+=first;
        }

        return removeCharacter(str.substring(1),c,results);

    }

    public static  void subSeq(String p,String up){

        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch=up.charAt(0);

        subSeq(p+ch,up.substring(1));
        subSeq(p,up.substring(1));
    }

//    public static ArrayList<String> subSeqArr(String p,String up,ArrayList<Integer> list){
//        if (up.isEmpty()){
//            return;
//        }
//
//        subSeqArr(p, up, list);
//    }

    public static Boolean arraySorted(int[] arr,int index){
        if (index==arr.length-1){
            return true;
        }

        if(arr[index]>arr[index+1]){

            return false;
        }
        return arraySorted(arr,index+1);
    }

    public static int secondMax(int[] arr){

        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        
        for (int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
            } else if (arr[i]>secondLargest && arr[i]!=largest) {
                secondLargest=arr[i];
            }
        }

        return secondLargest;
    }


    public static void main(String[] args) {
        int[] arr={34,45,23,6,43,5,23,534,6};

        mergeSort(arr,0, arr.length-1);

        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        String str="abbacadaded";
        String results=removeCharacter(str,'b',"");

        System.out.println(results);


//        String mySresult=results.substring(1);

//        System.out.println(mySresult);

        subSeq("","abc");

        int[] sortCheck={-1,-3,-2};

        Boolean isSorted = arraySorted(sortCheck, 0);

        System.out.println("is sorted "+isSorted);


        System.out.println(secondMax(sortCheck));


    }
}
