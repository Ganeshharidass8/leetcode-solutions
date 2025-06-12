import java.util.HashMap;
import java.util.Map;

class IsAnagram_242 {
    /**
     * This method checks if two strings are anagrams.
     * 
     * @param s The first string.
     * @param t The second string.
     * @return true if both strings are anagrams, false otherwise.
     */
    public boolean isAnagram(String s, String t) {
        // If the lengths are different, the strings can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Create a map to store the frequency of each character in string 's'
        Map<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character in string 's'
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // For each character in string 't', check if it exists in the map and has the
        // same frequency
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // If the character doesn't exist in the map or its frequency is 0, return false
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            } else {
                // Decrement the frequency of the character in the map
                map.put(ch, map.get(ch) - 1);
            }
        }

        // If all characters matched, return true
        return true;
    }
}
