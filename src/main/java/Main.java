import CustomExceptions.CheckExistingKeyException;
import CustomExceptions.CheckNullKeyException;
import CustomExceptions.CheckNullValueException;
import CustomExceptions.CheckThreeSameValuesException;

public class Main{
    public static void main(String[] args) throws CheckNullValueException {

        EpicDoubleHashMap<Integer, String, Integer> item = new EpicDoubleHashMap<>();

        // ADD method
        try {
            // ????????????????????????
            item.addItemWithFirstValue(1, "Sofia");
            item.addItemWithFirstValue(2, "Sofi");
            item.addItemWithFirstValue(3, "Sofi");
            item.addItemWithFirstValue(4, "Sofi");
            // Example Exception c) item.addItemWithFirstValue(4, "Sofi");

            item.addItemWithSecondValue(10,5050);
            item.addItemWithSecondValue(20,5050);
            item.addItemWithSecondValue(30,5050);

            item.addItemWithTwoValues(100, "Tomás", 4545);
            item.addItemWithTwoValues(200, "Tomás", 4545);
            item.addItemWithTwoValues(300, "Tomás", 4545);

        } catch (CheckExistingKeyException | CheckThreeSameValuesException  er) {
            throw new RuntimeException(er);
        }

        // GET method
        try {
            System.out.println(item.getFirstValue(1));
            System.out.println(item.getSecondValue(10));
            System.out.println(item.getTwoValues(100));
            //Example Exception b) System.out.println(item.getFirstValue(8));
        } catch (CheckNullValueException e) {
            throw new RuntimeException(e);
        }

        // Remove method
        try {
            item.removeItemByKey(1);
            //Example Exception b) item.removeItemByKey(8);
        } catch (CheckNullKeyException e) {
            throw new RuntimeException(e);
        }

        System.out.println(item.getTwoValues(100));

        // AUX Methods
        System.out.println(item.mostValues());
        System.out.println(item.timesValuesRepeat(4));
        System.out.println("There are values repeated? " +item.areValuesReapeated);

    }
}


