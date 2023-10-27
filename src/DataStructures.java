import java.util.*;

public class DataStructures {
    public static void main(String[] args) {
        arrayExample();
        arrayExample2();
        arrayExample3();
        multidimentionalArray();
        arrayList();
        arrayListLoop();
        linkedList();
        linkedList2();
        linkedList3();
        queue();
        stack();
        hashSet();
        hashSetLoop();
        hashSetExample();
        hashMap();
        hashMap2();
        hashMap3();
    }

    private static void arrayExample() {

        String[] carBrands = {"Audi", "Bmw", "Volvo", "Mercedes"};
        int[] evenNumbers = {2, 4, 6, 8, 10};
        double[] degrees = {0, 0.5, 1, 1.5, 2, 2.5};

        System.out.println(carBrands[0]);
        System.out.println(evenNumbers[2]);
        System.out.println(degrees[5]);
        System.out.println(carBrands.length);
        System.out.println(evenNumbers.length);
        System.out.println(degrees.length);
        System.out.println();
        System.out.println();
    }


    private static void arrayExample2() {

        String[] cars = new String[3];
        cars[0] = "Volvo";
        cars[1] = "Bmw";
        cars[2] = "Mercedes";
        System.out.println(cars[1]);
        System.out.println();
        System.out.println();
    }

    private static void arrayExample3() {

        String[] carBrands = {"Audi", "Bmw", "Volvo", "Mercedes"};
        carBrands[1] = "Karuca";

        for (int i = 0; i < carBrands.length; i++) {
            System.out.println(carBrands[i]);
        }
        System.out.println();
        System.out.println();
    }

