package snow.parser.node;

import snow.parser.IAstVisitor;
import snow.parser.Token;

public class ExpressionList extends BaseAstNode {

    private final BaseAstNode left;
    private final BaseAstNode right;

    public ExpressionList(Token firstToken, Token lastToken, BaseAstNode left, BaseAstNode right) {
        super(firstToken, lastToken);
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.left.accept(visitor);
        this.right.accept(visitor);
        visitor.visit(this, false);
    }
}
