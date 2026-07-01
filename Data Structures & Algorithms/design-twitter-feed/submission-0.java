class Twitter {

    private static int time = 0;
    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Tweet>> tweets;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    class Node {
        int userId;
        int index; 
        Tweet tweet;

        Node(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> b.tweet.time - a.tweet.time);

        follow(userId, userId);
        for (int followee : following.get(userId)) {
            List<Tweet> list = tweets.get(followee);
            if (list == null || list.isEmpty())
                continue;
            int last = list.size() - 1;
            pq.offer(new Node(followee, last, list.get(last)));
        }

        while (!pq.isEmpty() && ans.size() < 10) {
            Node curr = pq.poll();
            ans.add(curr.tweet.tweetId);
           if (curr.index > 0) {
                int prev = curr.index - 1;
                List<Tweet> list = tweets.get(curr.userId);
                pq.offer(new Node(curr.userId, prev, list.get(prev)));
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;

        if (following.containsKey(followerId))
            following.get(followerId).remove(followeeId);
    }
}