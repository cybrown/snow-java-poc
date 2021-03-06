package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

@Value
@EqualsAndHashCode(callSuper = true)
public class Binary extends BaseAstNode {

    private BaseAstNode left;
    private BaseAstNode right;
    private String operator;

    public Binary(Token firstToken, Token lastToken, BaseAstNode left, BaseAstNode right, String operator) {
        super(firstToken, lastToken);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.left.accept(visitor);
        this.right.accept(visitor);
        visitor.visit(this, false);
    }
}
