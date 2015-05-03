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
    private Optional<BaseAstNode> returnType;

    public Function(Token firstToken, Token lastToken, String name, BaseAstNode body, Identifier argName, BaseAstNode argType, BaseAstNode returnType) {
        super(firstToken, lastToken);
        this.name = name;
        this.body = body;
        this.argName = Optional.ofNullable(argName);
        this.argType = Optional.ofNullable(argType);
        this.returnType = Optional.ofNullable(returnType);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.argName.ifPresent(n -> n.accept(visitor));
        this.argType.ifPresent((t -> t.accept(visitor)));
        this.returnType.ifPresent((r -> r.accept(visitor)));
        this.body.accept(visitor);
        visitor.visit(this, false);
    }
}
