// https://www.geeksforgeeks.org/problems/topological-sort/1
class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] indegree = new int[n];
        
        for(int i = 0; i<n; i++){
            for(int neigh: adj.get(i)){
                indegree[neigh] +=1;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int ele = queue.poll();
            ans.add(ele);
            for(int neigh: adj.get(ele)){
                indegree[neigh] -=1;
                if(indegree[neigh] == 0)
                    queue.offer(neigh);
            }
        }
        return ans;
    }
}
