package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

import java.util.ArrayList;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class Tuple extends BaseAstNode {

    private List<BaseAstNode> expressions = new ArrayList<>();

    public Tuple(Token firstToken, Token lastToken, BaseAstNode left, BaseAstNode right) {
        super(firstToken, lastToken);
        if (left.isReplaceable() && left instanceof Tuple) {
            this.expressions.addAll(((Tuple) left).getExpressions());
        } else {
            this.expressions.add(left);
        }
        this.expressions.add(right);
    }

    public Tuple(Token firstToken, Token lastToken, List<BaseAstNode> expressions) {
        super(firstToken, lastToken);
        this.expressions.addAll(expressions);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        expressions.forEach(e -> e.accept(visitor));
        visitor.visit(this, false);
    }
}
