package symboltable;

import ast.locatables.definitions.VariableDefinition;

public class SymbolTableTest {
		
	public void testInsert() {
		SymbolTable st = new SymbolTable();
		VariableDefinition definition = new VariableDefinition("a", null, 0, 0);
		assert st.insert(definition);
		assert definition.getScope()==0;
		assert !st.insert(definition);
		st.set();
		VariableDefinition definition2 = new VariableDefinition("a", null, 0, 0);
		assert st.insert(definition2);
		assert definition2.getScope()==1;
		assert !st.insert(definition2);
		st.reset();
		assert !st.insert(definition);
	}
	
	public void testFind() {
		SymbolTable st = new SymbolTable();
		VariableDefinition varDefinition = new VariableDefinition("a", null, 0, 0);
		assert st.insert(varDefinition);
		assert st.find("a")!=null;
		assert st.find("b")==null;
		st.set();
		VariableDefinition varDefinition2 = new VariableDefinition("b", null, 0, 0);
		assert st.insert(varDefinition2);
		assert st.find("b")!=null;
		assert st.find("a")!=null;
		assert st.find("c")==null;
		st.reset();
		assert st.find("a")!=null;
		assert st.find("b")==null;
	}

	public void testFindInCurrentScope() {
		SymbolTable st = new SymbolTable();
		VariableDefinition varDefinition = new VariableDefinition("a", null, 0, 0);
		assert st.insert(varDefinition);
		assert st.findInCurrentScope("a");
		assert !st.findInCurrentScope("b");
		st.set();
		VariableDefinition varDefinition2 = new VariableDefinition("b", null, 0, 0);
		assert st.insert(varDefinition2);
		assert st.findInCurrentScope("b");
		assert !st.findInCurrentScope("a");
		assert !st.findInCurrentScope("c");
		st.reset();
		assert st.findInCurrentScope("a");
		assert !st.findInCurrentScope("b");		
	}
	
	public static void main(String[] args) {
		SymbolTableTest test = new SymbolTableTest();
		test.testInsert();
		test.testFind();
		test.testFindInCurrentScope();
	}
}