    private static void multidimentionalArray() {

        int[][] arr = new int[3][3];//3 row and 3 column

        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        arr[2][0] = 7;
        arr[2][1] = 8;
        arr[2][2] = 9;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(arr[i][j]);
            }
        }
        System.out.println();
        System.out.println();
    }

    private static void arrayList() {

        ArrayList<String> cars = new ArrayList<String>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        System.out.println(cars);
        System.out.println(cars.get(0));
        System.out.println();
        System.out.println();
    }

    private static void arrayListLoop() {

        ArrayList<String> cars = new ArrayList<String>();

        cars.add("Volvo"); //adding element in ArrayList
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        System.out.println(cars);

        cars.set(1, "Mercedes"); //change element
        cars.remove(2);//Remove element

        System.out.println(cars);
        System.out.println(cars.get(0) /*Aceess element*/);


        //Loop through ArrayList
        for (String i : cars) {
            System.out.println(i);
        }

        System.out.println();
        System.out.println();
    }

    private static void linkedList() {

        LinkedList<String> cars = new LinkedList<String>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        System.out.println(cars);
        System.out.println(cars.get(0));

        System.out.println();
        System.out.println();
    }

    private static void linkedList2() {

        LinkedList<String> cars = new LinkedList<String>();

        cars.add("Volvo"); //adding element
        cars.addFirst("BMW"); //adding on first position
        cars.addLast("Ford"); //adding on last position
        cars.add(2, "Mazda"); //adding on 3-rd position

        System.out.println(cars);
        System.out.println(cars.get(1));
        System.out.println(cars.getFirst());
        System.out.println(cars.getLast());

        System.out.println();
        System.out.println();
    }

    private static void linkedList3() {

        LinkedList<String> cars = new LinkedList<String>();

        cars.add("Volvo"); //adding element
        cars.addFirst("BMW"); //adding on first position
        cars.addLast("Ford"); //adding on last position
        System.out.println(cars);
        cars.add(2, "Mazda"); //adding on 3-rd position
        System.out.println(cars);
        cars.remove(); //removes first element
        System.out.println(cars);
        cars.removeFirst(); //removes first element
        System.out.println(cars);
        cars.removeLast(); //removes last element
        System.out.println(cars);
        cars.removeAll(cars); //remove all elements
        System.out.println(cars);
        boolean exists = cars.contains("BMW");

        System.out.println(cars);
        System.out.println(exists);

        System.out.println();
        System.out.println();
    }

    private static void queue() {

        Queue<String> pq = new PriorityQueue<>();

        pq.add("TestA");
        pq.add("TestB");
        pq.add("TestC");
        pq.add("TestD");
        pq.add("TestE");

        System.out.println(pq);

        pq.remove(); // removes the first element
        System.out.println(pq);

        for (String i : pq) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println();
    }

    private static void stack() {

        Stack<String> elements = new Stack<>();

        // Pushing new items to the Stack

        elements.push("Test1");
        elements.push("Test2");
        elements.push("Test3");
        elements.push("Test4");
        System.out.println(elements);
        elements.pop();
        System.out.println(elements);
        elements.push("Test5");
        System.out.println("Stack => " + elements);

        System.out.println();
        System.out.println();
    }


    private static void hashSet() {

        //Creating HashSet and adding elements
        HashSet<String> set = new HashSet();

        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        set.add("Two");
        set.add("Two");
        set.add("Two");

        System.out.println(set);

        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println(set.size());

        System.out.println();
        System.out.println();
    }

    private static void hashSetLoop() {

        HashSet<String> set = new HashSet();

        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        set.add("Two");
        set.add("Two");
        set.add("Two");

        for (String i : set) {
            System.out.println(i);
        }
        System.out.println(set.size());

        System.out.println();
        System.out.println();
    }

    private static void hashSetExample() {

        HashSet<String> set=new HashSet<String>();
        set.add("Niki");
        set.add("Ivan");
        set.add("Georgi");
        set.add("Stoyan");
        System.out.println("An initial list of elements: "+set);

        //Removing specific element from HashSet
        set.remove("Ivan");
        System.out.println("After invoking remove(object) method: "+set);
        HashSet<String> set1=new HashSet<String>();

        //Adds unique values from set1 to set
        set1.add("Ekaterina");
        set1.add("Maya");
        set.addAll(set1);
        System.out.println("Updated List: "+set);

        //Removing all the new elements from HashSet
        set.removeAll(set1);
        System.out.println("After invoking removeAll() method: "+set);

        //Removing elements on the basis of specified condition
        set.removeIf(str->str.contains("Nik"));
        System.out.println("After invoking removeIf() method: "+set);

        //Removing all the elements available in the set
        set.clear();
        System.out.println("After invoking clear() method: "+set);

        System.out.println();
        System.out.println();
    }

    private static void hashMap() {

        //Creating HashMap
        HashMap<Integer,String> map=new HashMap<Integer,String>();

        //Put elements in Map
        map.put(1,"Mango");
        map.put(2,"Apple");
        map.put(3,"Banana");
        map.put(4,"Grapes");

        System.out.println("Iterating Hashmap...");

        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        System.out.println();
        System.out.println();
    }

    private static void hashMap2() {

        //Creating HashMap
        HashMap<Integer,String> map=new HashMap<Integer,String>();

        //Put elements in Map
        map.put(1,"Mango");
        map.put(2,"Apple");
        map.put(3,"Banana");
        map.put(4,"Grapes");

        for (Integer i : map.keySet()){
            System.out.println(i +" "+map.get(i));
        }
        System.out.println();
        System.out.println();
    }

    private static void hashMap3() {

        HashMap<Integer,String> hm=new HashMap<Integer,String>();
        hm.put(100,"Ivan");
        hm.put(101,"Georgi");
        hm.put(102,"Stoyan");

        System.out.println("Initial list of elements:");

        for (Map.Entry m:hm.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }

        System.out.println("Updated list of elements:");

        hm.replace(102, "Miroslav");

        for(Map.Entry m:hm.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }

        System.out.println("Updated list of elements:");

        hm.replace(101, "Georgi", "Anton");
        for(Map.Entry m:hm.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }

        System.out.println("Updated list of elements:");

        hm.replaceAll((k,v) -> "Asen");

        for(Map.Entry m:hm.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }
        System.out.println();
        System.out.println();
    }
}