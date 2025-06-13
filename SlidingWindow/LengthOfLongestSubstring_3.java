class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int left = 0, maxLength = 0;
        int[] lastSeenIndex = new int[128]; // ASCII range
        Arrays.fill(lastSeenIndex, -1); // -1 means character hasn't appeared yet

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character was seen after the start of the current window
            if (lastSeenIndex[currentChar] >= left) {
                left = lastSeenIndex[currentChar] + 1; // Move left pointer
            }

            lastSeenIndex[currentChar] = right; // Update last seen index of currentChar

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
