import java.util.*;

public class DataStructuresMosh {
    public static void main(String[] args) {
        log();
        loop();
        loop2();
        arrayList();
        linkedList();
    }

    private static void log() {

        int[] numbers = {3,7,8};

        System.out.println(numbers[0]);

        System.out.println();
        System.out.println();
    }

    private static void loop() {

        int[] numbers = {3,7,8};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println();
        System.out.println();
    }

    private static void loop2() {

        int[] numbers = {3,7,8};

        for (int number : numbers) {
            System.out.println(number);
        }

        System.out.println();
        System.out.println();
    }

    private static void arrayList() {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);

        list.remove(0);

        System.out.println(list);

        System.out.println(list.indexOf(30));

        System.out.println();
        System.out.println();
    }

    private static void linkedList() {

        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);

        System.out.println(list);

        list.removeLast();

        System.out.println(list);
        System.out.println(list.contains(10));
        System.out.println(list.indexOf(10));
        System.out.println(list.size());

        var array = list.toArray();
        System.out.println(Arrays.toString(array));

        System.out.println();
        System.out.println();
    }
}