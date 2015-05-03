package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

@Value
@EqualsAndHashCode(callSuper = true)
public class LiteralInteger extends BaseAstNode {

    public LiteralInteger(Token token) {
        super(token, token);
    }

    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
    }
}
