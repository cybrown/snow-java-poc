package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;
import snow.parser.util.Pair;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeFunction extends BaseAstNode {

    private final List<Pair<Identifier, BaseAstNode>> args;
    private final BaseAstNode returnType;

    public TypeFunction(Token firstToken, Token lastToken, List<Pair<Identifier, BaseAstNode>> args, BaseAstNode returnType) {
        super(firstToken, lastToken);
        this.args = args;
        this.returnType = returnType;
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.args.stream().filter(a -> a.getFirst() != null).forEach(a -> a.getFirst().accept(visitor));
        this.args.stream().filter(a -> a.getSecond() != null).forEach(a -> a.getSecond().accept(visitor));
        this.returnType.accept(visitor);
        visitor.visit(this, false);
    }
}
