package arraylistpart1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListPart1 {


    public static int maxNum(ArrayList<Integer> list){

        Integer max=Integer.MIN_VALUE;

        for (int i=0;i<list.size();i++){
            if (list.get(i)>max){
                max=list.get(i);
            }
        }

        return max;

    }

    public static void swap(ArrayList<Integer> list,int index1,int index2){

        int temp=list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2,temp);



    }

    public static int mostWater(ArrayList<Integer> list){

        int maxWater=0;
        int left=0;
        int right=list.size()-1;

        while (left<right){
            int ht=Math.min(list.get(left),list.get(right));
            int width=right-left;

            int area=ht*width;

            maxWater=Math.max(area,maxWater);

            if (list.get(left)<list.get(right)){
                left++;
            }else {
                right--;
            }
        }

        return maxWater;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();


        list.add(20);
        list.add(10);
        list.add(2);
        list.add(50);

        list.add(2,25);

        list.set(0,15);
        list.remove(1);

        System.out.println(list);


        int max=maxNum(list);
        System.out.println("max num is "+max);

        swap(list,1,3);

        System.out.println(list);

        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();

        ArrayList<Integer> l1=new ArrayList<>();

        l1.add(1);
        l1.add(2);
        l1.add(3);
        mainList.add(l1);

        ArrayList<Integer> l2=new ArrayList<>();
        l2.add(4);
        l2.add(5);
        l2.add(6);
        mainList.add(l2);

        for (int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList=mainList.get(i);

            for (int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }

            System.out.println();
        }


        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 8, 6, 2, 5,4,8,3,7));

       int area= mostWater((ArrayList<Integer>) numbers);

        System.out.println(area);



    }
}
