package ua.edu.ucu.iterator;

import java.util.Iterator;

import ua.edu.ucu.function.IntUnaryOperator;

public class MapIterator implements Iterator<Integer> {
    private final Iterator<Integer> iter;
    private final IntUnaryOperator oper;

    public MapIterator(Iterator<Integer> iterator,
                       IntUnaryOperator intUnaryOperator) {
        this.iter = iterator;
        this.oper = intUnaryOperator;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Integer next() {
        int cur = iter.next();
        return oper.apply(cur);
    }
}
