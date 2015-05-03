package snow.ast.node;

import lombok.Data;
import lombok.EqualsAndHashCode;
import snow.IAstVisitor;
import snow.ast.Token;

@Data
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
