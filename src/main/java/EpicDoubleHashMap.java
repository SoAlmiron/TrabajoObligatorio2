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

    
    public void addItemWithFirstValue(K key, V value){
        mapWithFirstValue.put(key,value);
    }

    public void addItemWithSecondValue(K key,T value){
        mapWithSecondValue.put(key,value);
    }

    public void addItemWithTwoValues(K key, V value1, T value2){
        mapWithFirstValue.put(key,value1);
        mapWithSecondValue.put(key,value2);
    }

    public V getFirstValue(K key){
        return mapWithFirstValue.get(key);
    }

    public T getSecondValue(K key){
        return mapWithSecondValue.get(key);
    }

    public String getTwoValues(K key) {
        return "{" + key + "= " + mapWithFirstValue.get(key) + ", "
                + mapWithSecondValue.get(key) + "}";
    }

    public void removeItemByKey(K key){
        if (mapWithFirstValue.containsKey(key)){
            mapWithFirstValue.remove(key);
        }
        if (mapWithSecondValue.containsKey(key)){
            mapWithSecondValue.remove(key);
        }
    }

}
