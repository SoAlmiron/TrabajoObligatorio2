package Utilities;

import CustomExceptions.CheckNullKeyException;
import CustomExceptions.CheckExistingKeyException;
import CustomExceptions.CheckNullValueException;
import CustomExceptions.CheckThreeSameValuesException;
import java.util.*;

public class EpicDoubleHashMap<K extends Number, V, T> {
    private HashMap<K,V> mapWithFirstValue;
    private HashMap<K,T> mapWithSecondValue;

    int counterVValues = 0;
    int counterTValues = 0;
    boolean areValuesReapeated = false;

    public EpicDoubleHashMap() {
        mapWithFirstValue = new HashMap<>();
        mapWithSecondValue = new HashMap<>();
    }

    public HashMap<K, V> getMapWithFirstValue() {
        return mapWithFirstValue;
    }
    public HashMap<K, T> getMapWithSecondValue() {
        return mapWithSecondValue;
    }


    //ADD Items
    public void addItemWithFirstValue(K key, V value) throws CheckExistingKeyException, CheckThreeSameValuesException, CheckNullValueException {
        if (mapWithFirstValue.containsKey(key) || mapWithSecondValue.containsKey(key)) {
            throw new CheckExistingKeyException();
        }
        if (threeSameValues(value)){
            throw  new CheckThreeSameValuesException();
        }
        mapWithFirstValue.put(key,value);
        counterVValues ++;
    }

    public void addItemWithSecondValue(K key,T value)  throws CheckExistingKeyException, CheckThreeSameValuesException {
        if (mapWithSecondValue.containsKey(key) || mapWithFirstValue.containsKey(key)) {
            throw new CheckExistingKeyException();
        }
        if (threeSameValues(value)){
            throw  new CheckThreeSameValuesException();
        }
        mapWithSecondValue.put(key,value);
        counterTValues ++;
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
                counterV +=1;
                areValuesReapeated = true;
            }
        }
        for (Map.Entry<K, T> entry : mapWithSecondValue.entrySet()) {
            if (value.equals(entry.getValue())) {
                counterT += 1;
                areValuesReapeated = true;
            }
        }
        return counterV >= 2 && counterT >= 2;
    }
    public void checkValuesMapWithTwoValues(V value1, T value2) throws CheckThreeSameValuesException{
        int counterFirstValue = 0;
        int counterSecondValue = 0;
        boolean counterThreeRepeatValue = false;


        for (K key : mapWithFirstValue.keySet()) {
            if (mapWithFirstValue.get(key).equals(value1)) {
                counterFirstValue ++;
            }
        }
        for (K key : mapWithSecondValue.keySet()) {
            if (mapWithSecondValue.get(key).equals(value2)) {
                counterSecondValue++;
            }
        }
        if (counterFirstValue >= 2 && counterSecondValue >= 2){ counterThreeRepeatValue = true;}
        if (counterThreeRepeatValue) {
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
        return "" + getFirstValue(key) + ", " + getSecondValue(key) + "";
    }

    //REMOVE item by Key
    public void removeItemByKey(K key) throws CheckNullKeyException {
        if ((mapWithFirstValue.containsKey(key)) || (mapWithSecondValue.containsKey(key))){
            mapWithFirstValue.remove(key);
            mapWithSecondValue.remove(key);
        }else {
            throw new CheckNullKeyException();
        }
    }


    //AUXILIAR METHODS
    public String mostValues(){
        if(counterVValues > counterTValues){
            return "There are more V values than T values.";
        }
        if (counterTValues > counterVValues){
            return "There are more T values than V values.";
        }else {
            return "There is the same amount between V and T values.";
        }
    }

    public String timesValuesRepeat(K keyCheck){
        int counterValueRepeat = 0;
        V valueToCheckTypeV = mapWithFirstValue.get(keyCheck);
        T valueToCheckTypeT = mapWithSecondValue.get(keyCheck);
        for ( K key : mapWithFirstValue.keySet()) {
            if (mapWithFirstValue.get(key).equals(valueToCheckTypeV)){
                counterValueRepeat ++;
            }
        }
        for ( K key : mapWithSecondValue.keySet()) {
            if (mapWithSecondValue.get(key).equals(valueToCheckTypeT)){
                counterValueRepeat ++;
            }
        }

        if(counterVValues > 0 && counterTValues == 0){
            counterValueRepeat = counterVValues;
        }else{
            counterValueRepeat = counterTValues;
        }
        return "The value for the key " + keyCheck + " repeats " + counterValueRepeat + " times.";
    }

    public boolean valuesRepeated(){
        if (areValuesReapeated){
            return true;
        } return false;
    }






}