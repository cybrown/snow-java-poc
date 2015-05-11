package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.parser.node.BaseAstNode;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeTupleNode extends BaseTypeNode {

    private final Iterable<BaseTypeNode> types;

    public TypeTupleNode(BaseAstNode ast, Iterable<BaseTypeNode> types) {
        super(ast);
        this.types = types;
    }

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.visit(this, true);
        types.forEach(t -> t.accept(visitor));
        visitor.visit(this, false);
    }
}
