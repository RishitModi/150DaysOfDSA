class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0 , h = n-1;

        if(nums[l] < nums[h]) return nums[l];

        while(l < h){
            int mid = l + ((h-l) / 2);
            if(nums[h] < nums[mid]){
                l = mid+1;
            }else{ 
                h = mid;
            }
        }

        return nums[l];
    }
}
