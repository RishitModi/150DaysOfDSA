class Solution {
    private void helper(List<List<Integer>> ans , List<Integer> arr ,int[] nums, int remain,int start){
        if(remain == 0){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(start >= nums.length || remain < 0) return;

        for(int i = start ; i < nums.length ; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            arr.add(nums[i]);
            helper(ans, arr,nums,remain-nums[i] , i+1);
            arr.remove(arr.size() - 1);
        } 
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(ans,arr,nums,target,0);
        return ans;
    }
}
