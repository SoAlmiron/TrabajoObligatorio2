import Classes.Dog;
import Classes.Person;
import CustomExceptions.CheckExistingKeyException;
import CustomExceptions.CheckNullKeyException;
import CustomExceptions.CheckNullValueException;
import CustomExceptions.CheckThreeSameValuesException;
import Utilities.EpicDoubleHashMap;

public class Main {
    public static void main(String[] args) {
        EpicDoubleHashMap<Integer, Person, Dog> mapOfTwoDogs = new EpicDoubleHashMap<>();
        Person firstPerson = new Person("Pepe");
        Person secondPerson = new Person("zack");
        Dog firstDog = new Dog("Tobi", 10);
        Dog fourthDog = new Dog("Teo", 12);



        try {
            mapOfTwoDogs.addItemWithTwoValues(1, firstPerson, firstDog);
            mapOfTwoDogs.addItemWithTwoValues(2, firstPerson, firstDog);
            mapOfTwoDogs.addItemWithTwoValues(3, firstPerson, firstDog);
            mapOfTwoDogs.addItemWithFirstValue(5, secondPerson);
            mapOfTwoDogs.addItemWithFirstValue(10,firstPerson);

           //System.out.println(mapOfTwoDogs.getFirstValue(00));

            mapOfTwoDogs.removeItemByKey(2);

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


    }
}
