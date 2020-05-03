class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        PriorityQueue<String> letters = new PriorityQueue<String>((a,b) -> {
            String[] wordsA = a.split(" ", 2); 
            String[] wordsB = b.split(" ", 2);
            if(wordsA[1].equals(wordsB[1]))
                return wordsA[0].compareTo(wordsB[0]);
            return wordsA[1].compareTo(wordsB[1]);
        });
        
        List<String> digits = new ArrayList();
        
        for(String log : logs){
            String temp = log.split(" ", 2)[1];
            if(temp.charAt(0) - 'a' >= 0)
                letters.add(log);
            else
                digits.add(log);
        }
        
        List<String> result = new ArrayList();
        
        while(!letters.isEmpty())
            result.add(letters.poll());
        
        result.addAll(digits);
        
        return result.toArray(new String[logs.length]);
    }
}