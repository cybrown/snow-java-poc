package snow;

import snow.ast.node.BaseAstNode;
import snow.ast.node.Binary;
import snow.ast.node.LiteralInteger;
import snow.ast.node.LiteralString;

public interface IAstVisitor {
    void visit(BaseAstNode node);

    void visit(LiteralInteger node, boolean start);
    void visit(LiteralString node, boolean start);
    void visit(Binary node, boolean start);
}
