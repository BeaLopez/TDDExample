package com.blopez.tddexample.model

/**
 * Created by b.lopez.morales on 14/12/17.
 */
interface DirectionableInterface{
    fun turnRight() : Orientation
    fun turnLeft() : Orientation
    fun getCurrentOrientation(): Orientation
}