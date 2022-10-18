import java.util.HashMap;

public class EpicDoubleHashMap<K extends Number, V, T> {
    private HashMap<K,V> mapWithFirstValue;
    private HashMap<K,T> mapWithSecondValue;

    public EpicDoubleHashMap() {
        mapWithFirstValue = new HashMap<>();
        mapWithSecondValue = new HashMap<>();
    }

    public HashMap<K, V> getMapWithFirstValue() {
        return mapWithFirstValue;
    }

    public void setMapWithFirstValue(HashMap<K, V> map) {
        this.mapWithFirstValue = map;
    }

    public HashMap<K, T> getMapWithSecondValue() {
        return mapWithSecondValue;
    }

    public void setMapWithSecondValue(HashMap<K, T> map1) {
        this.mapWithSecondValue = map1;
    }

    
    public void addItemWithFirstValue(K key, V value) throws CheckExistingKey {
        if (mapWithFirstValue.containsKey(key)) {
            throw new CheckExistingKey();
        }
        mapWithFirstValue.put(key,value);
    }

    public void addItemWithSecondValue(K key,T value) throws CheckExistingKey {
        if (mapWithSecondValue.containsKey(key)) {
            throw new CheckExistingKey();
        }
        mapWithSecondValue.put(key,value);
    }

    public void addItemWithTwoValues(K key, V value1, T value2){
        mapWithFirstValue.put(key,value1);
        mapWithSecondValue.put(key,value2);
    }

    public V getFirstValue(K key) throws CheckNullValue {
        if (mapWithFirstValue.get(key)==null){
            throw new CheckNullValue();
        }
        return (V) ("{" + key + "= " + mapWithFirstValue.get(key) + "}");

    }

    public T getSecondValue(K key) throws CheckNullValue {
        if (mapWithSecondValue.get(key) == null) {
            throw new CheckNullValue();
        }
        return (T) ("{" + key + "= " + mapWithSecondValue.get(key) + "}");
    }

    public String getTwoValues(K key) {
        return "{" + key + "= " + mapWithFirstValue.get(key) + ", "
                + mapWithSecondValue.get(key) + "}";
    }

    public void removeItemByKey(K key) throws CheckNullKey {
        if (!(mapWithFirstValue.containsKey(key)) ||
                (!(mapWithSecondValue.containsKey(key)))){
            throw new CheckNullKey();
        }
        mapWithFirstValue.remove(key);
        mapWithSecondValue.remove(key);
    }

}
