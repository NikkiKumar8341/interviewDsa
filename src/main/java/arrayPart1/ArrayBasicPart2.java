package arrayPart1;

public class ArrayBasicPart2 {


    public static int trappedRainWater(int[] height){
        int n=height.length;

        //left max
        int[] leftMax=new int[n];
        leftMax[0]=height[0];

        for (int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i], leftMax[i-1]);
        }

        //right max
        int[] rightMax=new int[n];
        rightMax[n-1]=height[n-1];

        for (int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }

        //trappedWater
        int trappedWater=0;

        for (int i=0;i<n;i++){

            //calculate water level
            int waterLevel=Math.min(leftMax[i],rightMax[i]);

            //calculate trapped water
            trappedWater+=waterLevel-height[i];
        }

        return trappedWater;

    }


    public static int mostWater(int[] container){

        int maxWater=0;

        int n= container.length-1;

        for (int i=0;i<n;i++){

            for(int j=i+1;j<n;j++){

                int width=j-i;

                int height=Math.min(container[i],container[j]);

                int area=width*height;

                maxWater=Math.max(area,maxWater);

            }
        }

        return maxWater;
    }

    public static int twoPointerWater(int[] container){
        int n=container.length-1;
        int left=0,right=n-1;
        int maxWater=0;

        while (left<right){

            int width=right-left;
            int height=Math.min(container[left],container[right]);

            int area=width*height;

            maxWater=Math.max(area,maxWater);

            if(container[left]<container[right]){
                left++;
            }else {
                right--;
            }

        }

        return maxWater;
    }


    public static int maxSubarray(int[] nums){
        int n=nums.length;
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        int[] preFixSum=new int[n];

        preFixSum[0]=nums[0];

        for (int i=1;i<n;i++){
            preFixSum[i]=preFixSum[i-1]+nums[i];
        }


        for (int i=0;i<n;i++){
           int  start=i;
            for(int j=i;j<n;j++){
                int end=j;


                currSum= start ==0 ? preFixSum[end] : preFixSum[end]-preFixSum[start-1];

                if(maxSum<currSum){
                    maxSum=currSum;
                }
            }
        }

        return maxSum;

    }


    public static void equilibrumIndex(int[] nums){
        int n=nums.length;
        int [] prefixSum=new int[n];
        prefixSum[0]=nums[0];

        int equCount=0;

        for (int i=1;i<n;i++){
            prefixSum[i]=nums[i]+prefixSum[i-1];
        }

        //find the equilibrum point


        for (int i=0;i<n;i++){
            int leftSum = (i == 0) ? 0 : prefixSum[i - 1];
            int rightSum = prefixSum[n - 1] - prefixSum[i];

            if (leftSum == rightSum) {
                System.out.println("Equilibrium index found at: " + i);
            }
        }
    }


    public static int maxProduct(int[] nums){

        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] height={4,2,0,6,3,2,5};

        trappedRainWater(height);

        int[] container={1,8,6,2,5,4,8,3,7};

        int maxWaterInContainer=mostWater(container);

        System.out.println("max water in container : "+maxWaterInContainer);




        int mostWater = twoPointerWater(container);

        System.out.println("max water in container two pointer :"+mostWater);

        int[] maxSubArr={1,-2,-6,4,8,1,-10,9};

        int maxSum= maxSubarray(maxSubArr);
        System.out.println("sub array max sum :"+maxSum);

        int[] equ={-3,2,4,-1};
        equilibrumIndex(equ);

        int[] maxProductArr={2,3,-2,4};

       int maxProductSubArray=maxProduct(maxProductArr);

        System.out.println("max product sub array : "+maxProductSubArray);
    }
}
