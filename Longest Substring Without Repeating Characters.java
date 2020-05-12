class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        
        HashSet<Character> count = new HashSet<>();
        
        while(right < s.length())
        {
            if(!count.contains(s.charAt(right))){
                count.add(s.charAt(right));
                right++;
                result = Math.max(result, count.size());
            }
            else{
                count.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }
}