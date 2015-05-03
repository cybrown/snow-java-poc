package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

@Value
@EqualsAndHashCode(callSuper = true)
public class Call extends BaseAstNode {

    private final BaseAstNode callee;

    public Call(Token firstToken, Token lastToken, BaseAstNode callee) {
        super(firstToken, lastToken);
        this.callee = callee;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.callee.accept(visitor);
        visitor.visit(this, false);
    }
}