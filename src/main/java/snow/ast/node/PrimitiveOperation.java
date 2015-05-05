package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

@Value
@EqualsAndHashCode(callSuper = true)
public class PrimitiveOperation extends BaseAstNode {

    private final Identifier identifier;
    private final BaseAstNode body;

    public PrimitiveOperation(Token firstToken, Token lastToken, Identifier identifier, BaseAstNode body) {
        super(firstToken, lastToken);
        this.identifier = identifier;
        this.body = body;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.identifier.accept(visitor);
        this.body.accept(visitor);
        visitor.visit(this, false);
    }
}
