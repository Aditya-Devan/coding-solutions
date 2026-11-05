class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                
                // Multiply digits and add to existing value at the correct position
                int sum = n1 * n2 + arr[i + j + 1];
                
                // Store the single digit remainder
                arr[i + j + 1] = sum % 10;
                
                // Add the carry to the next higher position
                arr[i + j] += sum / 10;
            }
        }

        // Build the result string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            // Skip leading zeros unless the array is all zeros
            if (!(sb.length() == 0 && val == 0)) {
                sb.append(val);
            }
        }

        // If the result string is empty, it means the product is 0
        return sb.length() == 0 ? "0" : sb.toString();
    }
}