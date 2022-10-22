public class Main {
<<<<<<< Updated upstream
    public static void main(String[] args){

        EpicDoubleHashMap<Integer, String, Integer> item = new EpicDoubleHashMap<>();

        try {
            item.addItemWithFirstValue(2, "Sofia");
            item.addItemWithSecondValue(3,5050);
            item.addItemWithTwoValues(1, "Tomás", 4545);
            item.addItemWithSecondValue(2,15);
        } catch (CheckExistingKey e) {
            throw new RuntimeException(e);
        }


        System.out.println(item.getTwoValues(2));
        try {
            System.out.println(item.getFirstValue(2));
        } catch (CheckNullValue e) {
            throw new RuntimeException(e);
        }
        System.out.println(item.getTwoValues(3));
        System.out.println(item.getTwoValues(1));

        try {
            item.removeItemByKey(3);
        } catch (CheckNullKey e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n Maps after removes: \n");

        System.out.println(item.getTwoValues(2));
        System.out.println(item.getTwoValues(3));
        System.out.println(item.getTwoValues(1));

        System.out.println("\n The First Map contains " + item.getMapWithFirstValue());
=======
    public static void main(String[] args) throws CheckExistingKeyException, CheckThreeSameValuesException, CheckNullValueException, CheckNullKeyException {
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
>>>>>>> Stashed changes

    }
}
