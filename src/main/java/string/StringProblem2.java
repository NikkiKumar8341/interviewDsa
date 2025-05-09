package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringProblem2 {


    public static String removeAChar(String str,char ch){

        StringBuilder result=new StringBuilder();

        for (char cr:str.toCharArray()) {
            if (cr != ch) {
                result.append(cr);
            }
        }

        return result.toString();

    }


    public static void palindrome(String str){


        StringBuilder myBuild=new StringBuilder();

        for (int i=str.length()-1;i>=0;i--){
           myBuild.append(str.charAt(i));
        }

        System.out.println(myBuild.toString());
        if (myBuild.toString().equals(str)){
            System.out.println("it is palindrome");
        }else {
            System.out.println("no ");
        }
    }

    public static void charLen(String sr){


        String ab="";

        for (int i=0;i< sr.length();i++){
            if (sr.charAt(i)!=' '){
               ab+=sr.charAt(i);
            }
        }

        System.out.println(ab.length());

    }

    public static void anagram(String str1,String str2){

        if (str1.length()!=str2.length()){
            System.out.println("not an anagram");
        }

        char[] ch1=str1.toCharArray();
        char[] ch2=str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        if (Arrays.equals(ch1,ch2)){
            System.out.println(str1+" is angram to "+str2);
        }else {
            System.out.println("no a anagram");
        }



    }

    public static String reverseVowels(String s) {

        char[] st=s.toCharArray();

        int left=0;
        int right=s.length()-1;

        while(left<right){

            if(!isVowels(st[left])){
                left++;
            }else if(!isVowels(st[right])){
                right--;
            }else{
                char temp=st[left];
                st[left]=st[right];
                st[right]=temp;
                left++;
                right--;
            }
        }


        return String.valueOf(st);
    }

    public static boolean isVowels(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';

    }

    public static int firstUniqChar(String s) {

        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();

        for (int i=0;i<s.length();i++){
           int value=map.getOrDefault(s.charAt(i),0);
           map.put(s.charAt(i),value+1);
        }

        for (int i=0;i<s.length();i++){
            if ( map.get(s.charAt(i))==1){
                return i;
            }

        }

        return -1;


    }

    public static boolean wordPattern(String pattern, String s) {

        String[] str=s.split(" ");
        if (pattern.length()!=str.length){
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(str[i])) {
                    return false;
                }
            } else {
                // Make sure no two characters map to the same word
                if (map.containsValue(str[i])) {
                    return false;
                }
                map.put(ch, str[i]);
            }
        }

        return true;



    }

    public static boolean isPalindrome(String s) {

        s=s.toLowerCase().replaceAll("[^A-za-z0-9]","");
        int left=0;
        int right=s.length()-1;

        System.out.println(s);

        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;

    }

    public static void main(String[] args) {

        String str="abbach";

        System.out.println(removeAChar(str,'c'));

        String str1="Hello Java ";

        palindrome("abba");

        charLen(str1);

        String s1="eepk";
        String s2="peek";

        String uniqueChar="aabb";

        anagram(s1,s2);

        System.out.println(firstUniqChar(uniqueChar));

        String st1="IceCreAm";

        System.out.println(reverseVowels(st1));

        String pattern ="abba";

        String s ="dog cat cat fish";

        wordPattern(pattern,s);

        String sb="ab_c";

        isPalindrome(sb);

        String sb2 = "ab_c";
        sb2 = sb2.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        System.out.println(sb2);
    }
}
