package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

@Value
@EqualsAndHashCode(callSuper = true)
public class LiteralString extends BaseAstNode {

    public LiteralString(Token token) {
        super(token, token);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
    }
}
