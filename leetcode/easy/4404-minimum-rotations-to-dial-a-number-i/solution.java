class Solution {
    public int minRotations(String s) {
        int current=0;
        int rotations=0;
        int len=s.length();
        for(int i=0;i<len;i++){
            int next=s.charAt(i)-'0';
            int diff=Math.abs(current-next);
            rotations+=Math.min(diff,10-diff);
            current=next;
        }
      return rotations;
    }
}