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

    
    public void addItemWithFirstValue(K key, V value) {
        try{
            if (mapWithFirstValue.containsKey(key)) {
                throw new CheckExistingKey();
            }
        } catch (CheckExistingKey e){
            mapWithFirstValue.put(key,value);
        }
    }

    public void addItemWithSecondValue(K key,T value) {
        try {
            if (mapWithSecondValue.containsKey(key)) {
                throw new CheckExistingKey();
            }
        } catch (CheckExistingKey e){
        mapWithSecondValue.put(key,value);
        }
    }

    public void addItemWithTwoValues(K key, V value1, T value2){
        mapWithFirstValue.put(key,value1);
        mapWithSecondValue.put(key,value2);
    }

    public void getFirstValue(K key) {
        try {
            if (mapWithFirstValue.get(key)==null){
                throw new CheckNullValue();
            }
        }catch (CheckNullValue e) {
            mapWithFirstValue.get(key);
        }
    }

    public void getSecondValue(K key) {
        try {
            if (mapWithSecondValue.get(key) == null) {
                throw new CheckNullValue();
            }
        }catch (CheckNullValue e) {
            mapWithSecondValue.get(key);
        }
    }

    public String getTwoValues(K key) {
        return "{" + key + "= " + mapWithFirstValue.get(key) + ", "
                + mapWithSecondValue.get(key) + "}";
    }

    public void removeItemByKey(K key) {
        try {
            if (!(mapWithFirstValue.containsKey(key))) {
                throw new CheckNullKey();
            }
            if (!(mapWithSecondValue.containsKey(key))) {
                throw new CheckNullKey();
            }
        }catch (CheckNullKey e) {
            mapWithFirstValue.remove(key);
            mapWithSecondValue.remove(key);
        }
    }

}
