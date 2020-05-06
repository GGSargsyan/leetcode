class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1)
            return nums[0];
        
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer> ((e1, e2) -> {
            return e2.compareTo(e1);
        });
        
        int result = 0;
        
        for(int n : nums){
            maxheap.add(n);
        }
        
        for(int i = 0; i < k; i++){
            result = maxheap.poll();
        }
        
        return result;
    }
}