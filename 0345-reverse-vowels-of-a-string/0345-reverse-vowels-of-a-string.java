class Solution {
    public String reverseVowels(String s) {
        char[]arr=s.toCharArray();
        int start=0,end=s.length()-1;
        while(start<end){
            while(start<end&&!isVowel(arr[start]))start++;
            while(start<end&&!isVowel(arr[end]))end--;
            if(start<end) {
                char temp=arr[start];
                arr[start++]=arr[end];
                arr[end--]=temp;
            }
        }
        return new String(arr);
    }
    public boolean isVowel(char c){
        c=Character.toLowerCase(c);
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}