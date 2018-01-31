package com.infinite.androidtest

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by kfzhangxu on 2018/1/31.
 */
class CalculatorTest {
    private lateinit var calculator:Calculator
    @Before
    fun setUp() {
        calculator= Calculator()
    }

    @Test
    fun add() {
        assertEquals(9F,calculator.add(4F,5F))
    }

    @Test
    fun minus() {
        assertEquals(3F,calculator.minus(8F,5F))
    }

}