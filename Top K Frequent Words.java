class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        for(String word : words){
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> maxheap = 
            new PriorityQueue<>((e1, e2) -> e2.getValue() == e1.getValue() ? 
                                e1.getKey().compareTo(e2.getKey()) : e2.getValue()-e1.getValue());
        
        maxheap.addAll(freq.entrySet());
        
        List<String> results = new ArrayList<String>();
        String[] r = new String[k];
        
        for(int i = 0; i < k; i++){
            results.add(maxheap.poll().getKey());
        }
        return results;
    }
}