package DeliveryRoutingSystem.java;
import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final Map<K, V> cache;
    private final Map<K, Long> Time;
    
    @SuppressWarnings("unused")
	private final int size;

    public LRUCache(int size) {
        this.size = size;
        this.cache = new HashMap<>();
        this.Time = new HashMap<>();
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {      //if not present
            return null;
        }
        Time.put(key, System.nanoTime());          // Update  recently used
        return cache.get(key);
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {           // If the key is already present update its value
            Time.put(key, System.nanoTime());
            cache.put(key, value);
        } else {
            if (cache.size() == size) {
                evictLeastRecentlyUsed();
            }
            cache.put(key, value);
            Time.put(key, System.nanoTime());              //Put the new key-value pair and update
        }
    }

    private void evictLeastRecentlyUsed() {
        long minTime = Long.MAX_VALUE;
        K keyRemove = null;
        
        for (Map.Entry<K, Long> entry : Time.entrySet()) {         //find the old time
            if (entry.getValue() < minTime) {
            	
                minTime = entry.getValue();
                
                keyRemove = entry.getKey();
            }
        }
        if (keyRemove != null) {
            cache.remove(keyRemove);
            
          Time.remove(keyRemove);
        }
    }

   
}
