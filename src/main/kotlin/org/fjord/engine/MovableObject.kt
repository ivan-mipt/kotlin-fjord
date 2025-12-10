package org.fjord.engine

import org.fjord.engine.math.Vector2
import kotlinx.coroutines.*

open class MovableObject(
    override var canInteract: Boolean = true,
    override val id: Int = 0,
    override var movable: Boolean = true,
    override var name: String = "Moving Fjørd",
    override var position: Vector2 = Vector2(0f, 0f),
    override var velocity: Vector2 = Vector2(1f, 0f)
) : GameObject {

    val speed: Float = 100f
    private var accumulator = 0f
    private val fixedDeltaTime = 1f / 60f

    override fun update(deltaTime: Float) {
        accumulator += deltaTime

        while (accumulator >= fixedDeltaTime) {
            fixedUpdate(fixedDeltaTime)
        }
    }

    fun fixedUpdate(deltaTime: Float) {
        velocity = Vector2(0f, 0f)

        if (RawInput.isKeyPressed(Keys.D) || RawInput.isKeyPressed(Keys.RIGHT)) {
            velocity.x = speed
        }

        if (RawInput.isKeyPressed(Keys.A) || RawInput.isKeyPressed(Keys.LEFT)) {
            velocity.x = -speed
        }

        if (RawInput.isKeyPressed(Keys.A) && RawInput.isKeyPressed(Keys.D)) {
            velocity.x = 0f
        }

        if (RawInput.isKeyPressed(Keys.LEFT) && RawInput.isKeyPressed(Keys.RIGHT)) {
            velocity.x = 0f
        }

        position += velocity * deltaTime
    }

    override fun render() {
        println("Fjørd er mørk")
    }
}