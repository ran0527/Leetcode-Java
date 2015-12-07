public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(!arr[i].equals(""))
                res.append(arr[i]).append(" ");
        }
        return res.length() == 0 ? "" : res.substring(0, res.length() - 1);
    }

}Reverse Words in a String.ja
