package snow;

import snow.ast.node.BaseAstNode;
import snow.ast.node.Binary;
import snow.ast.node.LiteralInteger;
import snow.ast.node.LiteralString;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class XmlAstVisitor implements IAstVisitor {

	@Override
	public void visit(BaseAstNode node) {
		node.accept(this);
	}

	@Override
	public void visit(LiteralInteger node, boolean start) {
		this.printIndentation();
		s.println("<LiteralInteger>" + node.getFirstToken().getVal() + "</LiteralInteger>");
	}

	@Override
	public void visit(LiteralString node, boolean start) {
		this.printIndentation();
		s.println("<LiteralString>" + node.getFirstToken().getVal() + "</LiteralString>");
	}

	@Override
	public void visit(Binary node, boolean start) {
		if (start) {
			this.printIndentation();
			s.println("<Binary operator=\"" + node.getOperator() + "\">");
			this.incIndentation();
		} else {
			this.decIndentation();
			this.printIndentation();
			s.println("</Binary>");
		}
	}

	private PrintStream s;

	public XmlAstVisitor(String fileName) throws FileNotFoundException {
		s = new PrintStream(fileName);
	}

	private int spaceCount = 0;

	private void printIndentation() {
		for (int i = 0; i < this.spaceCount; i++) {
			s.print(' ');
		}
	}

	private void incIndentation() {
		this.spaceCount += 4;
	}

	private void decIndentation() {
		this.spaceCount -= 4;
	}
}
