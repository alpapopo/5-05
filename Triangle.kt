import kotlin.math.sqrt
import kotlin.math.abs

class Triangle(a: Point, b: Point, c: Point) {
    val a = a
    val b = b
    val c = c

    // Функция для вычисления длины стороны между двумя точками
    private fun sideLength(p1: Point, p2: Point): Double {
        val dx = p2.x - p1.x
        val dy = p2.y - p1.y
        return sqrt(dx * dx + dy * dy)
    }

    // Функция для вычисления центра вписанной окружности (инцентра)
    fun incenter(): Point {
        val sideA = sideLength(b, c) // сторона напротив точки a
        val sideB = sideLength(a, c) // напротив b
        val sideC = sideLength(a, b) // напротив c

        val perimeter = sideA + sideB + sideC

        // Координаты центра — средневзвешенное по длинам сторон
        val x = (sideA * a.x + sideB * b.x + sideC * c.x) / perimeter
        val y = (sideA * a.y + sideB * b.y + sideC * c.y) / perimeter

        return Point(x, y)
    }

    // Функция для вычисления расстояния от точки до прямой (стороны)
    private fun distancePointToLine(p: Point, lineStart: Point, lineEnd: Point): Double {
        val A = lineEnd.y - lineStart.y
        val B = lineStart.x - lineEnd.x
        val C = lineEnd.x * lineStart.y - lineStart.x * lineEnd.y
        return abs(A * p.x + B * p.y + C) / sqrt(A * A + B * B)
    }

    // Радиус вписанной окружности — расстояние от центра до любой стороны
    fun inradius(): Double {
        val center = incenter()
        // Выбираем сторону BC для вычисления расстояния
        return distancePointToLine(center, b, c)
    }
}
