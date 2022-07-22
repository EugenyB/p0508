package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().runSet();
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
