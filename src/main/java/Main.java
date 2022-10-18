
public class Main{
    public static void main(String[] args){

        EpicDoubleHashMap<Integer, String, Integer> item = new EpicDoubleHashMap<>();

        item.addItemWithFirstValue(2, "Chau");
        item.addItemWithSecondValue(3,5050);
        item.addItemWithTwoValues(1, "Hola", 4545);
        item.getTwoValues(1);



    }
}


