package snow.ir;

import snow.ir.node.FunctionNode;
import snow.ir.node.IntegerNode;
import snow.ir.node.IdentifierNode;

public interface IIrVisitor {
    void visit(FunctionNode node, boolean start);
    void visit(IntegerNode node, boolean start);
    void visit(IdentifierNode node, boolean start);
}
