package Utilities;

import CustomExceptions.CheckNullKeyException;
import CustomExceptions.CheckExistingKeyException;
import CustomExceptions.CheckNullValueException;
import CustomExceptions.CheckThreeSameValuesException;

import java.io.FileReader;
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

    public void addItemWithFirstValue(K key, V value) throws CheckExistingKeyException, CheckThreeSameValuesException {
        if (mapWithFirstValue.containsKey(key)) {
            throw new CheckExistingKeyException();
        }
        checkValuesMapWithFirstValue(value);
        mapWithFirstValue.put(key,value);
        counterVValues ++;
    }

    public void addItemWithSecondValue(K key,T value)  throws CheckExistingKeyException, CheckThreeSameValuesException {
        if (mapWithSecondValue.containsKey(key)) {
            throw new CheckExistingKeyException();
        }
        checkValuesMapWithSecondValue(value);
        mapWithSecondValue.put(key,value);
        counterTValues ++;
    }

    public void addItemWithTwoValues(K key, V value1, T value2) throws CheckExistingKeyException, CheckThreeSameValuesException {
        if (mapWithSecondValue.containsKey(key)) {
            throw new CheckExistingKeyException();
        }
        checkValuesMapWithTwoValues(value1, value2);
        mapWithFirstValue.put(key,value1);
        mapWithSecondValue.put(key,value2);
    }

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


    public void removeItemByKey(K key) throws CheckNullKeyException {
        if ((mapWithFirstValue.containsKey(key)) || (mapWithSecondValue.containsKey(key))){
            mapWithFirstValue.remove(key);
            mapWithSecondValue.remove(key);
        }else {
            throw new CheckNullKeyException();
        }
    }

    public void checkValuesMapWithFirstValue(V value) throws CheckThreeSameValuesException{
        int counter = 0;
        for ( K key : mapWithFirstValue.keySet()) {
            if (mapWithFirstValue.get(key).equals(value)){
                counter++;

            }
        }
        if (counter >= 2){
            throw  new CheckThreeSameValuesException();
        }
    }

    public void checkValuesMapWithSecondValue(T value) throws CheckThreeSameValuesException{
        int counter = 0;
       for ( K key : mapWithSecondValue.keySet()) {
           if (mapWithSecondValue.get(key).equals(value)){
               counter++;

           }
       }
       if (counter >= 2){
           throw  new CheckThreeSameValuesException();
       }
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
        if (counterFirstValue >= 3 && counterSecondValue >= 3){ counterThreeRepeatValue = true;}
        if (counterThreeRepeatValue) {
            throw new CheckThreeSameValuesException();
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
        int counterValue1Repeat = 0 ;
        int counterValue2Repeat = 0;
        V valueToCheckTypeV = mapWithFirstValue.get(keyCheck);
        T valueToCheckTypeT = mapWithSecondValue.get(keyCheck);
        for ( K key : mapWithFirstValue.keySet()) {
            if (mapWithFirstValue.get(key).equals(valueToCheckTypeV)){
                counterValue1Repeat ++;
                areValuesReapeated = true;
            }
        }
        for ( K key : mapWithSecondValue.keySet()) {
            if (mapWithSecondValue.get(key).equals(valueToCheckTypeT)){
                counterValue2Repeat ++;
                areValuesReapeated = true;
            }
        }

        return "The value for the key " + keyCheck + " repeats: value1: " +
                counterValue1Repeat + " value2: " + counterValue2Repeat;
    }

    public boolean valuesRepeated(){
        if (areValuesReapeated) {
            return true;
        } else {
            return false;
        }
    }






}