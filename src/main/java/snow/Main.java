package snow;

import gen.Parser;
import gen.Scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		String inFileName = args.length >= 1 && args[0].length() != 0? args[0] : null;
		String outFileName = args.length >= 2 && args[1].length() != 0 ? args[1] : null;
		try {
			Scanner scanner = new Scanner(inFileName == null || "-".equals(inFileName) ? System.in : new FileInputStream(new File(inFileName)));
			Parser parser = new Parser(scanner);
			parser.Parse();
			XmlAstVisitor visitor = new XmlAstVisitor(outFileName);
			visitor.visit(parser.ast);
		} catch (FileNotFoundException e) {
			System.out.println("-- file " + outFileName + " not found");
		}
	}

}
