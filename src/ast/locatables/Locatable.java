package ast.locatables;

import ast.ASTNode;

public interface Locatable extends ASTNode {

    int getLine();
    int getColumn();
}
