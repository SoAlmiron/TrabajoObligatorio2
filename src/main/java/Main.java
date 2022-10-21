import Classes.Dog;
import Classes.Person;
import CustomExceptions.CheckExistingKeyException;
import CustomExceptions.CheckNullKeyException;
import CustomExceptions.CheckNullValueException;
import CustomExceptions.CheckThreeSameValuesException;
import Utilities.EpicDoubleHashMap;

public class Main {
    public static void main(String[] args) throws CheckExistingKeyException, CheckThreeSameValuesException, CheckNullValueException, CheckNullKeyException {
        EpicDoubleHashMap<Integer, Person, Dog> mapOfTwoDogs = new EpicDoubleHashMap<>();
        Person firstPerson = new Person("Pepe");
        Person secondPerson = new Person("alex");

        Dog firstDog = new Dog("Tobi", 10);
        Dog secondDog = new Dog("Tobi", 10);
        Dog thirdDog = new Dog("Tobi", 10);
        Dog fourthDog = new Dog("Tobi", 12);

        mapOfTwoDogs.addItemWithTwoValues(1, firstPerson, firstDog);
        mapOfTwoDogs.addItemWithTwoValues(2, firstPerson, secondDog);
        // throws exception three times mapOfTwoDogs.addItemWithTwoValues(3, firstPerson, secondDog);



        mapOfTwoDogs.addItemWithFirstValue(11, firstPerson);
        mapOfTwoDogs.addItemWithFirstValue(12, secondPerson);
        // throws exception three times mapOfTwoDogs.addItemWithFirstValue(13, secondPerson);

        mapOfTwoDogs.addItemWithSecondValue(111,secondDog);
        mapOfTwoDogs.addItemWithSecondValue(222,fourthDog);
        // throws exception three times mapOfTwoDogs.addItemWithSecondValue(333,fourthDog);

        mapOfTwoDogs.removeItemByKey(111);
        mapOfTwoDogs.getFirstValue(11);


        // AUX Methods
        System.out.println(mapOfTwoDogs.mostValues());
        System.out.println(mapOfTwoDogs.timesValuesRepeat(1));
        System.out.println("There are values repeated? " +mapOfTwoDogs.valuesRepeated());

    }
}
