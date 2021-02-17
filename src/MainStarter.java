import com.godeltech.module03_pt313.MultidimArray;

import java.util.Iterator;

public class MainStarter {

    public static void main(String[] args) {
        //add Integer types;
        MultidimArray<Integer> integers = new MultidimArray<>(new Integer[1][3]);
        integers.setStatementXY(0, 2, 159);
        System.out.println(integers.getStatementXY(0, 2));

        //add String types;
        MultidimArray<String> strings = new MultidimArray<>(new String[1][3]);
        strings.setStatementXY(0, 1, "Hello!");
        System.out.println(strings.getStatementXY(0, 1));

        //add custom types;
        MultidimArray<Person> people = new MultidimArray<>(new Person[1][2]);
        people.setStatementXY(0, 0, new Person("Georg", 18));
        for (int i = 0; i < people.size(); i++) {
            for (int j = 0; j < people.size(); j++) {
                System.out.println(people.getStatementXY(i,j));
            }
        }
//        //add trough implemented interface;
//        Collection<Integer> collection = new MultidimArray<>(new Integer[1][5]);
//        collection.add(456);
//        System.out.println(collection.toString());

        Iterator iterator = integers.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}