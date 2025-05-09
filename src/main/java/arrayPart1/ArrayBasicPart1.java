package arrayPart1;

import java.util.HashMap;
import java.util.Map;

public class ArrayBasicPart1 {


    public static int largest(int arr[]){

        int largest_num=arr[0];

        for (int i=1;i<arr.length;i++){
            if(arr[i]>largest_num){
                largest_num=arr[i];
            }
        }
        return largest_num;
    }



    public static int binarySearch(int arr[],int key){

        int start=0,end= arr.length-1;

        while (start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){
                return mid;
            } else if (arr[mid]>key) {//left
                end=mid-1;
            }else {
                start=mid+1;
            }
        }

        return -1;
    }

    public static int[] reverse(int[] arr){

        int first=0,end=arr.length-1;

        while (first<end){
            int temp=arr[end];
            arr[end]=arr[first];
            arr[first]=temp;
            first++;
            end--;
        }

        return arr;
    }

    public static void printPair(int arr[]){

        int totalPairCount=0;
        

        for (int i=0;i<arr.length;i++){
            int curr=arr[i];
            for (int j=i+1;j<arr.length;j++){
                System.out.print("("+curr+" ,"+arr[j]+")");
                totalPairCount++;
            }
            System.out.println();
        }

        System.out.println("total number of pairs : "+totalPairCount);


    }

    public static void printSubPair(int arr[]){

        int totalSubArray=0;

        for (int i=0;i<arr.length;i++){
            int start=i;

            for (int j=i;j<arr.length;j++){
                int end=j;

                int sum=0;
                for (int k=start;k<=end;k++){

                    System.out.print(arr[k]+" ");

                    sum+=arr[k];
                }
                System.out.print("the sum is "+sum);
                totalSubArray++;
                System.out.println();
            }

            System.out.println();
        }

        System.out.println("total sub Array : "+totalSubArray);


    }


    public static int maxSum(int arr[]){

        int max_sum=Integer.MIN_VALUE;

        for (int i=0;i<arr.length;i++){
            int sum=0;
            for (int j=i+1;j<arr.length;j++){
                sum+=arr[j];
                max_sum=Math.max(sum,max_sum);
            }
        }

        return max_sum;

    }


    public static int maxSubArray(int[] nums) {

        int max_sum=Integer.MIN_VALUE;

        int curr_sum=0;

        for(int i=0;i<nums.length;i++){

            curr_sum+=nums[i];
            max_sum=Math.max(curr_sum,max_sum);

            if(curr_sum<0){
                curr_sum=0;
            }

        }
        return max_sum;
    }

    public static int[] pairSumTwoPointer(int[] arr,int target){

        int[] pairSum={-1,-1};

        int i=0,j=arr.length-1;

        while (i<j){
            int sum;
            sum=arr[i]+arr[j];

            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            } else if (sum==target) {
                pairSum[0]=arr[i];
                pairSum[1]=arr[j];
                return pairSum;
            }

        }

        return pairSum;
    }


    public static int majorityElement(int[] nums) {

        int feq=0,ans=0;

        for(int i=0;i<nums.length;i++){

            if(feq==0){
                ans=nums[i];
            }
            if(ans==nums[i]){
                feq++;
            }else{
                feq--;
            }
        }
        return ans;
    }

    public static int majorityNBy3Time(int[] nums){
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            int value=mapp.getOrDefault(nums[i],0);
            mapp.put(nums[i],value+1);
        }

        int byTimes=n/3;

        for(Map.Entry<Integer, Integer> it:mapp.entrySet()){
            if(it.getValue()>(n/3)){
                return it.getKey();
            }
        }

        return -1;

    }


    public static int stockBuyAndSell(int[] prices){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for (int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){
                int profit=prices[i]-buyPrice;
                maxProfit=Math.max(profit,maxProfit);
            }else{
                buyPrice=prices[i];
            }
        }

        return maxProfit;

    }

public static void main(String[] args) {

        int[] arr1={15,20,35,13,17,19};

        int larget_num=largest(arr1);

        System.out.println("largest number is : "+larget_num);

        int[] arr2={2,4,6,8,10,13,25,35,90,100};

        System.out.println("===binary serach");



        System.out.println("index key of arr2 : "+ binarySearch(arr2,25));


        reverse(arr1);
    System.out.println("revers the arr of arr1");

    for (int i=0;i<arr1.length;i++){
        System.out.print(arr1[i]+" ");
    }
    System.out.println("print the pair: ");


    printPair(arr2);


    System.out.println("print suarrays ");

    printSubPair(arr2);

    int[] subArr={1,2,3,4,5};

    System.out.println();


    printSubPair(subArr);


    int[] maxArr={3,-4,5,4,-1,-7,8};

    System.out.println("max sub array : "+maxSum(maxArr));

    int[] ab={-2,1,-3,4,-1,2,1,-5,4};

    System.out.println();

    int[] num={-1,-2,-9,-6};



    System.out.println("Kadane's Algorithm  my maxSubArray is :"+maxSubArray(num));

    int[] twoPair={2,7,11,15};
    int target=26;

    int[] twoPinterApp = pairSumTwoPointer(twoPair, target);

    System.out.println("two pair using two pointer approch");
    for (int num1 : twoPinterApp) {
        System.out.println(num1);
    }


    System.out.println("===majority elements ====");

    int[] maj={6,5,5};

   int majValue= majorityElement(maj);

    System.out.println("majority value is: "+majValue);

    int[] maj3={3,2,3};

    majorityNBy3Time(maj3);

    System.out.println("===buy and sellin for stocl===");

    int[] stockPrices={7,1,5,3,6,4};

    int maxProfit = stockBuyAndSell(stockPrices);

    System.out.println("maXprofit is : "+maxProfit);


}
}
