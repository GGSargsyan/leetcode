//Solution #1
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) 
            return -1;
        
        int left = 0;
        int right = nums.length-1;
        
        while(left < right) {
            int mid = left + ((right -left) / 2);
            if(nums[mid] == target) return mid;
            
            if(nums[mid] > nums[right] && nums[mid] > nums[left]) left = mid;
            else if(nums[mid] < nums[left] && nums[mid] < nums[right]) right = mid;
            else left = mid+1;
        }
        int imax = left;
        if(target < nums[0]) {
            left = imax;
            right = nums.length-1;
        } else {
            left = 0;
            right = imax;
        }
        while(left <= right) {
            int mid = left + ((right -left) / 2);
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid-1;
        }
        return -1;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int start = 0; 
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if(nums[mid] == target) {
                return mid;
            } else if (nums[start] <= target && nums[mid] > target) {
                end = mid - 1;
            } else if (nums[start] > nums[mid] && 
                       (nums[start] <= target || nums[mid] > target)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
}