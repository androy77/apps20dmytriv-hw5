package ua.edu.ucu.iterator;

import java.util.Iterator;

import ua.edu.ucu.stream.AsIntStream;
import ua.edu.ucu.function.IntToIntStreamFunction;


public class FlatMapIterator implements Iterator<Integer> {

    private final IntToIntStreamFunction streamFunction;
    private final Iterator<Integer> iter;
    private AsIntStream stream;

    public FlatMapIterator(IntToIntStreamFunction streamFunction, Iterator<Integer> iter) {
        this.streamFunction = streamFunction;
        this.iter = iter;
    }

    @Override
    public boolean hasNext() {
        if (stream == null || !stream.getIterator().hasNext()) {
            stream = null;
            return iter.hasNext();
        }
        return true;
    }

    @Override
    public Integer next() {
        if(stream == null){
            stream = (AsIntStream)
                    streamFunction.applyAsIntStream(iter.next());
        }
        return stream.getIterator().next();
    }
}
