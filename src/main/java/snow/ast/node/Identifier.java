package snow.ast.node;

import snow.IAstVisitor;
import snow.ast.Token;

public class Identifier extends BaseAstNode {

    public Identifier(Token token) {
        super(token, token);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
    }
}
