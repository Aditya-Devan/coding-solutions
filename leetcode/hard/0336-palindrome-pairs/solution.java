class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length < 2) {
            return ans;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        if (map.containsKey("")) {
            int blankIdx = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (i == blankIdx) continue;
                if (isPalindrome(words[i])) {
                    ans.add(Arrays.asList(blankIdx, i));
                    ans.add(Arrays.asList(i, blankIdx));
                }
            }
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int n = word.length();
            
            for (int j = 0; j < n; j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                
                // If left part is a palindrome, check if reverse of right part exists in map
                if (isPalindrome(left)) {
                    String reversedRight = reverse(right);
                    if (map.containsKey(reversedRight)) {
                        int jIdx = map.get(reversedRight);
                        if (jIdx != i) {
                            ans.add(Arrays.asList(jIdx, i));
                        }
                    }
                }
                
                // If right part is a palindrome, check if reverse of left part exists in map
                // (j > 0 ensures we don't duplicate checks when j == 0)
                if (j > 0 && isPalindrome(right)) {
                    String reversedLeft = reverse(left);
                    if (map.containsKey(reversedLeft)) {
                        int jIdx = map.get(reversedLeft);
                        if (jIdx != i) {
                            ans.add(Arrays.asList(i, jIdx));
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    
  
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}