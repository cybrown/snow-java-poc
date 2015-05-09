package snow.parser;

import snow.parser.node.*;

public interface IAstVisitor {
    void visit(LiteralInteger node, boolean start);
    void visit(LiteralString node, boolean start);
    void visit(Binary node, boolean start);
    void visit(Function node, boolean start);
    void visit(Identifier node, boolean start);
    void visit(Definition definition, boolean start);
    void visit(Call call, boolean start);
    void visit(TypeGeneric call, boolean start);
    void visit(If node, boolean start);
    void visit(ExpressionList node, boolean start);
    void visit(SnowClass node, boolean start);
    void visit(Tuple tuple, boolean start);
    void visit(Unary unary, boolean start);
    void visit(PrimitiveOperation node, boolean start);
    void visit(SnowType node, boolean start);
    void visit(TypeInterfaceMember node, boolean start);
    void visit(Argument node, boolean start);
    void visit(TypeInterface node, boolean start);
    void visit(TypeTuple node, boolean start);
    void visit(TypeArray node, boolean start);
    void visit(TypeFunction node, boolean start);
    void visit(TypeFunctionParameterList node, boolean start);
    void visit(TypeFunctionParameter node, boolean start);
}
