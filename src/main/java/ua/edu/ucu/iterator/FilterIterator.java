package ua.edu.ucu.iterator;

import java.util.Iterator;

import ua.edu.ucu.function.IntPredicate;


public class FilterIterator implements Iterator<Integer> {
    private final IntPredicate Predicate;
    private final Iterator<Integer> iter;
    private int next;

    public FilterIterator(IntPredicate predicate, Iterator<Integer> iter) {
        this.Predicate = predicate;
        this.iter = iter;
    }

    @Override
    public boolean hasNext() {
        while (iter.hasNext()) {
            next = iter.next();
            if (Predicate.test(next)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return next;
    }
}
