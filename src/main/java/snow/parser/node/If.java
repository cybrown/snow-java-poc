package snow.parser.node;

import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.Optional;

public class If extends BaseAstNode {

    private final BaseAstNode condition;
    private final BaseAstNode ifTrue;
    private final Optional<BaseAstNode> ifFalse;

    public If(Token firstToken, Token lastToken, BaseAstNode condition, BaseAstNode ifTrue, BaseAstNode ifFalse) {
        super(firstToken, lastToken);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = Optional.ofNullable(ifFalse);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.condition.accept(visitor);
        this.ifTrue.accept(visitor);
        this.ifFalse.ifPresent(i -> i.accept(visitor));
        visitor.visit(this, false);
    }
}
