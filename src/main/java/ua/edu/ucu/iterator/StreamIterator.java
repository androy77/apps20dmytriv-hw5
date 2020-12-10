package ua.edu.ucu.iterator;

import java.util.Iterator;
import java.util.ArrayList;

public class StreamIterator implements Iterator<Integer> {
    private final ArrayList<Integer> items;
    private int counter;

    public StreamIterator(ArrayList<Integer> items) {
        this.items = items;
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        if (counter < items.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        return items.get(counter++);
    }
}
