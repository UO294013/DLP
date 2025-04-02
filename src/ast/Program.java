package ast;

import ast.locatables.definitions.Definition;
import visitor.Visitor;

import java.util.List;

public class Program implements ASTNode {

    public List<Definition> definitionList;

    public Program(List<Definition> definitionList) {
        this.definitionList = definitionList;
    }

    public List<Definition> getDefinitions() {
        return definitionList;
    }

    @Override
    public String toString() {
        return "Program {" + "definitionList=" + definitionList + '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
