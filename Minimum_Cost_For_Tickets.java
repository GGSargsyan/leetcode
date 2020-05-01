class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int lastDay = days[days.length - 1];
        int total[] = new int[lastDay + 1];
        boolean isTravelDays[] = new boolean[lastDay + 1];
        
        for(int day : days) 
            isTravelDays[day] = true;
        
        for(int i = 1; i <= lastDay; i++){
            if(!isTravelDays[i]){
                total[i] = total[i - 1];
                //Same price as yesterday
                continue;
            }
            
            total[i] = costs[0] + total[i - 1];
            total[i] = Math.min(costs[1] + total[Math.max(i - 7, 0)], total[i]);
            total[i] = Math.min(costs[2] + total[Math.max(i - 30, 0)], total[i]);
        }
        
        return total[lastDay];
    }
}