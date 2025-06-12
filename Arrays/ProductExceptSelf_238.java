class ProductExceptSelf_238 {
    /**
     * This method returns an array where each element at index i is the product
     * of all elements in the input array except the element at index i.
     * 
     * @param nums The input array of integers.
     * @return The array where each element is the product of all elements except
     *         itself.
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // The result array to store the product of all elements except self
        int[] ans = new int[n];

        // Initialize the first element of the result array
        ans[0] = 1;

        // Left to right pass: accumulate the product of all elements to the left of
        // each element
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Right to left pass: multiply the product of elements to the right of each
        // element
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return ans;
    }
}
