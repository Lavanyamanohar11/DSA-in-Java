import java.util.*;

public class Main
{
    public static void printSubseq(int ind , ArrayList<Integer> ip, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds){
        if(ind == ip.size()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(ip.get(ind));
        printSubseq(ind+1, ip, ans, ds);
        ds.remove(ds.size()-1);
        printSubseq(ind+1, ip, ans, ds);
        
        
    }
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> ip = new ArrayList<>(Arrays.asList(1, 2, 3));
		printSubseq(0,ip,ans,new ArrayList<>());
		System.out.println(ans.toString());
	}
}
