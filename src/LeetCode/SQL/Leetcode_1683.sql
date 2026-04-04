-- LeetCode 1683: Invalid Tweets
-- Problem: Find tweet IDs where tweet content is longer than 15 characters
-- Difficulty: Easy
--
-- Solution Approach:
-- - Use LENGTH() function to calculate character count of tweet content
-- - Filter tweets where length > 15 (invalid tweets)
-- - Return the tweet_id

Create table If Not Exists Tweets(tweet_id int, content varchar(50));
Truncate table Tweets;
insert into Tweets (tweet_id, content) values ('1', 'Let us Code');
insert into Tweets (tweet_id, content) values ('2', 'More than fifteen chars are here!');

-- Solution: Filter tweets with content longer than 15 characters
select tweet_id from Tweets where length(content)>15;