//https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    Node(){}

}
class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        char ch;
        for(int i=0; i< word.length(); i++){
            ch = word.charAt(i);
            if(cur.links[ch-'a'] == null){
                cur.links[ch-'a'] = new Node();
            }
            cur = cur.links[ch-'a'];
        }
        cur.flag = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        char ch;
        for(int i = 0; i< word.length(); i++){
            ch = word.charAt(i);
            if(cur.links[ch-'a'] == null)
                return false;
            cur = cur.links[ch - 'a'];
        }
        return cur.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        char ch;
        for(int i = 0; i< prefix.length(); i++){
            ch = prefix.charAt(i);
            if(cur.links[ch-'a'] == null)
                return false;
            cur = cur.links[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
