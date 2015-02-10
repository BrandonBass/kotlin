fun box(): String {

    val classInLambda = {
        class Z {}
        Z()
    }()

    val enclosingMethod = classInLambda.javaClass.getEnclosingMethod()
    if (enclosingMethod?.getName() != "invoke") return "method: $enclosingMethod"

    val enclosingClass = classInLambda.javaClass.getEnclosingClass()!!.getName()
    if (!enclosingClass.startsWith("_DefaultPackage\$") || !enclosingClass.endsWith("\$box\$classInLambda\$1")) return "enclosing class: $enclosingClass"

    val declaringClass = classInLambda.javaClass.getDeclaringClass()
    if (declaringClass != null) return "class has a declaring class"

    return "OK"
}
