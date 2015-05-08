package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

@Value
@EqualsAndHashCode(callSuper = true)
public class Identifier extends BaseAstNode {

    public Identifier(Token token) {
        super(token, token);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
    }
}
