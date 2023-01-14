class Solution {
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int m = s1.length();
        int n = baseStr.length();
        
        ArrayList<Character>[] graph = new ArrayList[26];
        
        for (int i = 0 ; i < 26 ; i++) {
            graph[i] = new ArrayList<Character>();
        }
        
        for (int i = 0 ; i < m ; i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);
            
            graph[u - 'a'].add(v);
            graph[v - 'a'].add(u);
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0 ; i < n ; i++) {
            char currentBaseStrCharacter = baseStr.charAt(i);
            
            boolean[] visited = new boolean[26];
            
            char ch = DFS(graph, visited, currentBaseStrCharacter);
           
            result.append(ch);
        }
        
        return result.toString();
    }
    
    public char DFS(ArrayList<Character>[] graph, boolean[] visited, char currentCharacter) {
        visited[currentCharacter - 'a'] = true;
        
        char curr_ch = currentCharacter;
        
        for (char v : graph[currentCharacter - 'a']) {
            if (!visited[v - 'a']) {
                char min = DFS(graph, visited, v);
                
                if (min < curr_ch) {
                    curr_ch = min;
                }
                
            }    
        }
        
        return curr_ch;
    }
    
}
