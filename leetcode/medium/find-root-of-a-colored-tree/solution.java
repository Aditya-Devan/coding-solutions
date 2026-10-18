class Solution {
    public int findColoredRoot(int[][] edges, String colors) {
        int n=colors.length();
        int[] degree = new int[n];

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        // A valid root can have at most 2 children.
        // Every non-root node can have at most 2 children,
        // so its degree can be at most 3.
        for (int i = 0; i < n; i++) {
            if (degree[i] > 3) {
                return -1;
            }
        }

        // Colors must advance by one step on every edge
        // under one of the three cyclic color sequences.
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            char c = colors.charAt(i);
            color[i] = c == 'R' ? 0 : c == 'B' ? 1 : 2;
        }

        boolean[] possible = new boolean[n];
        java.util.Arrays.fill(possible, true);

        // Every edge must connect colors that differ by
        // +1 or -1 modulo 3. This is necessary but not
        // sufficient; verify candidate roots by BFS.
        java.util.List<Integer>[] adj = new java.util.ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new java.util.ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int root = 0; root < n; root++) {
            if (degree[root] > 2) {
                continue;
            }

            boolean[] seen = new boolean[n];
            int[] parent = new int[n];
            int[] depth = new int[n];
            java.util.ArrayDeque<Integer> queue =
                new java.util.ArrayDeque<>();

            queue.offer(root);
            seen[root] = true;
            parent[root] = -1;
            boolean valid = true;

            while (!queue.isEmpty() && valid) {
                int u = queue.poll();
                int children = 0;

                for (int v : adj[u]) {
                    if (v == parent[u]) {
                        continue;
                    }

                    children++;
                    if (children > 2) {
                        valid = false;
                        break;
                    }

                    if (seen[v]) {
                        continue;
                    }

                    int expected = (color[u] + 1) % 3;
                    int actual = color[v];

                    if (actual != expected) {
                        valid = false;
                        break;
                    }

                    seen[v] = true;
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    queue.offer(v);
                }
            }

            if (valid) {
                return root;
            }
        }

        return -1;
    }
}