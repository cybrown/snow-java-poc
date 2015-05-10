package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
public class PrimitiveOperation extends BaseAstNode {

    private final Identifier identifier;
    private final Optional<ArgumentList> arguments;

    public PrimitiveOperation(Token firstToken, Token lastToken, Identifier identifier, ArgumentList arguments) {
        super(firstToken, lastToken);
        this.identifier = identifier;
        this.arguments = Optional.ofNullable(arguments);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.identifier.accept(visitor);
        this.arguments.ifPresent(a -> a.accept(visitor));
        visitor.visit(this, false);
    }
}
