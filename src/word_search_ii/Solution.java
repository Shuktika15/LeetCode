package word_search_ii;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<String> answer = new ArrayList<>();
    private final int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private final Trie trie = new Trie();
    private int row;
    private int column;
    private char[][] gr;
    private boolean[][] v;

    private boolean in(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < column;
    }

    private void dfs(int x, int y, StringBuilder sb) {
        v[x][y] = true;
        if (!trie.startsWith(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
            v[x][y] = false;
            return;
        }
        if (trie.search(sb.toString())) {
            trie.erase(sb.toString());
            answer.add(sb.toString());
        }
        for (int i = 0; i < 4; ++i) {
            int nX = x + d[i][0], nY = y + d[i][1];
            if (!in(nX, nY) || v[nX][nY]) {
                continue;
            }
            sb.append(gr[nX][nY]);
            dfs(nX, nY, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        v[x][y] = false;
    }

    public List<String> findWords(char[][] grid, String[] w) {
        for (String s : w) {
            trie.insert(s);
        }
        this.gr = grid;
        this.row = grid.length;
        this.column = grid[0].length;
        v = new boolean[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                StringBuilder sb = new StringBuilder();
                sb.append(gr[i][j]);
                dfs(i, j, sb);
            }
        }
        return answer;
    }

    static class Trie {
        Node head;

        public Trie() {
            head = new Node();
        }

        public void insert(String word) {
            Node current = head;
            int n = word.length();
            for (int i = 0; i < n; ++i) {
                if (current.children[word.charAt(i) - 'a'] == null) {
                    current.children[word.charAt(i) - 'a'] = new Node();
                }
                current = current.children[word.charAt(i) - 'a'];
                ++current.count;
            }
            current.isWord = true;
        }

        public boolean search(String word) {
            Node current = head;
            int n = word.length();
            for (int i = 0; i < n; ++i) {
                if (current.children[word.charAt(i) - 'a'] == null || current.children[word.charAt(i) - 'a'].count == 0) {
                    return false;
                }
                current = current.children[word.charAt(i) - 'a'];
            }
            return current.isWord;
        }

        public boolean startsWith(String s) {
            Node current = head;
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                if (current.children[s.charAt(i) - 'a'] == null || current.children[s.charAt(i) - 'a'].count == 0) {
                    return false;
                }
                current = current.children[s.charAt(i) - 'a'];
            }
            return true;
        }

        public void erase(String s) {
            Node current = head;
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                --current.children[s.charAt(i) - 'a'].count;
                current = current.children[s.charAt(i) - 'a'];
            }
            current.isWord = false;
        }

        static class Node {
            Node[] children;
            boolean isWord = false;
            int count = 0;

            Node() {
                children = new Node[26];
            }
        }
    }
}