class Solution {
    public int search(int[] nums, int target) {
        //is valid
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        //find pivot
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + ((right - left) / 2);
            if(nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        //which side is target
        int start = left;
        left = 0;
        right = nums.length - 1;
        if(target >= nums[start] && target <= nums[right])
            left = start;
        else
            right = start;
        //normal binary search
        while(left <= right){
            int mid = left + ((right - left) / 2);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}