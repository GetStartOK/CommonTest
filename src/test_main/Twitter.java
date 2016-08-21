package test_main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter {
	
	private Map<Integer, List<Integer>> follows = null;
	private Map<Integer, List<Integer>> ownTweets = null;
	private Map<Integer, Integer> location = null;
	private int index = 0;
	
	/** Initialize your data structure here. */
    public Twitter() {
    	follows = new HashMap<Integer, List<Integer>>();
    	ownTweets = new HashMap<Integer, List<Integer>>();
    	location = new HashMap<Integer, Integer>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(ownTweets.containsKey(userId)){
        	ownTweets.get(userId).add(tweetId);
        }else{
        	List<Integer> list = new ArrayList<Integer>();
        	list.add(tweetId);
        	ownTweets.put(userId, list);
        }
        location.put(tweetId, index);
        index ++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<Integer>();
        if(ownTweets.get(userId)!= null)
        	news.addAll(ownTweets.get(userId));
        List<Integer> follows = this.follows.get(userId);
        if(follows != null){
    	  for(Integer i : follows){
    		  if(ownTweets.get(i) != null)
    			  news.addAll(ownTweets.get(i));
          }
        }
        news.sort(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return location.get(o2) - location.get(o1);
			}});
        if(news.size() > 10){
        	 List<Integer> res = new ArrayList<Integer>(10);
        	 for(int i = 0; i < 10; i++){
        		 res.add(news.get(i));
        	 }
        	 return res;
        }
        return news;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if(followerId == followeeId)
    		return;
    	if(follows.containsKey(followerId)){
    		List<Integer> f = follows.get(followerId);
    		if(!f.contains(followeeId))
    			f.add(followeeId);
        }else{
        	List<Integer> list = new ArrayList<Integer>();
        	list.add(followeeId);
        	follows.put(followerId, list);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if(follows.containsKey(followerId)){
    		follows.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
    public static void main(String[] args) {
    	Twitter obj = new Twitter();
    	obj.postTweet(1,5);
    	obj.postTweet(1,3);
    	obj.postTweet(1,101);
    	obj.postTweet(1,13);
    	obj.postTweet(1,10);
    	obj.postTweet(1,2);
    	obj.postTweet(1,94);
    	obj.postTweet(1,505);
    	obj.postTweet(1,333);
    	obj.postTweet(1,22);
    	obj.postTweet(1,11);
    	
//    	obj.follow(2,1);
//    	List<Integer> l1 = obj.getNewsFeed(1);
//    	obj.follow(2,1);
//    	List<Integer> l2 = obj.getNewsFeed(2);
//    	obj.postTweet(2,6);
//    	obj.unfollow(1,2);
    	List<Integer> l3 = obj.getNewsFeed(1);
 //   	System.out.println(l1);
 //   	System.out.println(l2);
    	System.out.println(l3);
    	Map<String, String> map = new HashMap<String, String>();
    	map.putAll(null);
	}
}
