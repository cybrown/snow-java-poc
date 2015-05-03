package snow.ast.node;

import snow.IAstVisitor;
import snow.ast.Token;

public class LiteralInteger extends BaseAstNode {

    public LiteralInteger(Token token) {
        super(token, token);
    }

    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
    }
}
