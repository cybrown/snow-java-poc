package snow.ir.node;

import snow.ir.IIrVisitor;

abstract public class BaseIrNode {
    abstract public void accept(IIrVisitor visitor);
}
