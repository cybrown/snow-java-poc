package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.parser.node.BaseAstNode;

@Value
@EqualsAndHashCode(callSuper = true)
public class IdentifierNode extends BaseIrNode {

    private String name;

    public IdentifierNode(BaseAstNode ast, String name) {
        super(ast);
        this.name = name;
    }

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.visit(this, true);
    }
}
