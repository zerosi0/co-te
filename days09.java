/*
※ 문제 설명 ※
You are given an integer array score of size n, 
where score[i] is the score of the ith athlete in a competition. 
All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, 
the 2nd place athlete has the 2nd highest score, and so on. 
The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number 
(i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] sortedScores = new Integer[n];
        
        // Copy scores into a sortable array
        for (int i = 0; i < n; i++) {
            sortedScores[i] = score[i];
        }
        
        // Sort the scores in descending order
        Arrays.sort(sortedScores, (a, b) -> b - a);
        
        // Map score to its rank
        Map<Integer, String> scoreToRank = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int scoreValue = sortedScores[i];
            if (i == 0) {
                scoreToRank.put(scoreValue, "Gold Medal");
            } else if (i == 1) {
                scoreToRank.put(scoreValue, "Silver Medal");
            } else if (i == 2) {
                scoreToRank.put(scoreValue, "Bronze Medal");
            } else {
                scoreToRank.put(scoreValue, String.valueOf(i + 1));
            }
        }
        
        // Create the result array with ranks
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int scoreValue = score[i];
            answer[i] = scoreToRank.get(scoreValue);
        }
        
        return answer;
    }
}