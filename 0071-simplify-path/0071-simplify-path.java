class Solution {
    public String simplifyPath(String path) {
     String[] tokens = path.split("/");
        Deque<String> stack = new LinkedList<>();
        
        for (String token : tokens) {
            if (token.equals("") || token.equals(".")) {
                continue;
            }
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String token : stack) {
            result.insert(0, "/" + token);
        }
        
        return result.length() == 0 ? "/" : result.toString();   
    }
}