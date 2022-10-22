import Classes.Dog;
import Classes.Person;
import CustomExceptions.CheckExistingKeyException;
import CustomExceptions.CheckNullKeyException;
import CustomExceptions.CheckNullValueException;
import CustomExceptions.CheckThreeSameValuesException;
import Utilities.EpicDoubleHashMap;

public class Main {
    public static void main(String[] args) throws CheckExistingKeyException, CheckThreeSameValuesException,
            CheckNullValueException, CheckNullKeyException {
        EpicDoubleHashMap<Integer, Person, Dog> mapOfTwoDogs = new EpicDoubleHashMap<>();
        Person firstPerson = new Person("Pepe");
        Person secondPerson = new Person("Alex");
        Person thirdPerson =new Person("Flor");

        Dog firstDog = new Dog("Tobi", 10);
        Dog secondDog = new Dog("Tobi", 10);
        Dog thirdDog = new Dog("Teo", 8);
        Dog fourthDog = new Dog("Lula", 12);

        mapOfTwoDogs.addItemWithTwoValues(1, firstPerson, firstDog);
        mapOfTwoDogs.addItemWithTwoValues(2, firstPerson, fourthDog);
        // throws exception Three times mapOfTwoDogs.addItemWithTwoValues(3, firstPerson, secondDog);

        mapOfTwoDogs.addItemWithFirstValue(11, thirdPerson);
        mapOfTwoDogs.addItemWithFirstValue(12, secondPerson);
        // throws exception Three times. mapOfTwoDogs.addItemWithFirstValue(13, secondPerson);

        mapOfTwoDogs.addItemWithSecondValue(111,secondDog);
        mapOfTwoDogs.addItemWithSecondValue(222,fourthDog);
        // throws exception Three times. mapOfTwoDogs.addItemWithSecondValue(333,fourthDog);

        mapOfTwoDogs.removeItemByKey(111);
        // throws exception This ky don´t have values. System.out.println(mapOfTwoDogs.getTwoValues(111));

        // AUX Methods
        System.out.println(mapOfTwoDogs.mostValues());
        System.out.println(mapOfTwoDogs.timesValuesRepeat(1));
        System.out.println(mapOfTwoDogs.getFirstValue(1));
        // throws exception This key don´t have value. System.out.println(mapOfTwoDogs.getSecondValue(87));
        System.out.println("There are values repeated? " + mapOfTwoDogs.valuesRepeated());
    }
}
