package ast.locatables.expressions;

public class AbstractBinaryExpression extends AbstractExpression {

    public String operatorName;
    public Expression leftOperand;
    public Expression rightOperand;

    public AbstractBinaryExpression(String opName, Expression leftOperand, Expression rightOperand, int row, int column) {
        super(row, column);
        this.operatorName = opName;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public Expression getLeftOperand() {
        return leftOperand;
    }

    public Expression getRightOperand() {
        return rightOperand;
    }
}
