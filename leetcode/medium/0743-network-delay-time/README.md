# Network Delay Time

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a network of `n` nodes, labeled from `1` to `n`. You are also given `times`, a list of travel times as directed edges `times[i] = (ui, vi, wi)`, where `ui` is the source node, `vi` is the target node, and `wi` is the time it takes for a signal to travel from source to target.

We will send a signal from a given node `k`. Return  *the  **minimum**  time it takes for all the*  `n`  *nodes to receive the signal*. If it is impossible for all the `n` nodes to receive the signal, return `-1`.

 

 **Example 1:** 

```
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

```

 **Example 2:** 

```
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

```

 **Example 3:** 

```
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

```

 

 **Constraints:** 

- 1 <= k <= n <= 100
- 1 <= times.length <= 6000
- times[i].length == 3
- 1 <= ui, vi <= n
- ui != vi
- 0 <= wi <= 100
- All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 96.47%)  
**Memory:** 47.1 MB (beats 99.81%)  
**Submitted:** 2026-10-31T11:27:18.861Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/network-delay-time/)