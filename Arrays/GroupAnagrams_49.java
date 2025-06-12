import java.util.*;

class GroupAnagrams_49 {
    /**
     * This method groups anagrams together from the given array of strings.
     * 
     * @param strs The input array of strings.
     * @return A list of lists of anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store the grouped anagrams with a key being the character frequency
        // string
        Map<String, List<String>> map = new HashMap<>();

        // Iterate over each string in the input array
        for (String str : strs) {
            // Array to store the frequency of each character ('a' to 'z')
            char[] ch = new char[26]; // Since we assume lowercase English letters only

            // Calculate frequency of each character in the current string
            for (char c : str.toCharArray()) {
                ch[c - 'a']++;
            }

            // Convert the frequency array into a string that serves as a unique key for
            // anagrams
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(ch[i]);
            }

            // Use the string as the key and group anagrams under that key
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }
}
