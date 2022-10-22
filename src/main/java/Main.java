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
        Person fourthPerson = new Person("Lucia");

        Dog firstDog = new Dog("Tobi", 10);
        Dog secondDog = new Dog("Tobi", 10);
        Dog thirdDog = new Dog("Teo", 8);
        Dog fourthDog = new Dog("Lula", 12);

        mapOfTwoDogs.addItemWithTwoValues(1, firstPerson, firstDog);
        mapOfTwoDogs.addItemWithTwoValues(2, firstPerson, thirdDog);
        // throws exception Three times mapOfTwoDogs.addItemWithTwoValues(3, firstPerson, secondDog);

        mapOfTwoDogs.addItemWithFirstValue(11, secondPerson);
        mapOfTwoDogs.addItemWithFirstValue(12, secondPerson);
        mapOfTwoDogs.addItemWithFirstValue(32, fourthPerson);
        // throws exception Three times. mapOfTwoDogs.addItemWithFirstValue(13, secondPerson);

        mapOfTwoDogs.addItemWithSecondValue(111,secondDog);
        mapOfTwoDogs.addItemWithSecondValue(222,fourthDog);
        // throws exception Three times. mapOfTwoDogs.addItemWithSecondValue(333,fourthDog);

        mapOfTwoDogs.removeItemByKey(111);
        // throws exception This ky don´t have values. System.out.println(mapOfTwoDogs.getTwoValues(111));

        // AUX Methods
        System.out.println(mapOfTwoDogs.mostValues());
        System.out.println(mapOfTwoDogs.timesValuesRepeat(1));
        System.out.println(mapOfTwoDogs.timesValuesRepeat(222));
        System.out.println(mapOfTwoDogs.getFirstValue(1));
        System.out.println(mapOfTwoDogs.getSecondValue(2));
        // throws exception This key don´t have values. System.out.println(mapOfTwoDogs.timesValuesRepeat(87));
        System.out.println("There are values repeated? " + mapOfTwoDogs.valuesRepeated());
    }
}
