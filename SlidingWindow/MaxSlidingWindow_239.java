class MaxSlidingWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int windowSize) {
        if (nums == null || windowSize <= 0)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - windowSize + 1];
        Deque<Integer> windowIndices = new ArrayDeque<>();

        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            // Remove indices that are outside the current window
            if (!windowIndices.isEmpty() && windowIndices.peekFirst() < currentIndex - windowSize + 1) {
                windowIndices.pollFirst();
            }

            // Remove smaller elements from the back of the deque
            while (!windowIndices.isEmpty() && nums[windowIndices.peekLast()] < nums[currentIndex]) {
                windowIndices.pollLast();
            }

            // Add current index to the deque
            windowIndices.offerLast(currentIndex);

            // If we have processed at least 'windowSize' elements
            if (currentIndex >= windowSize - 1) {
                result[currentIndex - windowSize + 1] = nums[windowIndices.peekFirst()];
            }
        }

        return result;
    }
}
