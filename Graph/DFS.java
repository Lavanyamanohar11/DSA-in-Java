// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class Solution {   
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, Set<Integer> visit, ArrayList<Integer> ans){
        ans.add(node);
        for(int neigh: adj.get(node)){
            if(!visit.contains(neigh)){
                visit.add(neigh);
                dfs(neigh, adj, visit, ans);        
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        visit.add(0);
        dfs(0, adj, visit, ans);
        return ans;
    }
}
