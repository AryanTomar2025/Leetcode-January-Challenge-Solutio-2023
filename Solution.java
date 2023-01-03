

class Solution {
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        int capitalLetter =0;
        boolean firstletter = false;
        
        
        if(word.charAt(0)>='A' && word.charAt(0)<='Z')firstletter = true;
        
        
        for(int i=0;i<length;i++){
            char ch = word.charAt(i);
            if(ch>='A' && ch<='Z'){
                capitalLetter++;
            }
        }
        
        if(firstletter && capitalLetter == length || firstletter && capitalLetter==1 || capitalLetter==0){
            return true;
        }
        return false;
    }
}