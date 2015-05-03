package snow;

import gen.Parser;
import gen.Scanner;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		String inFileName = args[0];
		String outFileName = args[1];
		Scanner scanner = new Scanner(inFileName);
		Parser parser = new Parser(scanner);
		parser.Parse();
		try {
			XmlAstVisitor visitor = new XmlAstVisitor(outFileName);
			visitor.visit(parser.ast);
		} catch (FileNotFoundException e) {
			System.out.println("-- file " + outFileName + " not found");
		}
	}

}
