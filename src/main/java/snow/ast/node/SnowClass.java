package snow.ast.node;

import snow.IAstVisitor;
import snow.ast.Token;

import java.util.Optional;

public class SnowClass extends BaseAstNode {

    private final Identifier identifier;

    public SnowClass(Token firstToken, Token lastToken, Identifier identifier) {
        super(firstToken, lastToken);
        this.identifier = identifier;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.identifier.accept(visitor);
        visitor.visit(this, false);
    }
}
