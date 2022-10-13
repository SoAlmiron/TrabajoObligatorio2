import java.util.HashMap;

public class EpicDoubleHashMap<K extends Number, V, T> {
    private HashMap<K,V> mapOne;
    private HashMap<K,T> mapTwo;

    public HashMap<K, V> getFirstMap() {
        return mapOne;
    }

    public void setMapOne(HashMap<K, V> map) {
        this.mapOne = map;
    }

    public HashMap<K, T> getMapTwo() {
        return mapTwo;
    }

    public void setMapTwo(HashMap<K, T> map1) {
        this.mapTwo = map1;
    }

    public EpicDoubleHashMap(HashMap<K, V> mapOne, HashMap<K, T> mapTwo) {
        this.mapOne = mapOne;
        this.mapTwo = mapTwo;
    }
    
    public void addTwoType(K key, V value){
        mapOne.put(key,value);
    }

    public void addTwoTypes(K key,T value){
        mapTwo.put(key,value);
    }

    public void addThreeType(K key, V value, T value2){
        mapOne.put(key,value);
        mapTwo.put(key,value2);
    }

}
