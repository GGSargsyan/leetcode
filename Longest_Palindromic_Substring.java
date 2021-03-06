class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        if(s.length() == 1)
            return s;
        int[] currLongest = {0, 1};
		for(int i = 1; i < s.length(); i++){
			int[] odd = longestSubstring(s, i-1, i+1);
			int[] even = longestSubstring(s, i-1, i);
			int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
			if(longest[1] - longest[0] > currLongest[1] - currLongest[0])
				currLongest = longest;
		}
    return s.substring(currLongest[0], currLongest[1]);
  }
	
	public static int[] longestSubstring(String string, int left, int right){
		while(left >= 0 && right < string.length()){
			if(string.charAt(left) != string.charAt(right)){
				break;
			}
			left--;
			right++;
		}
		return new int[] {left + 1, right};
	}
        
}
