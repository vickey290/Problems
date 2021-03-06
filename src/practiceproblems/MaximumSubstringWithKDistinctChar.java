package practiceproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * <p>
 * https://www.lintcode.com/problem/longest-substring-with-at-most-two-distinct-characters/description
 */
public class MaximumSubstringWithKDistinctChar {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("aaaaaaaa", 2));
        System.out.println("");
       // System.out.println(lengthOfLongestSubstringKDistinct("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 2));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int counter = 0;
        int length = 0;
        int startIndex=0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                counter++;//new char
            }
            end++;
            while (counter > k) {
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if (map.get(cTemp) == 0) {
                    counter--;
                }
                start++;
            }
            if(end - start>length){
                startIndex=start;
                length= end-start;
            }

        }

        System.out.println(s.substring(startIndex,startIndex+length));
        return length;
    }

    // improvised solution
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        int start = 0;
        int maxCount = 0;
        int[] arr = new int[26];
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {

            if (arr[s.charAt(i) - 'a'] == 0) {
                k--;
            }

            arr[s.charAt(i) - 'a']++;
            while (k == -1) {

                arr[s.charAt(start) - 'a']--;
                if (arr[s.charAt(start) - 'a'] == 0) {
                    k++;
                }
                start++;
            }
            maxCount = Math.max(maxCount, i - start);
        }
        return maxCount + 1;
    }


}
