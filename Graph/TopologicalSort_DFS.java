// https://www.geeksforgeeks.org/problems/topological-sort/1

class Solution {
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> stack){
        for(int neigh: adj.get(node)){
            if(vis[neigh] == 0){
                vis[neigh] = 1;
                dfs(neigh, adj, vis, stack);
            }
            
        }
        stack.push(node);
    }
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        int n = adj.size();
        int[] vis = new int[n];
        
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                vis[i] = 1;
                dfs(i, adj, vis, stack);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!stack.isEmpty()){
            int ele = stack.pop();
            topo.add(ele);
        }
        // System.out.println(topo);
        return topo;
    }
}
