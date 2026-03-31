class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            int diff = target - sum;
            if (diff > 0) {
                l++;
            } else if (diff == 0) {
                return new int[]{l + 1, r + 1};
            } else {
                r--;
            }
        }

        return new int[]{-1, -1};
    }
}