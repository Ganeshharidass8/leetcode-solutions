import java.util.HashSet;

class ContainsDuplicate_217 {
    /**
     * This method checks if the input array contains any duplicates.
     * 
     * @param nums The input array of integers.
     * @return true if any element appears at least twice, false if every element is
     *         distinct.
     */
    public boolean containsDuplicate(int[] nums) {
        // Initialize a HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();

        // Iterate through the array
        for (int num : nums) {
            // If the element is already in the set, return true (duplicate found)
            if (!set.add(num)) {
                return true; // Duplicate found
            }
        }

        // If no duplicates were found, return false
        return false;
    }
}
