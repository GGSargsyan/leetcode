class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1)
            return nums;
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxheap = 
            new PriorityQueue<>((e1, e2) -> e2.getValue()-e1.getValue());
        
        maxheap.addAll(freq.entrySet());
        int[] results = new int[k];
        
        for (int i = 0; i < k; i++) {
            results[i] = maxheap.poll().getKey();
        }
        
        return results;
    }
}