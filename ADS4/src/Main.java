import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//    Scanner scan = new Scanner(System.in);
        Random rand = new Random();
//    Firstly, you can add to List any type of Objects. Then, use each of various methods.
//    -------- Example:
//    MyArrayList list = new MyArrayList();
//    System.out.println("We already started, just enter input data: (For example:(Integer)). Also it works the same way to any type of Object.");
//    int input = scan.nextInt();
////    or String input = scan.nextLine();
//    list.add(input);
//    System.out.println(list.get(0));
//    -------- Example LinkedList:
//    MyLinkedList linkedList = new MyLinkedList();
//    System.out.println("We already started, just enter input data: (For example:(Integer)). Also it works the same way to any type of Object.");
//    int input = scan.nextInt();
//    linkedList.add(input);
//
//    System.out.println("We already started, just enter input data: (For example:(Integer)). Also it works the same way to any type of Object.");
//    int input2 = scan.nextInt();
//    linkedList.add(input);
//
//    System.out.println("We already started, just enter input data: (For example:(Integer)). Also it works the same way to any type of Object.");
//    int input3 = scan.nextInt();
//    linkedList.add(input);
//
//    System.out.println("We already started, just enter input data: (For example:(Integer)). Also it works the same way to any type of Object.");
//    int input4 = scan.nextInt();// or String input = scan.nextLine();
//    linkedList.add(input);
//
//    linkedList.sort();
//    System.out.println(linkedList.get(0));

//    -------- Options:
//    list.get(index);
//    list.size();
//    list.contains(Object);
//    list.add(Object);
//    list.addAt(Object, index);
//    list.remove(Object);
//    list.remove(index);
//    list.clear();
//    list.indexOf(Object);
//    list.lastIndexOf(Object);
//    list.sort();w
        MyHashTable hashTable = new MyHashTable<MyTestingClass, String>();
        for (int i = 0; i < 10; i++) {
            int val = rand.nextInt(0, 9);
            hashTable.put(new MyTestingClass(val), "Student " + val);
        }
        System.out.println(hashTable.getSize());
        for (int i = 0; i < 10; i++) {
            int val = rand.nextInt(0, 9);
            hashTable.put(new MyTestingClass(val), "Student " + val);
        }
        System.out.println(hashTable.getSize());
    }
}