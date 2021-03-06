package eu.simonbinder.kart.kernel.ast.statements

import eu.simonbinder.kart.kernel.ast.TreeVisitor
import eu.simonbinder.kart.kernel.utils.child

class LabeledStatement(
    body: Statement? = null
): Statement() {

    var body by child(body)

    override fun <T> accept(visitor: TreeVisitor<T>): T {
        return visitor.visitLabeledStatement(this)
    }

    override fun <T> visitChildren(visitor: TreeVisitor<T>) {
        body.accept(visitor)
    }

}