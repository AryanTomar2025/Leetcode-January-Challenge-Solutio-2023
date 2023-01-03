class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] words = s.split(" ");
        
        if (words.length != pattern.length()) {
  			return false;
        }
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Boolean> usedKey = new HashMap<>();
        
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)==false){
                if(usedKey.containsKey(words[i]) == true){
                    return false;
                }else{
                    usedKey.put(words[i],true);
                    map.put(ch,words[i]);
                }
            }else{
                String mappedWith = map.get(ch);
                if(mappedWith.equals(words[i])== false){
                    return false;
                }
            }
        }
        return true;
    }
}
