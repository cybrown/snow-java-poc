package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
public class SnowClass extends BaseAstNode {

    private final Identifier identifier;
    private final Optional<BaseAstNode> body;

    public SnowClass(Token firstToken, Token lastToken, Identifier identifier, BaseAstNode body) {
        super(firstToken, lastToken);
        this.identifier = identifier;
        this.body = Optional.ofNullable(body);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.identifier.accept(visitor);
        this.body.ifPresent(b -> b.accept(visitor));
        visitor.visit(this, false);
    }
}
