package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.Collections;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class Call extends BaseAstNode {

    private final BaseAstNode callee;
    private final List<BaseAstNode> arg;

    public Call(Token firstToken, Token lastToken, BaseAstNode callee, List<BaseAstNode> arg) {
        super(firstToken, lastToken);
        this.callee = callee;
        this.arg = arg == null ? Collections.emptyList() : arg;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.callee.accept(visitor);
        this.arg.forEach(a -> a.accept(visitor));
        visitor.visit(this, false);
    }
}
