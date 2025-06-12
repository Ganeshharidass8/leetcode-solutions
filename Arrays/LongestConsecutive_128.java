import java.util.*;

class LongestConsecutive_128 {
    /**
     * This method finds the length of the longest consecutive sequence in an
     * unsorted array.
     * 
     * @param nums The input array of integers.
     * @return The length of the longest consecutive elements sequence.
     */
    public int longestConsecutive(int[] nums) {
        // Edge case: if the array is empty, return 0
        if (nums.length == 0)
            return 0;

        // Initialize a set to store unique elements
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Variable to store the length of the longest consecutive sequence
        int maxLength = 1;

        // Iterate through the set of numbers
        for (int num : set) {
            // If num-1 is not in the set, it means this number is the start of a sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                // Count consecutive numbers starting from 'current'
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                // Update the maximum length if we found a longer sequence
                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }
}
