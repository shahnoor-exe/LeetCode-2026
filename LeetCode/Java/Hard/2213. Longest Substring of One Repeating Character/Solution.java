class Solution {
    int[] mx, lmx, rmx, len;
    char[] lc, rc, str;
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length(), k = queryIndices.length;
        str = s.toCharArray();
        mx = new int[4 * n];
        lmx = new int[4 * n];
        rmx = new int[4 * n];
        len = new int[4 * n];
        lc = new char[4 * n];
        rc = new char[4 * n];
        build(1, 0, n - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            res[i] = mx[1];
        }
        return res;
    }
    private void build(int node, int l, int r) {
        len[node] = r - l + 1;
        if (l == r) {
            mx[node] = lmx[node] = rmx[node] = 1;
            lc[node] = rc[node] = str[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(node << 1, l, mid);
        build(node << 1 | 1, mid + 1, r);
        pushup(node);
    }
    private void update(int node, int l, int r, int idx, char c) {
        if (l == r) {
            str[idx] = lc[node] = rc[node] = c;
            return;
        }
        int mid = (l + r) >> 1;
        if (idx <= mid) update(node << 1, l, mid, idx, c);
        else update(node << 1 | 1, mid + 1, r, idx, c);
        pushup(node);
    }
    private void pushup(int node) {
        int left = node << 1, right = node << 1 | 1;
        lc[node] = lc[left];
        rc[node] = rc[right];
        lmx[node] = lmx[left] + (lmx[left] == len[left] && rc[left] == lc[right] ? lmx[right] : 0);
        rmx[node] = rmx[right] + (rmx[right] == len[right] && rc[left] == lc[right] ? rmx[left] : 0);
        mx[node] = Math.max(mx[left], mx[right]);
        if (rc[left] == lc[right]) {
            mx[node] = Math.max(mx[node], rmx[left] + lmx[right]);
        }
    }
}