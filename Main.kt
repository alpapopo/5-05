fun main() {
    println("Введите координату x точки №1:")
    val x1 = readLine()!!.toDouble()
    println("Введите координату y точки №1:")
    val y1 = readLine()!!.toDouble()
    val p1 = Point(x1, y1)

    println("Введите координату x точки №2:")
    val x2 = readLine()!!.toDouble()
    println("Введите координату y точки №2:")
    val y2 = readLine()!!.toDouble()
    val p2 = Point(x2, y2)

    println("Введите координату x точки №3:")
    val x3 = readLine()!!.toDouble()
    println("Введите координату y точки №3:")
    val y3 = readLine()!!.toDouble()
    val p3 = Point(x3, y3)

    val triangle = Triangle(p1, p2, p3)

    val center = triangle.incenter()
    val radius = triangle.inradius()

    println("Центр вписанной окружности: (${center.x}, ${center.y})")
    println("Радиус вписанной окружности: $radius")
}
