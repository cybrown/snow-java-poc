package snow.ast.node;

import snow.IAstVisitor;
import snow.ast.Token;

public class LiteralString extends BaseAstNode {

    public LiteralString(Token token) {
        super(token, token);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
    }
}
