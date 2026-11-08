class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len=strs.length;

        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<len;i++){
           String word=strs[i];
           int[] arr=new int[26];
             int wordLen=word.length();
             for(int j=0;j<wordLen;j++){
                char ch=word.charAt(j);
                arr[ch-'a']++;
             }
          String array = Arrays.toString(arr);
          if(!map.containsKey(array)){
            List<String> anagrams=new ArrayList<>();
            anagrams.add(word);
            map.put(array,anagrams);
          }
          else{
            map.get(array).add(word);
          }

        }

       return new ArrayList<>(map.values());

    }
}


/*class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String>> mp=new HashMap<>();
        for(String s:strs){
            int[] count=new int[26];
            for(char ch:s.toCharArray()){
               count[ch-'a']++; 
            }
            String key=Arrays.toString(count);
              if(!mp.containsKey(key)){
                mp.put(key,new ArrayList<>());
              }
              mp.get(key).add(s);
        }
         return new ArrayList<>(mp.values());
    }
}*/