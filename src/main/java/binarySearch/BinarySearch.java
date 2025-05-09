package binarySearch;

public class BinarySearch {


    public static void lowerBound(int[] nums,int target){

        int low=0,high= nums.length-1;
        int ans=-1;

        while (low<=high){
            int mid=(low+high)/2;

            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1; // go left
            } else {
                low = mid + 1; // go right
            }
        }

        System.out.println("lower bound index : "+ans);
    }

    public static void upperBound(int[] nums,int target){

        int lo= 0, hi= nums.length-1;
        int ans=-1;

        while (lo<=hi){
            int mid=(lo+hi)/2;

            if (nums[mid]<target){
                lo=mid+1;
            } else if (nums[mid]>target) {
                hi=mid-1;
            }else {
                ans=mid;
                lo=mid+1;
            }
        }

        System.out.println("upper bound : "+ans);
    }




    public static void main(String[] args) {

        int[] binaryArr={3,4,13,13,13,20,40};



        lowerBound(binaryArr,20);

        upperBound(binaryArr,13);


    }
}
