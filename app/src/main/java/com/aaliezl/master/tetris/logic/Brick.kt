package com.aaliezl.master.tetris.logic

import androidx.compose.ui.geometry.Offset

data class Brick(val location: Offset = Offset.Zero) {

    companion object {
        private fun of(offsets: List<Offset>) = offsets.map(::Brick)

        fun of(spirit: Spirit) = of(spirit.location)

        fun of(xRange: IntRange, yRange: IntRange) =
            of(xRange.flatMap { x -> yRange.map { y -> Offset(x.toFloat(), y.toFloat()) } })
    }

    fun offsetBy(step: Pair<Int, Int>) =
        copy(location = Offset(location.x + step.first, location.y + step.second))
}
