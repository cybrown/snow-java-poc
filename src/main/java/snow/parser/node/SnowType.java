package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

@Value
@EqualsAndHashCode(callSuper = true)
public class SnowType extends BaseAstNode {

    private final Identifier name;
    private final BaseAstNode typeExpression;

    public SnowType(Token firstToken, Token lastToken, Identifier name, BaseAstNode typeExpression) {
        super(firstToken, lastToken);
        this.name = name;
        this.typeExpression = typeExpression;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.name.accept(visitor);
        this.typeExpression.accept(visitor);
        visitor.visit(this, false);
    }
}
