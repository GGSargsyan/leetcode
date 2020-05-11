class Solution {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> results = new ArrayList<>();
        
        int[] ends = new int[26];
        
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            ends[c - 'a'] = i;
        }
        
        int left = 0;
        int right = 0;
        for(int i = 0; i < S.length(); i++){
            right = Math.max(right, ends[S.charAt(i)-'a']);
            if(i == right){
                results.add(right-left+1);
                left = right + 1;
            }
        }
        
        
        return results;
    }
}