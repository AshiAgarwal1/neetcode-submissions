class Solution {
    private boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[node]=true;
        for(int neighbour:adj.get(node)){
            //if parent ignore
            if(neighbour==parent)continue;
            if(vis[neighbour]==true) return false;
            //explore unvisited neighbour
            if(!dfs(neighbour,node,adj,vis)) return false;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
    if(edges.length!=n-1) return false;
    boolean[] vis = new boolean[n];
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0;i<n;i++){adj.add(new ArrayList<>());}
    for(int[] edge:edges){
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }
    // tree should not have a cycle
    if(!dfs(0,-1,adj,vis)) return false;
    //all nodes should be connected
    for(boolean node:vis){
        if(!node) return false;
    }
    return true;

    }
}
