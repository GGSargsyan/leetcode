class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        /*
        solution: sliding windows 2 passes: l -> r then r -> l
        each pass: keep track of the main window and the max sub window
        ex: [0, 6, 5, 2, 9, 1], L = 1, R = 2
        start with index L + R
        -> [(0), (6, 5), 2, 9, 1] -> maxL = 0, R = 11 -> res = 11
        -> [0, (6), (5, 2), 9, 1] -> maxL = 6, R = 7  -> res = 13
        -> [0, 6, (5), (2, 9), 1] -> maxL = 6, R = 11 -> res = 17
        -> [0, 6, 5, (2), (9, 1)] -> maxL = 6, R = 10 -> res = 17 (17 > 16)
        -> first pass: 17
        second pass: go the opposite way or flip L & R;
        */
        return Math.max(helper(A, L, M), helper(A, M, L));
    }
    
    private int helper(int[] A, int left, int right){
        
        int start = 0;
        int sumL = 0;
        int sumR = 0;
        
        while(start < left) sumL += A[start++];
        while(start < left + right) sumR += A[start++];
        
        int maxL = sumL;
        int result = sumL + sumR;
        
        for(int i = start; i < A.length; i++){
            sumR += A[i] - A[i-right];
            sumL += A[i-right] - A[i-right-left];
            
            maxL = Math.max(maxL, sumL);
            result = Math.max(result, maxL + sumR);
        }
        
        return result;
    }
}