package com.bayviewglen.queue;

public class driver {
	public static void main(String[] args) {

		IntArrayQueue aQ = new IntArrayQueue();
        aQ.enqueue(3);
        aQ.enqueue(4);
        aQ.enqueue(5);
        System.out.println(aQ.dequeue());
        System.out.println(aQ.peek());
        aQ.clear();
        System.out.print(aQ.isEmpty());
        
        System.out.println();
        IntLinkedListQueue nQ = new IntLinkedListQueue();
        nQ.enqueue(3);
        nQ.enqueue(4);
        nQ.enqueue(5);
        System.out.println(nQ.dequeue());
        System.out.println(nQ.peek());
        nQ.clear();
        System.out.print(nQ.isEmpty());
	}

}
