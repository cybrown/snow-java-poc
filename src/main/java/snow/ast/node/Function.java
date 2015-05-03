package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
public class Function extends BaseAstNode {

    private BaseAstNode body;
    private String name;
    private Optional<Identifier> argName;
    private Optional<BaseAstNode> argType;

    public Function(Token firstToken, Token lastToken, String name, BaseAstNode body, Identifier argName, BaseAstNode argType) {
        super(firstToken, lastToken);
        this.name = name;
        this.body = body;
        this.argName = Optional.ofNullable(argName);
        this.argType = Optional.ofNullable(argType);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.argName.ifPresent(n -> n.accept(visitor));
        this.argType.ifPresent((t -> t.accept(visitor)));
        this.body.accept(visitor);
        visitor.visit(this, false);
    }
}
