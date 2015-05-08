package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class SnowInterface extends BaseAstNode {

    private final List<InterfaceMember> members;

    public SnowInterface(Token firstToken, Token lastToken, List<InterfaceMember> members) {
        super(firstToken, lastToken);
        this.members = members;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.members.forEach(m -> m.accept(visitor));
        visitor.visit(this, false);
    }
}
