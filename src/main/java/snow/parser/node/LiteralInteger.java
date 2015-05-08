package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

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
