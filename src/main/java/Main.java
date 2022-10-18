public class Main {
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

    }
}
