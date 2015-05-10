package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.ir.Operation;

@Value
@EqualsAndHashCode(callSuper=true)
public class OperationNode extends BaseIrNode {

    private Operation operator;
    private BaseIrNode expressions;

    @Override
    public void accept(IIrVisitor visitor) {

    }
}
