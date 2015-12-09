public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> dict = new HashMap<Character, Character>();
        dict.put('(', ')');
        dict.put('{', '}');
        dict.put('[', ']');

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (dict.keySet().contains(curr)) {
                stack.push(curr);
            } else if (dict.values().contains(curr)) {
                if (!stack.isEmpty() && dict.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        return stack.empty();
    }
}
