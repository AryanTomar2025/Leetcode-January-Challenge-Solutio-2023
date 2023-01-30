class Solution 
{
    public int numberOfGoodPaths(int[] vals, int[][] edges) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        int n = vals.length;
        Map<Integer, List<Integer>> tmp = new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            List<Integer> ls = tmp.getOrDefault(vals[i], new ArrayList<>());
            ls.add(i);
            tmp.put(vals[i], ls);
        }
        
        for(int[] e: edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int res = n;
        DSU dsu = new DSU(n);
        boolean[] isActive = new boolean[n];
        for(Integer key: tmp.keySet())
        {
            List<Integer> indexes = tmp.get(key);
            for(Integer u: indexes)
            {
                for(Integer v: adj.get(u))
                {
                    if(isActive[v])
                        dsu.union(u, v);
                }
                isActive[u] = true;
            }
            
            Map<Integer, Integer> hmp = new HashMap<>();
            for(Integer u: indexes)
            {
                int par = dsu.find(u);
                hmp.put(par, hmp.getOrDefault(par, 0)+1);
            }
            for(Integer k: hmp.keySet())
            {
                int val = hmp.get(k);
                res += (val*(val-1))/2;
            }
        }
        return res;
    }
    
    class DSU {
        int[] parent;
        int[] ranks;

        public DSU(int n) {
            parent = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                ranks[i] = 1;
            }
        }

        public int find(int x)
        {
            if (parent[x] == x)
                return x;
            else
                return parent[x] = find(parent[x]);
        }

        public void union(int x, int y)
        {
            int x_rep = find(x);
            int y_rep = find(y);
            if (x_rep == y_rep)
                return;

            if (ranks[x_rep] < ranks[y_rep])
            {
                parent[x_rep] = y_rep;
            }
            else if (ranks[x_rep] > ranks[y_rep])
            {
                parent[y_rep] = x_rep;
            }
            else {
                parent[y_rep] = x_rep;
                ranks[x_rep]++;
            }
        }
    }

}
