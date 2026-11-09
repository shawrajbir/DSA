import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        // If the number of characters and words don't match, they can't follow the pattern
        if (pattern.length() != words.length) {
            return false;
        }
        
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            
            // Check if character is already mapped to a different word
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(w)) {
                    return false;
                }
            } else {
                charToWord.put(c, w);
            }
            
            // Check if word is already mapped to a different character
            if (wordToChar.containsKey(w)) {
                if (wordToChar.get(w) != c) {
                    return false;
                }
            } else {
                wordToChar.put(w, c);
            }
        }
        
        return true;
    }
}