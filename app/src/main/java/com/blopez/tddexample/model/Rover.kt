package com.blopez.tddexample.model

/**
 * Created by b.lopez.morales on 14/12/17.
 */
class Rover(var x: Int = DEFAULT_X, var y: Int = DEFAULT_Y, var direction: DirectionableInterface = Orientation.NORTH){

    companion object {
        const val DEFAULT_X = 0
        const val DEFAULT_Y = 0
        val DEFAULT_DIRECTION = Orientation.NORTH
    }

    fun applyCommand(command: String) {

        for (character in command){

            when(character){
                'R' -> direction = direction.turnRight()
                'L' -> direction = direction.turnLeft()
                'F' -> {
                    when(direction){
                        Orientation.NORTH -> y += 1
                        Orientation.SOUTH -> y -= 1
                        Orientation.EAST -> x += 1
                        Orientation.WEST -> x -=1
                    }
                }
            }

        }
    }
}