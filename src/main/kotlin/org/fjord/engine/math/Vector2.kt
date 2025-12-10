package org.fjord.engine.math

class Vector2(var x: Float = 0f, var y: Float = 0f) {
    fun getPos(): String {
        return "Point is on ${this.x} by x and on ${this.y} by y.".toString()
    }

    operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)
    operator fun minus(other: Vector2) = Vector2(x - other.x, y - other.y)
    operator fun times(scalar: Float) = Vector2(x * scalar, y * scalar)
}