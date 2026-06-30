class Solution {
    private void helper(int[] nums , List<List<Integer>> ans,int idx , List<Integer> arr){
        if(idx == nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[idx]);
        helper(nums,ans,idx+1,arr);
        arr.remove(arr.size() - 1);

        helper(nums,ans,idx+1,arr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(nums,ans,0,arr);

        return ans;
    }
}