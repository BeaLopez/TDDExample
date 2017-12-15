package com.blopez.tddexample.model

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test

/**
 * Created by b.lopez.morales on 14/12/17.
 */
class OrientationTest {

    lateinit var sut: Orientation

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun turnRightFromNorthReturnEast() {
        //Arrange
        sut = Orientation.NORTH
        //Act
        sut = sut.turnRight()
        //Assert
        assertEquals(Orientation.EAST, sut)
    }


    @Test
    fun turnRightFromEastReturnSouth() {
        //Arrange
        sut = Orientation.EAST
        //Act
        sut = sut.turnRight()
        //Assert
        assertEquals(Orientation.SOUTH, sut)
    }

    @Test
    fun turnRightFromSouthReturnWest() {
        //Arrange
        sut = Orientation.SOUTH
        //Act
        sut = sut.turnRight()
        //Assert
        assertEquals(Orientation.WEST, sut)
    }

    @Test
    fun turnRightFromWestReturnNorth() {
        //Arrange
        sut = Orientation.WEST
        //Act
        sut = sut.turnRight()
        //Assert
        assertEquals(Orientation.NORTH, sut)
    }
}