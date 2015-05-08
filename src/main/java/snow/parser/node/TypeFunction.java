package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeFunction extends BaseAstNode {

    private final Optional<BaseAstNode> argType;
    private final BaseAstNode returnType;

    public TypeFunction(Token firstToken, Token lastToken, BaseAstNode argType, BaseAstNode returnType) {
        super(firstToken, lastToken);
        this.argType = Optional.ofNullable(argType);
        this.returnType = returnType;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.argType.ifPresent(a -> a.accept(visitor));
        this.returnType.accept(visitor);
        visitor.visit(this, false);
    }
}
