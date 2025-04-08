package ast;

import semantic.Visitor;

public interface ASTNode {

    public <TP, TR> TR accept(Visitor<TP, TR> v, TP paramType);
}
