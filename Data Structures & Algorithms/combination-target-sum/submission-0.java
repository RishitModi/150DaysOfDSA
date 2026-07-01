class Solution {
    private void helper(List<List<Integer>> ans , List<Integer> arr ,int[] nums, int remain,int idx){
        if(remain == 0){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(idx >= nums.length || remain < 0) return;

        for(int i = idx ; i < nums.length ; i++){
            arr.add(nums[i]);
            helper(ans, arr,nums,remain-nums[i] , i);
            arr.remove(arr.size() - 1);
        } 
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(ans,arr,nums,target,0);
        return ans;
    }
}
