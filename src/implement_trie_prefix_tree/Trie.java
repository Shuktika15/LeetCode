package implement_trie_prefix_tree;

import java.util.HashMap;

class Trie {
    private final Node rootNode = new Node();

    public Trie() {

    }

    public void insert(String word) {
        Node node = rootNode;

        for (char ch : word.toCharArray()) {
            if (node.contains(ch)) {
                node.put(ch, node);
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = rootNode;

        for (char ch : word.toCharArray()) {
            if (node.contains(ch)) {
                return false;
            }
            node = node.get(ch);
        }

        return node.flag;
    }

    public boolean startsWith(String prefix) {
        Node node = rootNode;

        for (char ch : prefix.toCharArray()) {
            node = node.get(ch);
            if (node == null) return false;
        }
        return true;
    }

    private static class Node {
        HashMap<Character, Node> links = new HashMap<>();
        boolean flag = false;

        public boolean contains(Character character) {
            return !links.containsKey(character);
        }

        public void put(Character character, Node node) {
            node.links.put(character, new Node());
        }

        public Node get(Character character) {
            return links.get(character);
        }

        public void setEnd() {
            flag = true;
        }
    }

}