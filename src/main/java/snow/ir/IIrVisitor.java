package snow.ir;

import snow.ir.node.FunctionNode;
import snow.ir.node.IntegerNode;

public interface IIrVisitor {
    void accept(FunctionNode node, boolean start);
    void accept(IntegerNode node, boolean start);
}
