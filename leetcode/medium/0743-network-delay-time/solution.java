class Solution {
   public class pair implements Comparable<pair>{
      int n,path;
      public pair(int n,int path){
        this.n=n;
        this.path=path;
      }
      @Override
      public int compareTo(pair p2){
        return this.path-p2.path;
      }
    }

   public  class edge{
        int src,dest,wt;
        public edge(int src,int dest,int wt){
              this.src=src;
              this.dest=dest;
              this.wt=wt;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<edge>[] graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<times.length;i++){
            graph[times[i][0]].add(new edge(times[i][0],times[i][1],times[i][2]));
        }

        int dist[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=k){
                dist[i]=Integer.MAX_VALUE;
            }
        }
      boolean vis[]=new boolean[graph.length];
      PriorityQueue<pair> pq=new PriorityQueue<>();

      pq.offer(new pair(k,0));

      while(!pq.isEmpty()){

       pair curr=pq.poll();
        if(!vis[curr.n]){
            vis[curr.n]=true;
            //visit neighbors
            for(int i=0;i<graph[curr.n].size();i++){
                edge e=graph[curr.n].get(i);
                int s=e.src;
                int d=e.dest;
                int w=e.wt;

            if(dist[s]+w<dist[d]){
                dist[d]=dist[s]+w;
                pq.offer(new pair(d,dist[d]));
            }

            }
        }

      }

     int maxTime = 0;
     for (int i = 1; i <= n; i++) {
      if (dist[i] == Integer.MAX_VALUE) return -1;
      maxTime = Math.max(maxTime, dist[i]);
     }

   return maxTime;

    }
}