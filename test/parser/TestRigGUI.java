package parser;

public class TestRigGUI {
	
	public static void main(String... args) throws Exception {
		org.antlr.v4.gui.TestRig.main(new String[]{"parser.TSmm", "program", "-gui", "input.txt"});
	}
}
