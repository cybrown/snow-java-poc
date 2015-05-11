package snow.ir;

import snow.ir.node.*;

public interface IIrVisitor {
    void visit(FunctionNode node, boolean start);
    void visit(IntegerNode node, boolean start);
    void visit(IdentifierNode node, boolean start);
    void visit(IrNodeList nodes, boolean start);
    void visit(TypeArrayNode node, boolean start);
    void visit(TypeClassNode node, boolean start);
    void visit(TypeFunctionNode node, boolean start);
    void visit(TypeGenericNode node, boolean start);
    void visit(TypeInterfaceNode node, boolean start);
    void visit(TypePrimitiveNode node, boolean start);
    void visit(TypeTupleNode node, boolean start);
}
