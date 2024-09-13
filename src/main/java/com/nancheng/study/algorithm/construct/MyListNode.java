package com.nancheng.study.algorithm.construct;

/**
 * 双链表
 * @author: NanCheng
 * @email: nanchengqj@gmail.com
 * @date: 2024/9/12
 */
public class MyListNode<E> {
    private Integer size;
    private final Node virtualHead;
    private final Node virtualTail;

    private static class Node<E>{
        private E data;
        private Node<E> head;
        private Node<E> next;
        public Node(E val,Node<E> head,Node<E> tail){
            this.data = val;
            this.head = head;
            this.next = tail;
        }
        public Node(E val){
            this.data = val;
        }
    }
    public MyListNode(){
        virtualHead = null;
        virtualTail = null;
        size = 0;
    }
    public MyListNode(E data){
        if (data == null){
            virtualHead = null;
            virtualTail = null;
            size = 0;
            return;
        }
        virtualHead = new Node<>(null);
        virtualTail = new Node<>(null);
        Node<E> node = new Node<>(data,null,null);
        virtualHead.next = node;
        virtualTail.head = node;
        this.size = 1;
    }

    public MyListNode(E[] data){
        if (data == null || data.length == 0){
            virtualHead = null;
            virtualTail = null;
            size = 0;
            return;
        }
        virtualHead = new Node<>(null);
        virtualTail = new Node<>(null);
        Node<E> head = new Node<>(data[0],null,null);
        Node<E> current =head;
        for (int i = 1; i < data.length; i++) {
            Node<E> temp = new Node<>(data[i],current,null);
            current.next = temp;
            current = temp;
        }
        virtualHead.next = head;
        virtualTail.head = current;
        this.size = data.length;
    }

    public MyListNode<E> arr2Node(E[] arr){
        MyListNode<E> newList = new MyListNode<>(arr);
        if (newList.virtualHead == null || newList.virtualTail == null) {
            return this;
        }
        if (this.virtualHead == null || this.virtualTail == null){
            return newList;
        }
        this.virtualTail.head.next = newList.virtualHead.next;
        newList.virtualHead.head = this.virtualTail.head;
        this.virtualTail.head = newList.virtualTail.head;
        this.size += arr.length;
        return this;
    }

    public MyListNode<E> addFirst(E val){
        if (this.virtualHead == null){
            return new MyListNode<>(val);
        }
        Node<E> node = new Node<E>(val,null,this.virtualHead.next);
        this.virtualHead.next.head = node;
        this.virtualHead.next = node;
        return this;
    }
    public MyListNode<E> addLast(E val){
        if (this.virtualTail == null){
            return new MyListNode<>(val);
        }
        Node<E> node = new Node<E>(val, this.virtualTail.head, null);
        this.virtualTail.head.next = node;
        this.virtualTail.head = node;
        return this;
    }
    public MyListNode<E> add(Integer index,E val){
        checkIndex(index);
        if (index == 0){
            addFirst(val);
        }
        if (index.equals(size)){
            addLast(val);
        }
        if (index > size/2){
            // 从后面往前面
        }else {
            // 从前面往后面找
        }
        return this;
    }
    private void checkIndex(Integer index){
        if (size < index){
            throw new IndexOutOfBoundsException(index + " out of " + size);
        }
    }

}
