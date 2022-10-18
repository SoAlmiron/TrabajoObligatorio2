public class Main {
    public static void main(String[] args){

        EpicDoubleHashMap<Integer, Integer, String> item = new EpicDoubleHashMap<>();
        item.addItemWithSecondValue(2,"Sofia");
        item.addItemWithFirstValue(3,5);
        item.addItemWithTwoValues(1,6,"Martin");

        System.out.println(item.toString(2));
        System.out.println(item.toString(3));
        System.out.println(item.toString(1));

        item.removeItemByKey(3);

        System.out.println("Lista después de items removidos: \n");

        System.out.println(item.toString(2));
        System.out.println(item.toString(3));
        System.out.println(item.toString(1));


    }
}
