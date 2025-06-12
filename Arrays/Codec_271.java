import java.util.*;

class Codec {
    /**
     * Encodes a list of strings to a single string.
     * 
     * @param strs The list of strings to encode.
     * @return The encoded string.
     */
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for (String str : strs) {
            // Encode the length of the string followed by the string itself
            encodedString.append(str.length()).append("#").append(str);
        }

        return encodedString.toString();
    }

    /**
     * Decodes a single string to a list of strings.
     * 
     * @param s The encoded string to decode.
     * @return The list of decoded strings.
     */
    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            // Find the position of the next delimiter '#'
            int j = s.indexOf("#", i);
            // Extract the length of the string
            int length = Integer.parseInt(s.substring(i, j));
            // Extract the actual string based on the length
            decodedStrings.add(s.substring(j + 1, j + 1 + length));
            // Move to the next position after the current string
            i = j + 1 + length;
        }

        return decodedStrings;
    }
}

// Test the Codec class
public class Codec_271 {
    public static void main(String[] args) {
        Codec codec = new Codec();

        // Test the encode and decode methods
        List<String> strs = Arrays.asList("hello", "world", "this", "is", "Leetcode");
        String encoded = codec.encode(strs);
        System.out.println("Encoded String: " + encoded);

        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded List: " + decoded);
    }
}
