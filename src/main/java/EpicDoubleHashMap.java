import java.util.ArrayList;
import java.util.HashMap;

public class EpicDoubleHashMap<K extends Number, V, T>{

     HashMap<K, V> mapWithFirstValue;
     HashMap<K, T> mapWithSecondValue;
    ArrayList<Object> listMap;

    public EpicDoubleHashMap() {
        mapWithFirstValue = new HashMap<>();
        mapWithSecondValue = new HashMap<>();
        listMap = new ArrayList<>();

    }

    public HashMap<K, V> getMapWithFirstValue() {
        return this.mapWithFirstValue;
    }

    public HashMap<K, T> getMapWithSecondValue() {
        return this.mapWithSecondValue;
    }

    public void addItemWithFirstValue (K key, V value){
        mapWithFirstValue.put(key, value);
    }

    public void addItemWithSecondValue (K key, T value){
        mapWithSecondValue.put(key, value);
    }

    public void addItemWithTwoValues (K key, V value1, T value2){
        mapWithFirstValue.put(key, value1);
        mapWithSecondValue.put(key, value2);
        listMap.add(key);
        listMap.add(value1);
        listMap.add(value2);
    }

    public V getFirstValue(K key){
        return mapWithFirstValue.get(key);
    }
    public T getSecondValue(K key){
        return mapWithSecondValue.get(key);
    }
    public void removeItemByKey(K key){
        if (mapWithFirstValue.containsKey(key)){
            mapWithFirstValue.remove(key);
        }
        if (mapWithSecondValue.containsKey(key)){
            mapWithSecondValue.remove(key);
        }
    }

    @Override
    public String toString() {
        return "EpicDoubleHashMap= " +
                 getMapWithFirstValue() +
                 getMapWithSecondValue() +
                listMap;
    }
}
