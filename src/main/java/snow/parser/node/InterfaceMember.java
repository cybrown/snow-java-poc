package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class InterfaceMember extends BaseAstNode {

    private final Identifier identifier;
    private final List<Argument> arguments;
    private final BaseAstNode type;

    public InterfaceMember(Token firstToken, Token lastToken, Identifier identifier, List<Argument> arguments, BaseAstNode type) {
        super(firstToken, lastToken);
        this.identifier = identifier;
        this.arguments = arguments;
        this.type = type;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.identifier.accept(visitor);
        this.arguments.forEach(a -> a.accept(visitor));
        this.type.accept(visitor);
        visitor.visit(this, false);
    }
}
