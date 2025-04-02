package symboltable;

import java.util.*;
import ast.locatables.definitions.Definition;

public class SymbolTable {
	
	private int scope = 0;
	private final List<Map<String, Definition>> table;

	public SymbolTable()  {
		table = new LinkedList<>();
		table.add(scope, new HashMap<>());
	}

	public void set() {
		table.add(++scope, new HashMap<>());
	}
	
	public void reset() {
		table.remove(scope--);
	}
	
	public boolean insert(Definition definition) {
		if (!findInCurrentScope(definition.getName())) {
			definition.setScope(scope);
			table.get(scope).put(definition.getName(), definition);
			return true;
		}
		return false;
	}
	
	public Definition find(String id) {
		for (int i = scope; i >= 0; i--) {
			if (table.get(i).get(id) != null) {
				return table.get(i).get(id);
			}
		}
		return null;
	}

	// package-protected for testing purposes
	boolean findInCurrentScope(String id) {
		return table.get(scope).get(id) != null;
	}
}
