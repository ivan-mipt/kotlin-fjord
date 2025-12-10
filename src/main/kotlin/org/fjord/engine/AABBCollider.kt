package org.fjord.engine

import org.fjord.engine.math.Vector2

class AABBCollider(
    override var length: Float,
    override var width: Float,
    override val position: Vector2
) : Collider {
    override fun checkCollisions(other: Collider): Boolean {
        return position.x < other.position.x + other.width &&
                position.x + width > other.position.x &&
                position.y < other.position.y + other.length &&
                position.y + length > other.position.y
    }

    override fun onCollide(other: Collider) {
        if (checkCollisions(other) == true) {
            println("Something collides with something!")
        }
    }
}