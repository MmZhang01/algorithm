package DailyPractice;

public class DailyPractice41 {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UF uf = new QuickUnionUF(26);
        int n = s1.length();
        for(int i=0;i<n;i++){
            uf.union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        int n1=baseStr.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n1;i++){
            sb.append((char)(uf.find(baseStr.charAt(i)-'a')+'a'));
        }
        return sb.toString();

    }

    private abstract class UF {

        protected int[] id;

        public UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public abstract int find(int p);

        public abstract void union(int p, int q);
    }
    private class QuickUnionUF extends UF {

        public QuickUnionUF(int N) {
            super(N);
        }


        @Override
        public int find(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }


        @Override
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot != qRoot) {
                if(pRoot<qRoot){
                    id[qRoot]=pRoot;
                }else id[pRoot] = qRoot;
            }
        }
    }
}
