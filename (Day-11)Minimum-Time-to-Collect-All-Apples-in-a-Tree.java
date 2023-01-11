class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            
            
        }
        return dfs(graph,hasApple,0,-1);
    }
    public int dfs(List<List<Integer>> graph,List<Boolean>hasApple,int index,int parent){
        int minTime =0;
        for(int child:graph.get(index)){
            if(child==parent)continue;
            
            int timeFromChild = dfs(graph,hasApple,child,index);
            if(hasApple.get(child) || timeFromChild>0){
                minTime = minTime+ timeFromChild+2;
            }
        }
        return minTime;
    }
}
