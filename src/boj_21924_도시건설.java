import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj_21924_도시건설 {

    public static class  Load implements Comparable<Load>{
        int from;
        int to;
        Long coast;

        public Load(int from, int to, Long coast){
            this.from = from;
            this.to = to;
            this.coast = coast;
        }

        @Override
        public int compareTo(Load o) {
            return Long.compare(this.coast,o.coast);
        }
    }

    static int n;
    static int m;
    static Load[] loads;
    static int parents[];
    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        String tmp[] = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        loads = new Load[m];
        parents = new int[n+1];
        Long allCoast = 0L;

        for(int i = 0 ; i < m ;i++){
            tmp = br.readLine().split(" ");
            int from = Integer.parseInt(tmp[0]);
            int to = Integer.parseInt(tmp[1]);
            Long coast = Long.parseLong(tmp[2]);

            loads[i] = new Load(from,to,coast);
            allCoast += coast;
        }

        for(int i = 1 ; i <= n;i++){
            parents[i] = i;
        }

        Arrays.sort(loads);
        Long sum = 0L;
        int connectedLoadCnt = 0;
        for(int i = 0 ; i < m ; i++){
            Load load = loads[i];
            int from = find(load.from);
            int to = find(load.to);

            if(from!= to){
                union(from,to);
                sum += load.coast;
                connectedLoadCnt++;
            }
            if(connectedLoadCnt == n-1) break;
        }

        System.out.println(connectedLoadCnt == n-1? allCoast-sum : -1);

    }

    public static void union(int a, int b){

        if(parents[a] < parents[b]){
            parents[b] = parents[a];
        }else{
            parents[a] = parents[b];
        }
    }

    public static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

}
