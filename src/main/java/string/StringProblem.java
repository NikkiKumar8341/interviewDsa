package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringProblem {
    public static boolean reverseString(String str){

        boolean isPresent= true;

        for (int i=0;i<str.length();i++){
            int n=str.length();
            if (str.charAt(i)!=str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }


    public static String toUpperCase(String str){

        StringBuilder sb=new StringBuilder("");

        char ch=Character.toUpperCase(str.charAt(0));

        sb.append(ch);

        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String compress(String str){
        String newStr="";

        for (int i=0;i<str.length();i++){
            Integer count=1;

            while (i<str.length()-1 && str.charAt(i)== str.charAt(i+1)){
                count++;
                i++;
            }
            newStr +=str.charAt(i);

            if (count>1){
                newStr +=count.toString();
            }
        }


        return newStr;
    }

    public static String reverseWord(String s){

        String rev="";

        for (int i=s.length()-1;i>=0;i--){
            rev=rev+s.charAt(i);
        }

        return rev;

    }
    public static int lengthOfLastWord(String s){
        String s1=s.trim();

        int count=0;

        for (int i=s1.length()-1;i>=0;i--){
            if(s1.charAt(i)!=' '){
                count++;
            }else {
                break;
            }
        }
        return count;
    }

    public static void reverseWord_Space(String s){

        String[] words = s.split(" ");

        StringBuilder reversedStr = new StringBuilder();



        for (String word : words){
            StringBuilder reversedWord=new StringBuilder(word);
            reversedStr.append(reversedWord.reverse().toString()).append(" ");
        }

        System.out.println("reversed Sentence : "+reversedStr.toString().trim());

    }

    public static void removeDuplicateChar(String str){
        StringBuilder result = new StringBuilder();
        Set<Character> seen=new HashSet<>();

        for (char ch :str.toCharArray()){
            if(!seen.contains(ch)){
                seen.add(ch);
                result.append(ch);
            }
        }
        System.out.println("removed Duplicates :"+result);
    }

    public static boolean isAlphabetOnly(String str){

        boolean ispresent=true;

        for (char ch: str.toCharArray()){
            if (Character.isDigit(ch)){
             return false;
            }
        }


        return ispresent;
    }


    public static int countWords(String str){

       String[] words=str.split(" ");

       return words.length;
    }

    public static String longestWord(String str){

        String[] words = str.split(" ");

        String longest="";

        for (int i=0;i<words.length;i++){

            if (words[i].length()>longest.length()){
                longest=words[i];
            }

        }

        return longest;

    }


    public static int firstOccur(String hayStack,String needle){

        int hLen = hayStack.length();
        int nLen = needle.length();

        // Edge case
        if (nLen == 0) return 0;

        for (int i = 0; i <= hLen - nLen; i++) {
            String sub = hayStack.substring(i, i + nLen);
            if (sub.equals(needle)) {
                return i;
            }
        }

        return -1; // N

    }


    public static void reverseWordStr(String str){
        String[] words = str.trim().split("\\s+");

        StringBuilder reverseWord=new StringBuilder();

        for (int i=words.length-1;i>=0;i--){
            StringBuilder reverseStr=new StringBuilder(words[i]);
            reverseWord.append(reverseStr.toString()).append(" ");
        }


        System.out.println(reverseWord.toString().trim());

    }

    public static boolean vaildPalindrome(String str){

        String replace = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        int  i=0,end=replace.length()-1;

        while (i<end){
            if(replace.charAt(i)!=replace.charAt(end)){
                return false;
            }
            i++;
            end--;
        }

        return true;
    }


    public static String prefix(String[] arr){

        String v1=arr[0];

        for (int i=1;i<arr.length;i++){
            while (arr[i].indexOf(v1)!=0){
                v1 =v1.substring(0,v1.length()-1);

            }
        }

      return v1;
    }


    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        // Step 1: Check if pattern and words length match
        if (pattern.length() != words.length) {
            return false;
        }

        // Step 2: Create two maps to track bijection
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        // Step 3: Iterate through pattern and words together
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Case 1: Character already has a mapping
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false; // current word doesn't match previous mapping
                }
            }
            // Case 2: Character has no mapping yet
            else {
                if (wordToChar.containsKey(word)) {
                    return false; // word already mapped to another character
                }

                // Create new mapping
                charToWord.put(c, word);
                wordToChar.put(word, c);
            }
        }

        // If all mappings matched properly
        return true;
    }








    public static void main(String[] args) {

        String[] arr={"apple","mango","banana"};

        String largest=arr[0];

        for (int i=0;i<arr.length;i++){
            if (largest.compareTo(arr[i])<0){
                largest=arr[i];
            }
        }

        System.out.println("largest string is  : "+largest);

        System.out.println("is a palindrome : "+reverseString("madam"));

        String str1="Tony";

        String  str2= str1.replace('o','a');



        System.out.println(str2+" str2");

        System.out.println(str1+" str1");


        StringBuilder word=new StringBuilder("Tony");

        word.replace(0,1,"S");
        System.out.println(word);

        String space_word="hi, i am nikhil";

        System.out.println(toUpperCase(space_word));


        String str="aaabbcccddd";


        System.out.println("compressed string is : "+ compress(str));

        String s ="fly me   to   the moon  ";
        String fly="fly";


        System.out.println("fly is substring of s: "+s.substring(0,3).equals(fly));

        System.out.println("length of last word :"+s+" is "+lengthOfLastWord(s));

        String rev="google";

        System.out.println(reverseWord(rev));


        String rev_space="Hello World";

        reverseWord_Space(rev_space);

        removeDuplicateChar("programming");

        System.out.println("it has alphabets :"+ isAlphabetOnly("abba12"));

        System.out.println("number of words is : "+countWords("my name is nikhil kumar"));

        System.out.println("longest : "+longestWord("my name is nikhil kumar"));

       String haystack = "sadbutsad", needle = "but";

        int i = haystack.indexOf(needle);

        System.out.println("first occurs : "+i);

        System.out.println("first occur of needle "+firstOccur(haystack,needle));

        reverseWordStr("a good   example");

        String dupc="Hello";

        Set<Character> set=new HashSet<>();

        for (char ch:dupc.toCharArray()){
            set.add(ch);
        }

        set.forEach(System.out::println);

        System.out.println("is vaild palindrome "+ vaildPalindrome("A man, a plan, a canal: Panama"));

        String[] arr2={"float","flow","flower","flight"};
        System.out.println("jshadjh");
        System.out.println(prefix(arr2));

        String pattern ="abba";

        String s3 ="dog cat cat fish";


       boolean wordPatternCheck= wordPattern(pattern,s3);

        System.out.println(wordPatternCheck+"wordpatteren check");


    }
}
