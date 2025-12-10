package org.fjord.engine

import org.fjord.engine.math.*

interface GameObject {
    var name: String
    val id: Int
    var position: Vector2
    var velocity: Vector2
    var movable: Boolean
    var canInteract: Boolean
    fun render()
    fun update(deltaTime: Float = 1f / 60f)
}