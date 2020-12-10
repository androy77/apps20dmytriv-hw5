package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterator.*;

import java.util.Iterator;
import java.util.ArrayList;

public class AsIntStream implements IntStream {
    private final Iterator<Integer> iter;

    private AsIntStream(int... values) {
        ArrayList<Integer> newlist = new ArrayList<>();
        for (int item : values) {
            newlist.add(item);
        }
        this.iter = new StreamIterator(newlist);
    }

    private AsIntStream(Iterator<Integer> iter) {
        this.iter = iter;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(values);
    }

    @Override
    public Double average() {
        int length = 0;
        int sum = 0;
        for (Iterator<Integer> it = iter; it.hasNext(); ) {
            int val = it.next();
            sum +=val;
            length += 1;
        }

        double a = (double) sum / length;
        return a;
    }

    @Override
    public Integer max() {
        int max = Integer.MIN_VALUE;
        while (iter.hasNext()) {
            int a = iter.next();
            if (max < a) {
                max = a;
            }
        }
        return max;
    }

    @Override
    public Integer min() {
        int min = Integer.MAX_VALUE;
        while (iter.hasNext()) {
            int a = iter.next();
            if (min > a) {
                min = a;
            }
        }
        return min;
    }

    @Override
    public long count() {
        long length = 0;
        while (iter.hasNext()) {
            length += 1;
            iter.next();
        }
        return length;
    }

    @Override
    public Integer sum() {
        int sum = 0;
        for (Iterator<Integer> it = iter; it.hasNext(); ) {
            int val = it.next();
            sum += val;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        return new AsIntStream(new FilterIterator(predicate, iter));
    }

    @Override
    public void forEach(IntConsumer action) {
        while (iter.hasNext()) {
            int nekst = iter.next();
            action.accept(nekst);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return new AsIntStream(new MapIterator(iter, mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        return new AsIntStream(new FlatMapIterator(func, iter));
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int identityy = identity;
        while (iter.hasNext()) {
            identityy = op.apply(identityy, this.iter.next());
        }
        return identityy;
    }

    @Override
    public int[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterator<Integer> getIterator() {
        return iter;
    }
}
