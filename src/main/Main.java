package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(findMinimalPath("/foo/bar/../loo/../.."));
        System.out.println(findMinimalPath("/foo/../.."));
        System.out.println(findMinimalPath("/foo/./bar///.."));
        System.out.println(findMinimalPath("/foo///./loo/../bar/."));

    }

    private static String findMinimalPath(String s) {
        String[] strings = s.split("/");

        List<String> stringList = new ArrayList<>();

        for(String str : strings) {
            if(str.isEmpty() || str.equals("."))
                continue;

            if(!str.equals("..")) {
                stringList.add(str);
            } else if(!stringList.isEmpty()) {
                stringList.remove(stringList.size() -1);
            }
        }

        if(stringList.isEmpty())
            return "/";

        return "/" + String.join("/", stringList);
     }


}
