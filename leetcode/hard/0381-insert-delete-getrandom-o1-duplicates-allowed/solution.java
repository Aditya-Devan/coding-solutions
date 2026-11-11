class RandomizedCollection {
    HashMap<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val);
        if (notPresent) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return notPresent;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
        
        // Get an arbitrary index of 'val' from its set
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        
        // If the set becomes empty, remove the key from the map
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        
        int lastIndex = list.size() - 1;
        int lastElement = list.get(lastIndex);
        
        // If the element to remove is not the last element, swap it with the last element
        if (index != lastIndex) {
            list.set(index, lastElement);
            // Update the index of lastElement in the map
            map.get(lastElement).remove(lastIndex);
            map.get(lastElement).add(index);
        }
        
        // Remove the last element
        list.remove(lastIndex);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}