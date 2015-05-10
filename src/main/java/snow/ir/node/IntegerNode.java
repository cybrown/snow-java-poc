package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.parser.node.BaseAstNode;

@Value
@EqualsAndHashCode(callSuper=true)
public class IntegerNode extends BaseIrNode {

    private int value;

    public IntegerNode(BaseAstNode ast, int value) {
        super(ast);
        this.value = value;
    }

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.visit(this, true);
    }
}
