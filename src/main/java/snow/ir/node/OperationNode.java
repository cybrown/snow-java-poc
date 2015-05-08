package snow.ir.node;

import lombok.EqualsAndHashCode;
import lombok.Value;
import snow.ir.IIrVisitor;
import snow.ir.Operation;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper=true)
public class OperationNode extends BaseIrNode {

    private Operation operator;
    private List<BaseIrNode> expressions;

    @Override
    public void accept(IIrVisitor visitor) {

    }
}
