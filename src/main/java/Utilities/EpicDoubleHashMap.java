package Utilities;

import CustomExceptions.CheckNullKeyException;
import CustomExceptions.CheckExistingKeyException;
import CustomExceptions.CheckNullValueException;
import CustomExceptions.CheckThreeSameValuesException;
import java.util.*;

public class EpicDoubleHashMap<K extends Number, V, T> {
    private HashMap<K,V> mapWithFirstValue;
    private HashMap<K,T> mapWithSecondValue;
    boolean areValuesRepeated = false;

    public EpicDoubleHashMap() {
        mapWithFirstValue = new HashMap<>();
        mapWithSecondValue = new HashMap<>();
    }

    //ADD Items
    public void addItemWithFirstValue(K key, V value) throws CheckExistingKeyException, CheckThreeSameValuesException {
        if (mapWithFirstValue.containsKey(key) || mapWithSecondValue.containsKey(key)) {
            throw new CheckExistingKeyException();
        }
        if (threeSameValues(value)){
            throw  new CheckThreeSameValuesException();
        }
        checkValuesMapWithFirstValue(value);
        mapWithFirstValue.put(key,value);
    }
    public void addItemWithSecondValue(K key,T value)  throws CheckExistingKeyException, CheckThreeSameValuesException {
        if (mapWithSecondValue.containsKey(key) || mapWithFirstValue.containsKey(key)) {
            throw new CheckExistingKeyException();
        }
        if (threeSameValues(value)){
            throw  new CheckThreeSameValuesException();
        }
        checkValuesMapWithSecondValue(value);
        mapWithSecondValue.put(key,value);
    }
    public void addItemWithTwoValues(K key, V value1, T value2) throws CheckExistingKeyException, CheckThreeSameValuesException {
        if (mapWithSecondValue.containsKey(key) || mapWithFirstValue.containsKey(key)) {
            throw new CheckExistingKeyException();
        }
        checkValuesMapWithTwoValues(value1, value2);
        mapWithFirstValue.put(key,value1);
        mapWithSecondValue.put(key,value2);
    }

    //Checking Three Times repetition
    public boolean threeSameValues(Object value){
        int counterV = 0;
        int counterT = 0;

        for (Map.Entry<K, V> entry : mapWithFirstValue.entrySet()) {
            if (value.equals(entry.getValue())){
                counterV++;
            }
        }
        for (Map.Entry<K, T> entry : mapWithSecondValue.entrySet()) {
            if (value.equals(entry.getValue())) {
                counterT++;
            }
        }
        if (counterT > 0 || counterV > 0){
            areValuesRepeated = true;
        }
        return counterV >= 2 && counterT >= 2;
    }
    public boolean checkValuesMapWithFirstValue(V value) throws CheckThreeSameValuesException {
        int counter = 0;
        for (Map.Entry<K, V> map : mapWithFirstValue.entrySet()) {
            for (Map.Entry<K, V> entry : mapWithFirstValue.entrySet()) {
                if (!map.getKey().equals(entry.getKey()) && map.getValue().equals(value)
                        && entry.getValue().equals(value)) {
                    counter++;
                }
            }
        }
        if (counter >= 2){
            throw new CheckThreeSameValuesException();
        } else return false;
    }
    public boolean checkValuesMapWithSecondValue(T value) throws CheckThreeSameValuesException{
        int counter = 0;
        for (Map.Entry<K, T> map : mapWithSecondValue.entrySet()) {
            for (Map.Entry<K, T> entry : mapWithSecondValue.entrySet()) {
                if (!map.getKey().equals(entry.getKey()) && map.getValue().equals(value)
                        && entry.getValue().equals(value)){
                    counter++;
                }
            }
        }
        if (counter >= 2){
            throw new CheckThreeSameValuesException();
        }
        else return false;
    }
    public void checkValuesMapWithTwoValues(V value1, T value2) throws CheckThreeSameValuesException{
        if (checkValuesMapWithFirstValue(value1) && checkValuesMapWithSecondValue(value2)){
            throw new CheckThreeSameValuesException();
        }
    }

    //GET Values
    public V getFirstValue(K key) throws CheckNullValueException {
        if (mapWithFirstValue.get(key) == null) {
            throw new CheckNullValueException();
        } else{
            return mapWithFirstValue.get(key);
        }
    }
    public T getSecondValue(K key) throws CheckNullValueException {
        if (mapWithSecondValue.get(key) == null) {
            throw new CheckNullValueException();
        } else{
            return mapWithSecondValue.get(key);
        }
    }
    public String getTwoValues(K key) throws CheckNullValueException {
        return "" + getFirstValue(key) + " " + getSecondValue(key) + "";
    }

    //REMOVE item by Key
    public void removeItemByKey(K key) throws CheckNullKeyException {
        if (mapWithFirstValue.containsKey(key)){
            mapWithFirstValue.remove(key);
        }
        if (mapWithSecondValue.containsKey(key)){
            mapWithSecondValue.remove(key);
        }else {
            throw new CheckNullKeyException();
        }
    }

    //AUXILIARY METHODS
    public String mostValues(){
        if(mapWithFirstValue.size() > mapWithSecondValue.size()){
            return "There are more V values than T values.";
        } else if (mapWithSecondValue.size() > mapWithFirstValue.size()){
            return "There are more T values than V values.";
        }else {
            return "There is the same amount between V and T values.";
        }
    }
    public String timesValuesRepeat(K keyCheck) throws CheckNullValueException {
        int counterVValues = 0;
        int counterTValues = 0;

        if (mapWithSecondValue.get(keyCheck) == null) {
            throw new CheckNullValueException();
        } else {
            for (K key : mapWithFirstValue.keySet()) {
                if (mapWithFirstValue.get(key).equals(mapWithFirstValue.get(keyCheck))) {
                    counterVValues++;
                }
            }
            for (K key : mapWithSecondValue.keySet()) {
                if (mapWithSecondValue.get(key).equals(mapWithSecondValue.get(keyCheck))) {
                    counterTValues++;
                }
            }

            if (counterVValues > 0 && counterTValues == 0) {
                return "The first value for the key " + keyCheck + " repeats " + counterVValues + " times.";
            } else if (counterTValues > 0 && counterVValues == 0) {
                return "The second value for the key " + keyCheck + " repeats " + counterTValues + " times.";
            } else
                return "The values for the key " + keyCheck + " repeats V= " + counterVValues + " T= " + counterTValues + " times.";
        }
    }

    public boolean valuesRepeated(){
        return areValuesRepeated;
    }
}