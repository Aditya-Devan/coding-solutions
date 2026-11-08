class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int totChars = 0;

        for (int i = 0; i < words.length; i++) {

      
            if (totChars + temp.size() + words[i].length() <= maxWidth) {
                temp.add(words[i]);
                totChars += words[i].length();
            } else {
              
                ans.add(justified(totChars, maxWidth, temp));
                temp = new ArrayList<>();
                totChars = 0;
                i--; 
            }
        }

     
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.size(); i++) {
            sb.append(temp.get(i));
            if (i != temp.size() - 1) sb.append(" ");
        }

        while (sb.length() < maxWidth) sb.append(" ");
        ans.add(sb.toString());

        return ans;
    }

    public String justified(int charLen, int maxW, List<String> temp) {
        int wordCount = temp.size() - 1;

        if (wordCount == 0) {
            StringBuilder sb = new StringBuilder(temp.get(0));
            while (sb.length() < maxW) sb.append(" ");
            return sb.toString();
        }

        int reqSpaces = maxW - charLen;
        int totSpace = reqSpaces / wordCount;
        int extra = reqSpaces % wordCount;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < temp.size(); i++) {
            sb.append(temp.get(i));

            if (i < wordCount) {
                int spaces = totSpace + (i < extra ? 1 : 0);
                sb.append(" ".repeat(spaces));
            }
        }

        return sb.toString();
    }
}