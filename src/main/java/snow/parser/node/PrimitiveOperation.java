package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class PrimitiveOperation extends BaseAstNode {

    private final Identifier identifier;
    private final List<BaseAstNode> body;

    public PrimitiveOperation(Token firstToken, Token lastToken, Identifier identifier, List<BaseAstNode> body) {
        super(firstToken, lastToken);
        this.identifier = identifier;
        this.body = body;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.identifier.accept(visitor);
        this.body.forEach(b -> b.accept(visitor));
        visitor.visit(this, false);
    }
}
