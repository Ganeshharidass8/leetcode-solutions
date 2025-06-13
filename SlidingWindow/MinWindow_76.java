class MinWindow_76 {

    /**
     * 
     * Given two strings s and t of lengths m and n respectively, return the minimum
     * window substring of s such that every character in t (including duplicates)
     * is included in the window. If there is no such substring, return the empty
     * string "".
     * 
     * The testcases will be generated such that the answer is unique.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
     * from string t.
     * Example 2:
     * 
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     * 
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     * 
     * 
     * Constraints:
     * 
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s and t consist of uppercase and lowercase English letters.
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        int[] freq = new int[128]; // For ASCII characters

        // Build frequency map for characters in t
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int requiredChars = t.length();

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            // If this char is needed, decrement the required count
            if (freq[rightChar] > 0) {
                requiredChars--;
            }

            freq[rightChar]--; // Always decrement (may go negative)
            right++;

            // When all required characters are matched
            while (requiredChars == 0) {
                // Update the minimum window
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;

                // If removing this char breaks the requirement
                if (freq[leftChar] > 0) {
                    requiredChars++;
                }

                left++; // Shrink the window from the left
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
