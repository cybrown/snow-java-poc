package snow.parser.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.parser.IAstVisitor;
import snow.parser.Token;

import java.util.List;
import java.util.ArrayList;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeTuple extends BaseAstNode {

    private final List<BaseAstNode> types = new ArrayList<>();

    public TypeTuple(Token firstToken, Token lastToken, List<BaseAstNode> types) {
        super(firstToken, lastToken);
        this.types.addAll(types);
    }

    @Override
    public void accept(IAstVisitor visitor) {
        visitor.visit(this, true);
        this.types.forEach(t -> t.accept(visitor));
        visitor.visit(this, false);
    }
}
