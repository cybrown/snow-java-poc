package snow;

import snow.ast.node.*;

public interface IAstVisitor {
    void visit(LiteralInteger node, boolean start);
    void visit(LiteralString node, boolean start);
    void visit(Binary node, boolean start);
    void visit(Function node, boolean start);
    void visit(Identifier node, boolean start);
    void visit(Definition definition, boolean start);
    void visit(Call call, boolean start);
    void visit(Generic call, boolean start);
    void visit(If node, boolean start);
    void visit(ExpressionList node, boolean start);
    void visit(SnowClass node, boolean start);
    void visit(Tuple tuple, boolean start);
    void visit(Unary unary, boolean start);
    void visit(PrimitiveOperation node, boolean start);
}
