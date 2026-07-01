class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count frequency of each task
        int[] freq = new int[26];
        int maxFreq = 0;

        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }

        // Count how many tasks have the maximum frequency
        int countMax = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                countMax++;
            }
        }

        // Length of the framework formed by the most frequent tasks
        int framework = (maxFreq - 1) * (n + 1) + countMax;

        // If there are enough tasks to fill all idle slots,
        // answer is simply the total number of tasks.
        return Math.max(tasks.length, framework);
    }
}