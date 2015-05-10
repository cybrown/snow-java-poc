package snow;

import org.junit.Before;
import org.junit.Test;
import snow.ir.Operation;
import snow.ir.node.IdentifierNode;
import snow.ir.node.IntegerNode;
import snow.ir.node.OperationNode;
import snow.parser.Token;
import snow.parser.node.ArgumentList;
import snow.parser.node.Identifier;
import snow.parser.node.LiteralInteger;
import snow.parser.node.PrimitiveOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AstToIrVisitorTest {

    AstToIrVisitor visitor;

    static <T> List<T> iterableToList(Iterable<T> iterable) {
        List<T> list = new ArrayList<T>();
        for (T t : iterable) {
            list.add(t);
        }
        return list;
    }

    @Before
    public void beforeEach() {
        visitor = new AstToIrVisitor();
    }

    @Test
    public void convertLiteralInteger() {
        LiteralInteger ast = new LiteralInteger(new Token(0, 0, 0, 0, "42"));
        ast.accept(visitor);
        assertTrue(visitor.getLastValue() instanceof IntegerNode);
        assertEquals(visitor.<IntegerNode>getLastValue().getValue(), 42);
    }

    @Test
    public void convertPrimitiveOperation() {
        PrimitiveOperation ast = new PrimitiveOperation(null, null, new Identifier(new Token(0, 0, 0, 0, "IADD")), new ArgumentList(null, null, Arrays.asList(
                new LiteralInteger(new Token(0, 0, 0, 0, "23")),
                new LiteralInteger(new Token(0, 0, 0, 0, "27"))
        )));
        ast.accept(visitor);
        assertTrue(visitor.getLastValue() instanceof OperationNode);
        assertEquals(visitor.<OperationNode>getLastValue().getOperator(), Operation.IADD);
        List baseIrNodes = iterableToList(((OperationNode) visitor.getLastValue()).getExpressions());
        assertEquals(((IntegerNode) baseIrNodes.get(0)).getValue(), 23);
        assertEquals(((IntegerNode) baseIrNodes.get(1)).getValue(), 27);
    }

    @Test
    public void convertIdentifier() {
        snow.parser.node.Identifier ast = new snow.parser.node.Identifier(new Token(0, 0, 0, 0, "foo"));
        ast.accept(visitor);
        assertTrue(visitor.getLastValue() instanceof IdentifierNode);
    }
}
