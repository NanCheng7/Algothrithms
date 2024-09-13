package com.nancheng.study.algorithm.construct;

import java.util.NoSuchElementException;

/**
 * 动态数组
 * @author: NanCheng
 * @email: nanchengqj@gmail.com
 * @date: 2024/9/12
 */
public class MyArrayList<E> {
    private E[] contain;
    private Integer size;
    private final Integer INIT_CAPACITY = 10;
    public MyArrayList(){
        contain =(E[]) new Object[INIT_CAPACITY];
        size = 0;
    }
    public MyArrayList(Integer initCapacity){
        contain =(E[]) new Object[initCapacity];
        size = 0;
    }

    public Integer size(){
        return size;
    }
    public void addLast(E e){
        if (size*1.5 >= contain.length){
            resize(contain.length*2);
        }
        contain[size++] = e;
    }
    private void resize(Integer capacity){
       E[] data = (E[]) new Object[capacity];
        for (int i = 0; i < contain.length; i++) {
            data[i] = contain[i];
        }
        contain = data;
    }
    public void add(Integer index,E e){
        checkInsertIndex(index);
        if (size*1.5 >= contain.length){
            resize(contain.length*2);
        }
        for (Integer i = size; i > index; i--) {
            contain[i] = contain[i-1];
        }
        contain[index] = e;
        size++;
    }
    public E get(Integer index){
        checkIndex(index);
        return contain[index];
    }
    public E set(Integer index,E e){
        checkIndex(index);
        contain[index] = e;
        return e;
    }

    private void checkInsertIndex(Integer index) {
        if (index < 0 || index>size){
            throw new IndexOutOfBoundsException(index + " out of "+ size);
        }
    }

    public void addFirst(E e){
        add(0,e);
    }
    public E removeLast(){
        if (size == 0){
            throw new NoSuchElementException();
        }
        E e = contain[size-1];
        contain[size-1] = null;
        return e;
    }
    public E remove(Integer index){
        checkIndex(index);
        E e = contain[index];
        for (int i = index; i < size; i++){
            contain[i] = contain[i+1];
        }
        contain[size-1] = null;
        size--;
        if (size*4 < contain.length){
            resize(contain.length/2);
        }
        return e;
    }


    private void checkIndex(Integer index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException(index+" out of "+size);
        }
    }

}
