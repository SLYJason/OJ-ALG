package LeetCode.LC_201_400.LC355;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    class Twitter {
        int time;
        Map<Integer, Set<Integer>> userFollowers;
        Map<Integer, List<Tweet>> userTweets;
        /** Initialize your data structure here. */
        public Twitter() {
            time = 0;
            userFollowers = new HashMap<>();
            userTweets = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if(!userTweets.containsKey(userId)) userTweets.put(userId, new ArrayList<>());
            userTweets.get(userId).add(0, new Tweet(time++, tweetId)); // recent tweet always added to the front of the list.
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> followers = userFollowers.get(userId);
            PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t1.time - t2.time); // min-heap.
            // push userId's tweets.
            mergeTweets(userId, pq);
            // push userId's followers tweets.
            if(followers != null) {
                for(int follower : followers) {
                    mergeTweets(follower, pq);
                }
            }
            // build the news feed.
            List<Integer> tweets = new ArrayList<>();
            while(!pq.isEmpty()) {
                tweets.add(0, pq.poll().tweetId);
            }
            return tweets;
        }

        // a helper function.
        private void mergeTweets(int userId, PriorityQueue<Tweet> pq) {
            if(!userTweets.containsKey(userId)) return;
            for(int i=0; i<10 && i<userTweets.get(userId).size(); i++) {
                pq.offer(userTweets.get(userId).get(i));
                if(pq.size() > 10) pq.poll();
            }
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(followerId == followeeId) return; // can not follow self.
            if(!userFollowers.containsKey(followerId)) userFollowers.put(followerId, new HashSet<>());
            userFollowers.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followerId == followeeId) return; // can not unfollow self.
            if(!userFollowers.containsKey(followerId)) return; // does not have any followers.
            userFollowers.get(followerId).remove(followeeId);
        }

        class Tweet{
            public int time;
            public int tweetId;
            public Tweet(int time, int tweetId) {
                this.time = time;
                this.tweetId = tweetId;
            }
        }
    }
}
