package snow;

import snow.ir.Operation;
import snow.ir.node.*;
import snow.parser.IAstVisitor;
import snow.parser.node.*;

import java.util.ArrayList;
import java.util.List;

public class AstToIrVisitor implements IAstVisitor {

    private List<BaseIrNode> currentStack = new ArrayList<>();
    private List<List<BaseIrNode>> stackStack = new ArrayList<>();

    public <T> T getLastValue() {
        return (T) lastValue;
    }

    private BaseIrNode lastValue;

    private void pushEmptyStack() {
        stackStack.add(currentStack);
        currentStack = new ArrayList<>();
    }

    private List<BaseIrNode> popCurrentStack() {
        List<BaseIrNode> oldStack = this.currentStack;
        currentStack = stackStack.remove(stackStack.size() - 1);
        return oldStack;
    }

    private void push(BaseIrNode node) {
        if (stackStack.size() == 0 && currentStack.size() == 0) {
            lastValue = node;
        }
        currentStack.add(node);
    }

    private BaseIrNode pop() {
        return currentStack.remove(currentStack.size() - 1);
    }

    private void assertCurrentStackLength(int length) {
        if (this.currentStack.size() != length) {
            throw new RuntimeException("Current stack size should have been 0");
        }
    }

    @Override
    public void visit(LiteralInteger node, boolean start) {
        push(new IntegerNode(Integer.parseInt(node.getFirstToken().getVal())));
    }

    @Override
    public void visit(LiteralString node, boolean start) {

    }

    @Override
    public void visit(Binary node, boolean start) {

    }

    @Override
    public void visit(Function node, boolean start) {
        if (start) {
            pushEmptyStack();
        } else {
            assertCurrentStackLength(1);
            currentStack.add(new FunctionNode(popCurrentStack().get(0)));
        }
    }

    @Override
    public void visit(Identifier node, boolean start) {
        push(new IdentifierNode(node.getFirstToken().getVal()));
    }

    @Override
    public void visit(Definition definition, boolean start) {

    }

    @Override
    public void visit(Call call, boolean start) {

    }

    @Override
    public void visit(TypeGeneric call, boolean start) {

    }

    @Override
    public void visit(If node, boolean start) {

    }

    @Override
    public void visit(ExpressionList node, boolean start) {

    }

    @Override
    public void visit(SnowClass node, boolean start) {

    }

    @Override
    public void visit(Tuple tuple, boolean start) {

    }

    @Override
    public void visit(Unary unary, boolean start) {

    }

    @Override
    public void visit(PrimitiveOperation node, boolean start) {
        if (start) {
            this.pushEmptyStack();
        } else {
            OperationNode operationNode = new OperationNode(Operation.IADD, currentStack.subList(1, currentStack.size()));
            popCurrentStack();
            push(operationNode);
        }
    }

    @Override
    public void visit(SnowType node, boolean start) {

    }

    @Override
    public void visit(TypeInterfaceMember node, boolean start) {

    }

    @Override
    public void visit(Argument node, boolean start) {

    }

    @Override
    public void visit(TypeInterface node, boolean start) {

    }

    @Override
    public void visit(TypeTuple node, boolean start) {

    }

    @Override
    public void visit(TypeArray node, boolean start) {

    }

    @Override
    public void visit(TypeFunction node, boolean start) {

    }
}
