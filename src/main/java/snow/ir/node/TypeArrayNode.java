package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.parser.node.BaseAstNode;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeArrayNode extends BaseTypeNode {

    private BaseTypeNode type;

    public TypeArrayNode(BaseAstNode ast, BaseTypeNode type) {
        super(ast);
        this.type = type;
    }

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.visit(this, true);
        type.accept(visitor);
        visitor.visit(this, false);
    }
}
