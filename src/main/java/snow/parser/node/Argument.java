package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

@Value
@EqualsAndHashCode(callSuper = true)
public class Argument extends BaseAstNode {

    private final Identifier identifier;
    private final BaseAstNode type;

    public Argument(Token firstToken, Token lastToken, Identifier identifier, BaseAstNode type) {
        super(firstToken, lastToken);
        this.identifier = identifier;
        this.type = type;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.identifier.accept(visitor);
        this.type.accept(visitor);
        visitor.visit(this, false);
    }
}
