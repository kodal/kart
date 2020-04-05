package eu.simonbinder.kart.kernel.members.initializers

import eu.simonbinder.kart.kernel.Reference
import eu.simonbinder.kart.kernel.TreeVisitor
import eu.simonbinder.kart.kernel.expressions.Expression
import eu.simonbinder.kart.kernel.utils.child

class FieldInitializer(
    var field: Reference? = null,
    value: Expression? = null
) : Initializer() {

    val value by child(value)

    override fun <T> accept(visitor: TreeVisitor<T>): T {
        return visitor.visitFieldInitializer(this)
    }

    override fun <T> visitChildren(visitor: TreeVisitor<T>) {
        value.accept(visitor)
    }

}