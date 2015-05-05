package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

import java.util.List;
import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
public class SnowType extends BaseAstNode {

    private final Identifier name;
    private final List<SnowTypeMember> members;

    public SnowType(Token firstToken, Token lastToken, Identifier name, List<SnowTypeMember> members) {
        super(firstToken, lastToken);
        this.name = name;
        this.members = members;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.name.accept(visitor);
        this.members.forEach(m -> m.accept(visitor));
        visitor.visit(this, false);
    }
}
