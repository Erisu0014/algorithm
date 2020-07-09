import java.util.Map;
import java.util.TreeMap;

/**
 * @Description Trie树
 * @Author alice
 * @Date 2020/7/9 15:53
 **/
public class Trie {
    private Node node;
    private int size;

    public Trie() {
        this.node = new Node();
        this.size = 0;
    }

    /**
     * 返回tries节点树
     *
     * @return
     */
    public Node getNode() {
        return this.node;
    }

    public void add(String words) {
        Node curr = node;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (!curr.next.containsKey(c)) {
                curr.next.put(c, new Node());
            }
            curr = node.next.get(c);
        }
        if (!curr.isWord) {
            curr.isWord = true;
            size++;
        }

    }

    public boolean contains(String word) {
        Node curr = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.next.containsKey(c)) {
                return false;
            }
            curr = curr.next.get(c);
        }
        return curr.isWord;
    }
    public void delete(String word){

    }

    private class Node {
        public Boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(Boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }


        public Node() {
            this(false);
        }
    }


}
