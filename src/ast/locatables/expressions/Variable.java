package ast.locatables.expressions;

import ast.locatables.definitions.Definition;
import visitor.Visitor;

import java.util.Objects;

public class Variable extends AbstractExpression {

    public String name;
    public Definition def;

    public Variable(String name, int row, int column) {
        super(row, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Variable [name=" + name
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Variable other = (Variable) obj;
        return Objects.equals(getName(), other.getName());
    }
}
