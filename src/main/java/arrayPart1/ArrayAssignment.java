package arrayPart1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayAssignment {


    public static boolean noDuplicate(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();


        for (int i=0;i< arr.length;i++){
            int value=map.getOrDefault(arr[i],0);
            map.put(arr[i],value+1);
        }

        boolean hasDuplicateValue = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > 1) {
                hasDuplicateValue = true;
                break;
            }
        }

        return hasDuplicateValue;
    }


    public static void pairSum(int[] arr){

        int count=0;
        for(int i=0;i< arr.length;i++){
            for(int j=i;j< arr.length;j++){

                for (int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                count++;
                System.out.println();
            }
            System.out.println();

        }
        System.out.println("total count : "+count);
    }


    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();

        int degree = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            degree = Math.max(degree, freqMap.get(num));

            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }
            lastIndex.put(num, i);
        }

        int minLength = nums.length;

        for (int num : freqMap.keySet()) {
            if (freqMap.get(num) == degree) {
                int length = lastIndex.get(num) - firstIndex.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }


    public static int[] sumOfNum(int[] nums,int target){

        int n=nums.length;


        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=1;j<n;j++){
                sum=nums[i]+nums[j];
                if (sum==target){
                   return new int[]{i,j};
                }
            }
        }

        return new int[]{-1,-1};
    }

    public static boolean sumofNumHash(int[] arr,int target){

        HashMap<Integer,Integer> map=new HashMap<>();
        boolean ispresent=false;

        for (int i=0;i<arr.length;i++){
            int num=arr[i];
            int moreNeeded=target-num;

            if(map.containsKey(moreNeeded)){
                return true;
            }
            map.put(arr[i],i);
        }

        return ispresent;

    }

    public static int[] sumofTargetNum(int[] arr,int target){
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<arr.length;i++){
            int num=arr[i];
            int moreNeeded=target-num;

            if (map.containsKey(moreNeeded)){
                int firstInex=map.get(moreNeeded);

                return new int[]{firstInex,i};
            }

            map.put(arr[i],i);
        }

        return new int[]{-1,-1};
    }




    public static void main(String[] args) {

        int[] map={1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        int[] map1={1, 2, 3, 4};

        boolean b = noDuplicate(map1);

        System.out.println(b+" there are repeated values in map array");

        int[] arr={1,2,3,4};

        pairSum(arr);

        int[] nums = {1, 2, 2, 3, 1};
        System.out.println("Length of shortest subarray with same degree: " + findShortestSubArray(nums));

        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(100, 2);
        freqMap.put(101, 3);
        freqMap.put(103, 1);

        for(int num:freqMap.keySet()){
            freqMap.get(num);
            System.out.println("value "+ freqMap.get(num));
        }


        int[] ispresent={2,6,5,8,11};
        int target=14;

        int[] ints = sumOfNum(ispresent, target);



        System.out.println("14 is present in arr "+sumofNumHash(ispresent,target));


        System.out.println( Arrays.toString(sumofTargetNum(ispresent,19)));


    }
}
