package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

import java.util.List;
import java.util.Optional;

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
