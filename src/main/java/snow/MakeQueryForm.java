package snow;

import java.io.*;
import gen.Scanner;
import gen.Parser;

public class MakeQueryForm {

	public static void main(String[] args) {
		String inFileName = args[0];
		String outFileName = args[1];
		Scanner scanner = new Scanner(inFileName);
		Parser parser = new Parser(scanner);
		try {
			parser.html = new HtmlGenerator(outFileName);
			parser.Parse();
		} catch (FileNotFoundException e) {
			System.out.println("-- file " + outFileName + " not found");
		}
	}

}
