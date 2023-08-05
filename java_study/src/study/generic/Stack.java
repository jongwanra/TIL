package study.generic;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if(size == 0) throw new EmptyStackException();

        // push에서 E 타입만 허용하므로 이 형변환은 안전한다.
        E result = (E) elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public E peek() {
        if(size == 0) return null;
        System.out.println("elements[size - 1] = " + elements[size - 1]);
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1) ;
        }
    }

    public void printStack() {
        for(E e: this.elements) {
            System.out.print(e + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < 5; i++) {
            stack.push(String.valueOf(i));
        }

        while (!stack.isEmpty() && stack.peek() != null) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
