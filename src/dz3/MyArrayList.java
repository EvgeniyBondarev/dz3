package Aston.dz3;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class MyArrayList<T> implements Iterable<T>{
    private int size = 10;
    private int length;
    private boolean isSorted;
    private T[] array;

    public MyArrayList() {
        array = (T[]) new Object[size];
    }
    public MyArrayList(MyArrayList<T> myArrayList){
        this();
        this.addAll(myArrayList);
    }

    public void add(T element){
        if (length >= size) {
            size *= 1.5;
            T[] arrayNew = (T[]) new Object[size];
            System.arraycopy(array,0, arrayNew,0, array.length);
            array = arrayNew;
        }
        array[length] = element;
        length++;
    }
    public T get(int index){
        if(index >= length) throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }
    public void remove(int index){
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        length--;
    }

    public void addAll(MyArrayList<T> list){
        for (T t : list) this.add(t);
    }

    public <R extends Comparable<R>> void sort(){
        if(!isSorted) {
            int indexMin = 0;
            for (int i = 0; i < length - 1; i++){
                R min = (R) array[i];
                int j = i + 1;
                for (; j < length; j++){
                    if (min.compareTo((R) array[j]) > 0){
                        min = (R) array[j];
                        indexMin = j;
                    }
                }
                array[indexMin] = array[i];
                array[i] = (T) min;
            }
            isSorted = true;
        }
    }
    public static <T> void sort(MyArrayList<T> myArrayList) {
        myArrayList.sort();
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int it = 0;
            @Override
            public boolean hasNext() {
                return it < length;
            }

            @Override
            public T next() {
                return array[it++];
            }

            @Override
            public void remove() {
                Iterator.super.remove();
            }
        };
    }
}
