package com.blopez.tddexample.model

/**
 * Created by b.lopez.morales on 14/12/17.
 */
enum class Orientation : DirectionableInterface{
    NORTH, SOUTH, WEST, EAST;

    override fun turnRight(): Orientation =

        when(this){
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            else -> NORTH
        }

    override fun turnLeft(): Orientation =

        when(this){
            NORTH -> WEST
            WEST -> SOUTH
            SOUTH -> EAST
            else -> NORTH
        }

    override fun getCurrentOrientation(): Orientation {
        return this
    }
}