class Solution {
    private void helper(int[] nums, int start,
                        List<Integer> curr,
                        List<List<Integer>> ans) {

        ans.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;

            curr.add(nums[i]);
            helper(nums, i + 1, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);

        return ans;
    }
}