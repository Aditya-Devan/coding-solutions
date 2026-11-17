# Car Pooling

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There is a car with `capacity` empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer `capacity` and an array `trips` where `trips[i] = [numPassengersi, fromi, toi]` indicates that the `ith` trip has `numPassengersi` passengers and the locations to pick them up and drop them off are `fromi` and `toi` respectively. The locations are given as the number of kilometers due east from the car's initial location.

Passengers are dropped off before new passengers are picked up at the same location. At every point along the route, the total number of passengers in the car must not exceed `capacity`.

Return `true` if it is possible to pick up and drop off all passengers for all the given trips, or `false` otherwise.

 

Original
Java
 **Example 1:** 

```
Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Explanation:
At kilometer 1, 2 passengers are picked up, so the car holds 2.
At kilometer 3, 3 more are picked up, so the car holds 5.
Since 5 > capacity = 4, the trips cannot all be completed.

```

 **Example 2:** 

```
Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Explanation:
At kilometer 1, the car holds 2 passengers.
At kilometer 3, the car holds 5 passengers.
At kilometer 5, the first 2 are dropped off, so the car holds 3.
At kilometer 7, the last 3 are dropped off, so the car holds 0.
The maximum occupancy is 5, which never exceeds capacity = 5.

```

 

 **Constraints:** 

- 1 <= trips.length <= 1000
- trips[i].length == 3
- 1 <= numPassengersi <= 100
- 0 <= fromi < toi <= 1000
- 1 <= capacity <= 105

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 11.43%)  
**Memory:** 45.4 MB (beats 98.18%)  
**Submitted:** 2026-11-17T12:23:45.301Z  

```java
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        
        // Sort trips by start location
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        
        // MinHeap to track drop-offs (end location)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        int i = 0;
        int locs = 0;

        while (i < n || !minHeap.isEmpty()) {
            // If no active trips, jump to next trip's start
            if (minHeap.isEmpty()) {
                locs = trips[i][1];
            }

            // Drop passengers at this location
            while (!minHeap.isEmpty() && minHeap.peek()[1] == locs) {
                capacity += minHeap.poll()[0];
            }

            // Board new passengers at this location
            while (i < n && trips[i][1] == locs) {
                if (capacity >= trips[i][0]) {
                    capacity -= trips[i][0];
                    minHeap.offer(new int[]{trips[i][0], trips[i][2]});
                } else {
                    return false;
                }
                i++;
            }

            // Move to next location: either next trip start or next drop
            if (!minHeap.isEmpty()) {
                locs = Math.min(
                    i < n ? trips[i][1] : Integer.MAX_VALUE,
                    minHeap.peek()[1]
                );
            } else if (i < n) {
                locs = trips[i][1];
            }
        }
        return true;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/car-pooling/)