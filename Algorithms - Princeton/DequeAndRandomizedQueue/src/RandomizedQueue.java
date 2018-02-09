
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hungle
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] s;   //The array to save value
    private int last;   //The last element index in the array

    public RandomizedQueue() //Construct an empty RandQueue 
    {
        //Initialize s[last] = s[0] = null; 
        last = 0;
        s = (Item[]) new Object[1];
        s[last] = null;
    }

    public boolean isEmpty() //is the Queue empty?
    {
        return s[last] == null; // 
    }

    public int size() // return the number of items on the deque
    {
        if (isEmpty()) return 0; 
        return last + 1;
    }

    public void enqueue(Item item) // add the item to the end 
    {
        if (item == null) {
            throw new IllegalArgumentException("Illegal Argument Exception");
        }
        if (isEmpty()) {
            s[last] = item;
        } else if (last == s.length - 1) {
            DoubleTheSize();
            WriteToBack(item);
        } else {
            WriteToBack(item);
        }
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item randItem = null;

        int rand = 0;

        if (last > 0) {
            rand = StdRandom.uniform(0, last); //Get a random number from 0 -> last (get the index)
        } else {
            randItem = s[0];
            s[0] = null; 
            return randItem;
        }
        
        if (rand == last) {
            randItem = s[last];
        } else {
            randItem = s[rand];
            s[rand] = s[last];
        }

        s[last] = null;
        last--;
        
        SmallerArray();

        return randItem;
    }

    private void SmallerArray() {
        if (last <= s.length / 4 - 1 && last + 1 != 0) {
            Item[] copy = (Item[]) new Object[s.length / 2];
            for (int i = 0; i <= last; i++) {
                copy[i] = s[i];
            }
            s = copy;
        }
    }

    public Item sample() { // return a random item (but do not remove it)
        if (isEmpty()) {
            throw new NoSuchElementException("No such element exception");
        }
        if (last == 0) {
            return s[0];
        } else {
            Item thisItem = null;

            int rand = StdRandom.uniform(0, last);

            thisItem = s[rand];
            return thisItem;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private void WriteToBack(Item item) {
        last++;
        s[last] = item;
    }

    private void DoubleTheSize() {
        Item[] copy = (Item[]) new Object[s.length * 2];

        for (int i = 0; i <= last; i++) {
            copy[i] = s[i];
        }

        s = copy;
    }

    private void print() {
        for (int i = 0; i < s.length; i++) {
            StdOut.println(s[i]);
        }
    }

    public static void main(String[] args) // unit testing (optional)
    {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        randomizedQueue.enqueue(4);
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        
        Iterator itor = randomizedQueue.iterator(); 
        StdOut.println(itor.hasNext());
        
    }

    private class ArrayIterator implements Iterator<Item> {

        int curr = 0;
        int count = 0;
        int tempLast = last;

        @Override
        public boolean hasNext() {
            if (isEmpty()) return false; 
            return this.count <= last;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                Item thisItem = null;

                if (last - this.count == 0) {
                    this.count++;
                    return s[0];
                }

                int rand = StdRandom.uniform(0, last - this.count);

                //Swap the item
                thisItem = s[rand];
                s[rand] = s[this.tempLast];
                s[this.tempLast] = thisItem;

                this.tempLast--;
                this.count++;
                return thisItem;
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
