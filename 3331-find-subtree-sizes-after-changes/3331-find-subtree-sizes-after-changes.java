import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private List<Integer>[] newAdj;
    private int[] newParent;
    private int[] lastSeen;
    private int[] ans;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.newParent = Arrays.copyOf(parent, n);
        this.lastSeen = new int[26];
        Arrays.fill(this.lastSeen, -1);

        // 1. Build initial tree adjacency list
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        // 2. First DFS to determine updated parents simultaneously
        findNewParents(0);

        // 3. Build updated tree adjacency list
        newAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newAdj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            newAdj[newParent[i]].add(i);
        }

        // 4. Second DFS to calculate subtree sizes
        ans = new int[n];
        computeSizes(0);

        return ans;
    }

    private void findNewParents(int u) {
        int charIdx = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[charIdx];

        if (prevAncestor != -1) {
            newParent[u] = prevAncestor;
        }

        lastSeen[charIdx] = u;
        for (int v : adj[u]) {
            findNewParents(v);
        }
        // Backtrack
        lastSeen[charIdx] = prevAncestor;
    }

    private int computeSizes(int u) {
        int size = 1;
        for (int v : newAdj[u]) {
            size += computeSizes(v);
        }
        ans[u] = size;
        return size;
    }
}