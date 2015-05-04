package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

@Value
@EqualsAndHashCode(callSuper = true)
public class Unary extends BaseAstNode {

    private BaseAstNode value;
    private boolean postfix;
    private String operator;

    public Unary(Token firstToken, Token lastToken, BaseAstNode value, String operator, boolean isPostfix) {
        super(firstToken, lastToken);
        this.value = value;
        this.operator = operator;
        this.postfix = isPostfix;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.value.accept(visitor);
        visitor.visit(this, false);
    }
}
