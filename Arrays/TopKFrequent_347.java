import java.util.*;

class TopKFrequent_347 {
    /**
     * This method returns the top k frequent elements from the given array.
     * 
     * @param nums The input array of integers.
     * @param k    The number of top frequent elements to return.
     * @return An array containing the k most frequent elements.
     * 
     *         Explanation:
     * 
     *         Frequency Map: We first count the occurrences of each number in the
     *         array using a hash map. The getOrDefault method is used to update the
     *         frequency of each element.
     * 
     *         Min-Heap: A min-heap is created using a PriorityQueue. The heap
     *         stores the Map.Entry objects, and we define the comparator to order
     *         the entries by their values (frequencies). We maintain the size of
     *         the heap to k by removing the element with the smallest frequency
     *         whenever the heap exceeds size k.
     * 
     *         Result Extraction: After filling the heap with the top k frequent
     *         elements, we extract the elements from the heap into the result
     *         array. The poll() method retrieves the root of the heap, which is the
     *         element with the smallest frequency among the top k elements.
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number in the array
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a min-heap (priority queue) to keep the top k frequent
        // elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Step 3: Add elements from the frequency map into the min-heap
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);

            // If the heap exceeds size k, remove the element with the lowest frequency
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Extract the elements from the heap into the result array
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }

        return result;
    }
}
