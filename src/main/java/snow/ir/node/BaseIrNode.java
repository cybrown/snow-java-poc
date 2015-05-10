package snow.ir.node;

import snow.ir.IIrVisitor;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract public class BaseIrNode implements Iterable<BaseIrNode> {
    abstract public void accept(IIrVisitor visitor);

    @Override
    public Iterator<BaseIrNode> iterator() {
        return new Iterator<BaseIrNode>() {

            private boolean finished = false;

            @Override
            public boolean hasNext() {
                return !finished;
            }

            @Override
            public BaseIrNode next() {
                if (finished) {
                    throw new NoSuchElementException();
                }
                finished = true;
                return BaseIrNode.this;
            }
        };
    }
}
