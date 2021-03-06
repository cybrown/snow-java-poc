package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeGeneric extends BaseAstNode {

    private final BaseAstNode callee;
    private final Optional<BaseAstNode> arg;

    public TypeGeneric(Token firstToken, Token lastToken, BaseAstNode callee, BaseAstNode arg) {
        super(firstToken, lastToken);
        this.callee = callee;
        this.arg = Optional.ofNullable(arg);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.callee.accept(visitor);
        this.arg.ifPresent(a -> a.accept(visitor));
        visitor.visit(this, false);
    }
}
