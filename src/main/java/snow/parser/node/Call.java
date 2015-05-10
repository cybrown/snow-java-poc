package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
public class Call extends BaseAstNode {

    private final BaseAstNode callee;
    private final Optional<ArgumentList> arguments;

    public Call(Token firstToken, Token lastToken, BaseAstNode callee, ArgumentList arguments) {
        super(firstToken, lastToken);
        this.callee = callee;
        this.arguments = Optional.ofNullable(arguments);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.callee.accept(visitor);
        this.arguments.ifPresent(a -> a.accept(visitor));
        visitor.visit(this, false);
    }
}
