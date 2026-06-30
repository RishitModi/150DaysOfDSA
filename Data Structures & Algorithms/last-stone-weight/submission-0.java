class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones){
            pq.offer(s);
        }

        while(pq.size() > 1){
            int s1 = pq.poll();
            int s2 = pq.poll();

            if(s1 == s2) continue;
            if(s1 < s2){
                pq.offer(s2 - s1);
            }else{
                pq.offer(s1-s2);
            }
        }
        if(!pq.isEmpty()) return pq.poll();
        else return 0;
    }
}
