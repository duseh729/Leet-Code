import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char bracket = s.charAt(i);
            if(bracketStack.isEmpty()){
                switch(bracket){
                    case ')':
                        return false;
                    case ']':
                        return false;
                    case '}':
                        return false;
                }
                bracketStack.push(bracket);
            }else if(bracket=='['|bracket=='{'|bracket=='('){
                bracketStack.push(bracket);}
            else{
                char currentBracket = bracketStack.peek();
                switch(currentBracket){
                    case '(':
                        if(bracket==')'){
                            bracketStack.pop();
                            break;
                        }else{
                            return false;
                        }
                    case '[':
                        if(bracket==']'){
                            bracketStack.pop();
                            break;
                        }else{
                            return false;
                        }
                    case '{':
                        if(bracket=='}'){
                            bracketStack.pop();
                            break;
                        }else{
                            return false;
                        }
                }
            }
        }
        if(bracketStack.isEmpty()){
           return true;
        }else{
            return false;
        }
    }
}