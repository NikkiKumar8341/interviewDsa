package sorting;

public class SortingAlgo {


    public static void bubbleSort(int[] arr){

        int n= arr.length-1;

        for (int turn=0;turn<n-1;turn++){
            for (int j=0;j<n-1-turn;j++){
                if(arr[j]>arr[j+1]){
                    //swap arrays
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;


                }
            }
        }

    }

    public static void selectionSort(int[] arr){
        for (int i=0;i< arr.length-1;i++){
            int misPos=i;
            for (int j=i+1;j< arr.length;j++){
                if(arr[misPos]>arr[j]){
                    misPos=j;
                }
            }
            //swap
            int temp=arr[misPos];
            arr[misPos]=arr[i];
            arr[i]=temp;
        }


    }

    public static int sellStock(int[] prices){

        int buyPrice=Integer.MIN_VALUE;

        int maxProfit=0;

        for(int i=0;i<prices.length;i++){
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
        int[] bubSort={3,5,1,10,7,6,4};
        bubbleSort(bubSort);
        for (int i=0;i< bubSort.length-1;i++){
            System.out.print(bubSort[i]+" ");
        }

        int [] seleSort={3,4,7,1,56,5,9};
        selectionSort(seleSort);
        for (int i=0;i< seleSort.length;i++){
            System.out.print(seleSort[i]+" ");
        }
        System.out.println("");


        int[] prices={7,1,5,3,6,4};

        int maxProfit=sellStock(prices);
    }
}
