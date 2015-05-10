package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.ir.Operation;
import snow.parser.node.BaseAstNode;

@Value
@EqualsAndHashCode(callSuper=true)
public class OperationNode extends BaseIrNode {

    private Operation operator;
    private BaseIrNode expressions;

    public OperationNode(BaseAstNode ast, Operation operator, BaseIrNode expressions) {
        super(ast);
        this.operator = operator;
        this.expressions = expressions;
    }

    @Override
    public void accept(IIrVisitor visitor) {

    }
}
