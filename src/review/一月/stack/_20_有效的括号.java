package review.一月.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20_有效的括号 {


    // 用栈来做就行了
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        Map<Character, Character> supMap = initSupCharacterMap();
        Stack<Character> supStack = new Stack<>();
        for ( int i = 0; i < s.length(); i++ ){
            char currChar = s.charAt(i);
            if ( currChar == '(' || currChar == '{' || currChar == '[') {
                supStack.push(currChar);
            }else {
                if (supStack.isEmpty()) return false;
                if ( supMap.get(supStack.pop())  !=  currChar) {
                    return false;
                }
            }
        }
        return supStack.isEmpty();
    }



    private Map<Character, Character> initSupCharacterMap(){
        Map<Character, Character> characterMap = new HashMap<>(4);
        characterMap.put('(',')') ;
        characterMap.put('[',']') ;
        characterMap.put('{','}') ;

        return characterMap;
    }
}
