package snow;

import snow.ast.node.*;

public interface IAstVisitor {
    void visit(BaseAstNode node);
    void visit(LiteralInteger node, boolean start);
    void visit(LiteralString node, boolean start);
    void visit(Binary node, boolean start);
    void visit(Function node, boolean start);
    void visit(Identifier node, boolean start);
    void visit(Definition definition, boolean start);
    void visit(Call call, boolean start);
    void visit(If node, boolean start);
    void visit(ExpressionList node, boolean start);
}
