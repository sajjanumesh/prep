package com.pc.stacks;

import java.util.EmptyStackException;

/**
 * Created by zambro on 5/2/17.
 *
 * Implement a stack using an array
 *
 * The requirements of the stack are:
 * 1) the stack has a constructor which accept a number to initialize its size,
 * 2) the stack can hold any type of elements,
 * 3) the stack has a push() and a pop() method.
  */
public class Stack<T> {
    private T[] arr;
    private int top;
    private int size;

    public Stack(int size) {
        if(size <=0)
            throw new IllegalArgumentException();
        this.size = size;
        this.top = -1;
    }

    public T pop() {
        if(top == -1)
            throw new EmptyStackException();

        T result = arr[top];
        arr[top] = null;
        top--;
        return result;
    }

    public void push(T data) {
        if(top == size - 1)
            throw new OutOfMemoryError();
        if(data == null)
            throw new IllegalArgumentException();
        arr[++top] = data;
    }

    public String toString() {
        if(size == 0)
            return null;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++)
            sb.append(arr[i].toString()+",");
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

}
