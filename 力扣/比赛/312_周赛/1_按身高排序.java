import java.util.Arrays;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++)
            persons[i] = new Person(names[i], heights[i]);
        Arrays.sort(persons, (p1, p2) -> p2.height - p1.height);
        String[] res = new String[n];
        for (int i = 0; i < n; i++)
            res[i] = persons[i].name;
        return res;
    }

    class Person {
        String name;
        int height;

        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}