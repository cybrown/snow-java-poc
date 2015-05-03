package snow.ast.node;

import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

@Value
public class Definition extends BaseAstNode {

    private final Identifier identifier;
    private final BaseAstNode value;

    public Definition(Token firstToken, Token lastToken, Identifier identifier, BaseAstNode value) {
        super(firstToken, lastToken);
        this.identifier = identifier;
        this.value = value;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.identifier.accept(visitor);
        this.value.accept(visitor);
        visitor.visit(this, false);
    }
}
