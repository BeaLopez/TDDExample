package com.blopez.tddexample.model

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test
import org.junit.runners.Parameterized

/**
 * Created by b.lopez.morales on 14/12/17.
 */
class RoverTest {

    lateinit var sut: Rover
    val TEST_X = 5
    val TEST_Y = 6
    val TEST_DIRECTION = Orientation.NORTH

    inner class DirectionMock: DirectionableInterface{

        var turnRightCalled = false
        var turnLeftCalled = false
        var orientation: Orientation = Orientation.NORTH

        override fun turnRight(): Orientation {
            turnRightCalled = true
            return orientation
        }

        override fun turnLeft(): Orientation {
            turnLeftCalled = true
            return orientation
        }

        override fun getCurrentOrientation(): Orientation {
            return orientation
        }
    }

    @Before
    fun setUp() {
        sut = Rover()
    }

    @After
    fun tearDown() {
        sut = Rover()
    }

    @Test
    fun sutNotNull() {
        assertNotNull(sut)
    }

    @Test
    fun initialDefaultXPositionIs0() {
        assertEquals(0, Rover.DEFAULT_X)
    }

    @Test
    fun initialDefaultYPositionIs0() {
        assertEquals(0, Rover.DEFAULT_Y)
    }

    @Test
    fun initialRoverIsAtDefaultX() {
        assertEquals(Rover.DEFAULT_X, sut.x)
    }

    @Test
    fun initialRoverIsAtDefaultY() {
        assertEquals(Rover.DEFAULT_Y, sut.y)
    }

    @Test
    fun initialRoverPositionXIs5() {
        //Arrange
        sut = Rover(x=TEST_X)
        //Act

        //Assert
        assertEquals(TEST_X,sut.x)
    }

    @Test
    fun initialRoverPositionYIs6() {
        //Arrange
        sut = Rover(y=TEST_Y)
        //Act

        //Assert
        assertEquals(TEST_Y,sut.y)
    }

    @Test
    fun initialRoverDefaultDirectionIsN() {
        //Arrange

        //Act

        //Assert
        assertEquals(TEST_DIRECTION, Rover.DEFAULT_DIRECTION)
    }

    @Test
    fun initialRoverDirectionIsDefault() {
        //Arrange

        //Act

        //Assert
        assertEquals(TEST_DIRECTION, sut.direction)
    }

    @Test
    fun initialRoverDirectionIsN() {
        //Arrange
        sut = Rover(direction = Orientation.NORTH)
        //Act

        //Assert
        assertEquals(TEST_DIRECTION, sut.direction)
    }

    @Ignore
    @Test
    fun roverApplyCommandRigthChangeDirectionToEast() {
        //Arrange

        //Act
        sut.applyCommand(command = "R")
        //Assert
        assertEquals(Orientation.EAST, sut.direction)
    }

    @Ignore
    @Test
    fun roverApplyCommandRRChangeDirectionToSouth() {
        //Arrange

        //Act
        sut.applyCommand(command = "RR")

        //Assert
        assertEquals(Orientation.SOUTH, sut.direction)
    }

    @Ignore
    @Test
    fun roverApplyCommandRRRChangeDirectionToEast() {
        //Arrange

        //Act
        sut.applyCommand(command = "RRR")

        //Assert
        assertEquals(Orientation.WEST, sut.direction)
    }

    @Ignore
    @Test
    fun roverApplyCommandRRRRChangeDirectionToNorth() {
        //Arrange

        //Act
        sut.applyCommand(command = "RRRR")

        //Assert
        assertEquals(Orientation.NORTH, sut.direction)
    }

    @Ignore
    @Test
    fun directionRightInvoked() {
        //Arrange
        var directionMock = DirectionMock()

        //Act
        sut.direction= directionMock
        sut.applyCommand("R")

        //Assert
        assertTrue(directionMock.turnRightCalled)
    }

    @Test
    fun moveForwardFromDefaultStateIcrementsY() {
        //Arrange
        val expected = Rover.DEFAULT_Y + 1
        //Act
        sut.applyCommand("F")
        //Assert
        assertEquals(expected, sut.y)
        assertEquals(0, sut.x)
    }

    @Test
    fun moveForwardFromInitialStateIcrementsY() {
        //Arrange
        val initital = 10
        val expected = initital + 1
        sut = Rover(0,initital)
        //Act
        sut.applyCommand("F")
        //Assert
        assertEquals(expected, sut.y)
        assertEquals(0, sut.x)
    }

    @Test
    fun moveForwardFromEastStateIcrementsX() {
        //Arrange
        sut = Rover(0,0, Orientation.EAST)
        val expected = Rover.DEFAULT_X + 1
        //Act
        sut.applyCommand("F")
        //Assert
        assertEquals(0, sut.y)
        assertEquals(expected, sut.x)
    }

    @Test
    fun moveForwardFromWestStateDecrementsX() {
        //Arrange
        sut = Rover(0,0, Orientation.WEST)
        val expected = Rover.DEFAULT_X - 1
        //Act
        sut.applyCommand("F")
        //Assert
        assertEquals(0, sut.y)
        assertEquals(expected, sut.x)
    }

    @Test
    fun moveForwardFromSouthStateDecrementsY() {
        //Arrange
        sut = Rover(0,0, Orientation.SOUTH)
        val expected = Rover.DEFAULT_Y - 1
        //Act
        sut.applyCommand("F")
        //Assert
        assertEquals(expected, sut.y)
        assertEquals(0, sut.x)
    }

}