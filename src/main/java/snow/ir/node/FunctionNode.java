package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.parser.node.BaseAstNode;

@Value
@EqualsAndHashCode(callSuper=true)
public class FunctionNode extends BaseIrNode {

    private BaseIrNode expression;

    public FunctionNode(BaseAstNode ast, BaseIrNode expression) {
        super(ast);
        this.expression = expression;
    }

    @Override
    public void accept(IIrVisitor visitor) {
        visitor.visit(this, true);
        visitor.visit(this, false);
    }
}
