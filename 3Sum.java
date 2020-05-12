class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                
                int left = i+1;
                int right = nums.length - 1;
                int targetSum = 0 - nums[i];
                while(left < right){
                    int sum = nums[left] + nums[right];
                    if(sum == targetSum){
                        results.add(Arrays.asList(nums[left], nums[right], nums[i]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if (sum < targetSum)
                        left++;
                    else 
                        right--;
                }
            }
        }
        return results;
    }
}