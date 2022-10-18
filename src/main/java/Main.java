public class Main {
    public static void main(String[] args){

        EpicDoubleHashMap<Integer, String, Integer> item = new EpicDoubleHashMap<>();

        item.addItemWithFirstValue(2, "Sofia");
        item.addItemWithSecondValue(3,5050);
        item.addItemWithTwoValues(1, "Tomás", 4545);

        System.out.println(item.getTwoValues(2));
        System.out.println(item.getTwoValues(3));
        System.out.println(item.getTwoValues(1));

        item.removeItemByKey(3);

        System.out.println("\n Maps after removes: \n");

        System.out.println(item.getTwoValues(2));
        System.out.println(item.getTwoValues(3));
        System.out.println(item.getTwoValues(1));

        System.out.println("\n Contains the First Map" + item.getMapWithFirstValue());

    }
}
