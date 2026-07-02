class Solution {
    private void helper(List<List<Integer>> ans,List<Integer> arr,int[] nums,boolean[] used){
        if(arr.size() == nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }

        
        for(int i = 0 ; i < nums.length ; i++){
            if(used[i]) continue;
            
            arr.add(nums[i]);
            used[i] = true;

            helper(ans , arr ,nums,used);
            arr.remove(arr.size() - 1);
            used[i] = false;
        }


    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        Arrays.fill(used , false);
        helper(ans, arr, nums, used);
return ans;
    }
}
