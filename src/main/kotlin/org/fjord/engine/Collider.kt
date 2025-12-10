package org.fjord.engine

import org.fjord.engine.math.Vector2

interface Collider {
    var width: Float
    var length: Float
    val position: Vector2

    fun checkCollisions(other: Collider) : Boolean
    fun onCollide(other: Collider)
}