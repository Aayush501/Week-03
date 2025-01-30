import java.util.LinkedList;

// definition of HashMap class
class HashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    // constructor of HashMap class
    public HashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % INITIAL_CAPACITY;
    }

    // method to put the value to the HashMap
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
    }

    // method to get the Value with the key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    // method to remove the element with key
    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
        bucket.removeIf(entry -> entry.key.equals(key));
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

// definition of CustomHashMap class
public class CustomHashMap {
    public static void main(String[] args) {

        // creating a custom hash map
        HashMap<String, Integer> map = new HashMap<>();

        // putting the values inside map
        map.put("one", 1);
        map.put("two", 2);

        System.out.println(map.get("one")); // output: 1
        System.out.println(map.get("two")); // output: 2
        map.remove("one");
        System.out.println(map.get("one")); // output: null
    }
}