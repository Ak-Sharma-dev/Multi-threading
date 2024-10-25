import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final LinkedList<Integer> queue;
    private final Map<Integer, String> map;

    public LRUCache(int capacity, LinkedList<Integer> queue, Map<Integer, String> map) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.queue = new LinkedList<>();
    }

    public void put(Integer key, String value) {
        if (map.containsKey(key)) {
            queue.remove(key);
        } else if (map.size() == capacity) {
            Integer leastRecentlyUsed = queue.pollLast();
            map.remove(leastRecentlyUsed);
        }
        map.put(key, value);
        queue.offerFirst(key);
    }

    public String get(Integer key) {
        if(map.containsKey(key)) {
            queue.remove(key);
            queue.offerFirst(key);
            return map.get(key);
        } else {
            System.out.println("Key not found");
            return null;
        }
    }
}
