package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_355 {
    static class Twitter {
        Map<Integer, HashSet<Integer>> follow;

        Map<Integer, List<Post>> userPosts;

        private int log = 0;

        public Twitter() {
            follow = new HashMap<>();
            userPosts = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (userPosts.containsKey(userId)) {
                List<Post> dates = userPosts.get(userId);
                dates.add(new Post(log, tweetId));
            } else {
                List<Post> list = new ArrayList<>();
                list.add(new Post(log, tweetId));
                userPosts.put(userId, list);
            }
            log++;
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Post> list = new ArrayList<>();
            HashSet<Integer> hashSet = follow.get(userId);
            if (hashSet != null)
                list = hashSet.stream()
                        .filter(integer -> userPosts.containsKey(integer))
                        .map(integer -> userPosts.get(integer))
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
            if (userPosts.containsKey(userId)) {
                List<Post> dates = userPosts.get(userId);
                list.addAll(dates);
            }

            list.sort((o1, o2) -> o2.sort > o1.sort ? 1 : -1);
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < 10; i++)
                if (i < list.size()) res.add(list.get(i).tweetId);
                else break;

            return res;

        }

        public void follow(int followerId, int followeeId) {
            if (follow.containsKey(followerId)) {
                HashSet<Integer> hashSet = follow.get(followerId);
                hashSet.add(followeeId);
            } else {
                HashSet<Integer> hashSet = new HashSet<>();
                hashSet.add(followeeId);
                follow.put(followerId, hashSet);
            }
        }

        public void unfollow(int followerId, int followeeId) {
            if (follow.containsKey(followerId)) {
                HashSet<Integer> hashSet = follow.get(followerId);
                hashSet.remove(followeeId);
            }
        }
    }


    static class Post {
        public int sort;
        public int tweetId;

        public Post(int sort, int tweetId) {
            this.sort = sort;
            this.tweetId = tweetId;
        }

        public Post() {
        }
    }
}
