package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.parser.node.BaseAstNode;

@Value
@EqualsAndHashCode(callSuper = true)
public class TypeInterfaceNode extends BaseTypeNode {

    public TypeInterfaceNode(BaseAstNode ast) {
        super(ast);
    }

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.visit(this, true);
        visitor.visit(this, false);
    }
}
