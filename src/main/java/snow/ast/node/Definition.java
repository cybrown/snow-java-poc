package snow.ast.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.IAstVisitor;
import snow.ast.Token;

import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = true)
public class Definition extends BaseAstNode {

    private final Identifier identifier;
    private final Optional<BaseAstNode> type;
    private final BaseAstNode value;

    public Definition(Token firstToken, Token lastToken, Identifier identifier, BaseAstNode value, BaseAstNode type) {
        super(firstToken, lastToken);
        this.identifier = identifier;
        this.value = value;
        this.type = Optional.ofNullable(type);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.identifier.accept(visitor);
        this.type.ifPresent(t -> t.accept(visitor));
        this.value.accept(visitor);
        visitor.visit(this, false);
    }
}
