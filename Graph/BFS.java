// https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        
        queue.offer(0);
        visit.add(0);
        while(!queue.isEmpty()){
            int ele = queue.poll();
            ans.add(ele);
            for(int neigh: adj.get(ele)){
                if(!visit.contains(neigh))
                    queue.offer(neigh);
                    visit.add(neigh);
            }
        }
        
        return ans;
    }
}
