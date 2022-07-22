package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().runSearch();
    }

    private void runSearch() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,7,9,10));
        int k = Collections.binarySearch(list, 0);
        System.out.println(k);
    }

    private void runSorts() {
        List<Person> people = new ArrayList<>(List.of(
                new Person("Vasya", 25),
                new Person("Petya", 24),
                new Person("Katya", 21),
                new Person("Katya", 25),
                new Person("Vova", 27)
        ));
        //people.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        people.sort(Comparator.naturalOrder());
        for (Person person : people) {
            System.out.println(person);
        }
    }

    private void runAlgorithms() {
        List<Integer> list1 = new ArrayList<>(List.of(1, 5, 2, 3, 7, 6, 5, 10));
        List<Integer> list2 = new ArrayList<>(List.of(17));
        Collections.copy(list1.subList(3,4), list2);
        System.out.println(list1);
        Collections.fill(list1.subList(3,7), 11);
        System.out.println(list1);
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Random rnd = new Random();
        Collections.shuffle(list.subList(3,7));
        System.out.println(list);
    }

    private void runPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>(List.of(10, 5, 3, 2, 7, 6, 5, 1));
        System.out.println(queue);
        queue.add(4);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.offer(1);
        System.out.println(queue);
        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
    }

    private void runCountWords() {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("file.txt"))) {
            Map<String, Integer> map = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                map.merge(line, 1, Integer::sum);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void runSet() {
        Set<Integer> set = new HashSet<>(List.of(1, 5, 2, 3, 7, 6, 0, 11, 12, 17, 33));
        System.out.println(set);
        System.out.println("len = " + set.size());
        set.add(16);
        System.out.println(set);
        System.out.println("len = " + set.size());
        set.add(15);
        System.out.println(set);
        System.out.println("len = " + set.size());
    }

    private void runList() {
        List<Integer> list = new ArrayList<>(List.of(1, 5, 2, 3, 7, 6, 5, 10));
        list.add(17);
//        list.remove(Integer.valueOf(5));
        System.out.println(list);
        List<Integer> subList = list.subList(3,7);
        System.out.println(subList);
        subList.set(2, 66);
        System.out.println(subList);
        subList.add(77);
        System.out.println(list);
        System.out.println(subList.getClass());
        System.out.println(subList.get(3));
//        List<String> stringList = Arrays.asList("first", "second", "third", "one more", "last");
        List<String> stringList = List.of("first", "second", "third", "one more", "last");
        stringList.set(1, "qaz");
        System.out.println(stringList);
        stringList.add("xswq");
        System.out.println(stringList.getClass());
    }

    private void run() {
        Collection<String> c = new ArrayList<>(List.of("first", "second", "third", "one more", "last"));
        System.out.println(c);
        //String[] array = new String[0];
        String[] array = c.toArray(new String[0]);
        // Object <- String
        // Object[] ? String[]
        for (String s : array) {
            System.out.println(s + " - " + (s == null ? "null": s.length()));
        }
        c.add("qwe");


    }
}
