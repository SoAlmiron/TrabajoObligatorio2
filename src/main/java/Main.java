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
<<<<<<< HEAD
        Person secondPerson = new Person("Alex");
        Person thirdPerson =new Person("Flor");
        Person fourthPerson = new Person("Lucia");

        Dog firstDog = new Dog("Tobi", 10);
        Dog secondDog = new Dog("Tobi", 10);
        Dog thirdDog = new Dog("Teo", 8);
        Dog fourthDog = new Dog("Lula", 12);
=======
        Person secondPerson = new Person("zack");
        Dog firstDog = new Dog("Tobi", 10);
        Dog fourthDog = new Dog("Teo", 12);

>>>>>>> 185a5e5b98e3e1999b19f14e6f9757de55077df7

        mapOfTwoDogs.addItemWithTwoValues(1, firstPerson, firstDog);
        mapOfTwoDogs.addItemWithTwoValues(2, firstPerson, thirdDog);
        // throws exception Three times mapOfTwoDogs.addItemWithTwoValues(3, firstPerson, secondDog);

<<<<<<< HEAD
        mapOfTwoDogs.addItemWithFirstValue(11, secondPerson);
        mapOfTwoDogs.addItemWithFirstValue(12, secondPerson);
        mapOfTwoDogs.addItemWithFirstValue(32, fourthPerson);
        // throws exception Three times. mapOfTwoDogs.addItemWithFirstValue(13, secondPerson);
=======
        try {
            mapOfTwoDogs.addItemWithTwoValues(1, firstPerson, firstDog);
            mapOfTwoDogs.addItemWithTwoValues(2, firstPerson, firstDog);
            mapOfTwoDogs.addItemWithTwoValues(3, firstPerson, firstDog);
            mapOfTwoDogs.addItemWithFirstValue(5, secondPerson);
            mapOfTwoDogs.addItemWithFirstValue(10,firstPerson);

           //System.out.println(mapOfTwoDogs.getFirstValue(00));
>>>>>>> 185a5e5b98e3e1999b19f14e6f9757de55077df7

        mapOfTwoDogs.addItemWithSecondValue(111, secondDog);
        mapOfTwoDogs.addItemWithSecondValue(222,fourthDog);
        mapOfTwoDogs.addItemWithSecondValue(48, fourthDog);
        // throws exception Three times. mapOfTwoDogs.addItemWithSecondValue(333,fourthDog);

<<<<<<< HEAD
        mapOfTwoDogs.removeItemByKey(111);
        // throws exception This ky don´t have values. System.out.println(mapOfTwoDogs.getTwoValues(111));

        // AUX Methods
        System.out.println(mapOfTwoDogs.mostValues());
        System.out.println(mapOfTwoDogs.timesValuesRepeat(1));
        System.out.println(mapOfTwoDogs.timesValuesRepeat(222));
        System.out.println(mapOfTwoDogs.getFirstValue(11));
        System.out.println(mapOfTwoDogs.getSecondValue(2));
        System.out.println(mapOfTwoDogs.getTwoValues(1));
        // throws exception This key don´t have values. System.out.println(mapOfTwoDogs.timesValuesRepeat(87));
        System.out.println("There are values repeated? " + mapOfTwoDogs.valuesRepeated());
=======
            System.out.println(mapOfTwoDogs.getTwoValues(1));
            //mapOfTwoDogs.getFirstValue(5);
            //mapOfTwoDogs.addItemWithSecondValue(5, fourthDog);
        } catch (CheckExistingKeyException | CheckThreeSameValuesException | CheckNullValueException |
                 CheckNullKeyException e) {
            throw new RuntimeException(e);
        }

        // AUX Methods
        System.out.println(mapOfTwoDogs.mostValues());
        System.out.println(mapOfTwoDogs.timesValuesRepeat(3));
        System.out.println("There are values repeated? " + mapOfTwoDogs.valuesRepeated());
        System.out.println(mapOfTwoDogs.getMapWithFirstValue());


>>>>>>> 185a5e5b98e3e1999b19f14e6f9757de55077df7
    }
}
