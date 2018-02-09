
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hungle
 */
public class Deque<Item> implements Iterable<Item> {

    private Item[] s;
    private int first;  //First place has value in the array 
    private int last;   //Last place has value in the array 
    private int N;      //Number of element in the array

    public Deque() {
        s = (Item[]) new Object[1];  //Initialize the string
        first = last = 0;   //s[first] = s[last] = s[0] = null; 
        s[first] = null;
        N = 0;              //No element when init
    }

    public boolean isEmpty() {
        return s[first] == null;    //If s[first] == null => isEmpty
    }

    public int size() {
        return N;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Illegal Argument Exception");
        }
        if (isEmpty()) {
            s[first] = item;    //The array is empty, set s[first] = item, do not decrease first
            N++;
        } else if (first == 0) {     //Before first == 0
            DoubleTheSize();
            WriteToFront(item);
        } else {
            WriteToFront(item);
        }
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Illegal Argument Exception");
        }
        if (isEmpty()) {
            s[last] = item;    //The array is empty, set s[last] = item, do not increase first
            N++;
        } else if (last == s.length - 1) {     //After last is nothing
            while (last == s.length - 1) {
                DoubleTheSize();
            }

            //System.out.println(isEmpty() + "first " + first + " last: " + last + " N: " + size());
            WriteToBack(item);
        } else {
            WriteToBack(item);
        }
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item thisItem = s[first];
        s[first] = null;

        //Check that first is not the only element in the array
        if (N == 1) {
            N--;
            return thisItem;
        } else if (first + 1 == s.length) {
            N--;
            SmallerArray();
            return thisItem;
        } else {
            first++;    //first = 2 last = 2
            N--;        // N = 1
            SmallerArray();
        }

        return thisItem;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item thisItem = s[last];
        s[last] = null;

        //Check that first is not the only element in the array
        if (N == 1) {
            N--;
            return thisItem;
        } else if (last == first) {
            N--;
            SmallerArray();
            return thisItem;
        } else {
            last--;    //first = 2 last = 2
            N--;        // N = 1
            SmallerArray();
        }

        return thisItem;
    }

    private void DoubleTheSize() {
        Item[] copy = (Item[]) new Object[s.length * 2];

        int copyFirst = (int) Math.ceil(copy.length / 2.0 - N / 2.0);

        for (int i = 0; i < N; i++) {
            copy[copyFirst + i] = s[first + i];
        }
        first = copyFirst;
        last = copyFirst + N - 1;
        s = copy;
    }

    private void WriteToFront(Item item) {
        first--;
        s[first] = item;
        N++;
    }

    private void WriteToBack(Item item) {
        last++;
        s[last] = item;
        N++;
    }

    private void SmallerArray() {
        if (N <= s.length / 4 && N != 0) {
            Item[] copy = (Item[]) new Object[s.length / 2];
            int copyFirst = copy.length / 2 - N / 2;
            for (int i = 0; i < N; i++) {
                copy[copyFirst + i] = s[first + i];
            }
            s = copy;
            first = copyFirst;
            last = first + N - 1;
        }
    }

    private void print() {
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);

        Iterator itor = deque.iterator();
        while (itor.hasNext()) {
            Object item = itor.next();
            StdOut.println("itor: " + item);
        }
        StdOut.println("has next: " + itor.hasNext());

        deque.print();
        System.out.println(deque.isEmpty() + " first: " + deque.first + " last: " + deque.last + " N: " + deque.size());
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        int curr = first - 1;

        @Override
        public boolean hasNext() {
            int thisCurr = curr + 1;
            if (thisCurr >= s.length) 
                return false; 
            return s[thisCurr] != null;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                int thisCurr = curr + 1;
                if (s[thisCurr] == null) {
                    throw new NoSuchElementException();
                } else {
                    curr++;
                    return s[curr];
                }
            } else {
                throw new NoSuchElementException("Illegal Argument Exception");
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not yet");
        }

    }

}
