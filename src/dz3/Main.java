package Aston.dz3;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> stringMyArrayList = new MyArrayList<>();
        for (int i = 0; i < 11; i++)
            stringMyArrayList.add("s" + i);
        System.out.println("Добавление в список 11 элементов:");
        stringMyArrayList.forEach(s -> System.out.print(s + " "));
        System.out.println("\nИзвлечение элемента №2:");
        System.out.println(stringMyArrayList.get(1));
        stringMyArrayList.remove(1);
        System.out.println("Значение элемента №2 после удаления предыдущего:");
        System.out.println(stringMyArrayList.get(1));

        MyArrayList<String> intMyArrayList = new MyArrayList<>();
        intMyArrayList.add("1");
        intMyArrayList.add("3");
        intMyArrayList.add("2");
        System.out.println("Создание нового списка из 3 элементов:");
        intMyArrayList.forEach(s -> System.out.print(s + " "));
        stringMyArrayList.addAll(intMyArrayList);
        System.out.println("\nДобавление в 1й список всех элементов из 2го списка:");
        stringMyArrayList.forEach(s -> System.out.print(s + " "));
        System.out.println();
        stringMyArrayList.sort();
        System.out.println("Сортировка списка:");
        stringMyArrayList.forEach(s -> System.out.print(s + " "));
        System.out.println();
        MyArrayList<String> arrayList = new MyArrayList<>(intMyArrayList);
        System.out.println("Создание списка в конструкторе из другого списка:");
        arrayList.forEach(s -> System.out.print(s + " "));
        System.out.println();
        MyArrayList.sort(arrayList);
        System.out.println("Сортировка списка статическим методом:");
        arrayList.forEach(s -> System.out.print(s + " "));

    }
}
