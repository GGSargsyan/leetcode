class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int anchor = 0;
        int result = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] <= nums[i-1])
                anchor = i;
            
           result = Math.max(i - anchor + 1, result);
        }
        return result;
    }
}