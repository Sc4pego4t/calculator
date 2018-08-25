package ru.scapegoats.calc

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import kotlin.math.pow

@RunWith(AndroidJUnit4::class)
class UnitCalcTest {

    @get:Rule
    val mActivityRule: ActivityTestRule<Calc> = ActivityTestRule(Calc::class.java)
    var mActivity: Calc? =null

    @Before
    fun setUp() {
        mActivity=mActivityRule.activity

    }
    @Test
    fun plusTest(){
        mActivity?.prevNumber = 1.0
        mActivity?.number=5.0
        mActivity?.operationState=OperationState.PLUS
        mActivity?.applyOperation()

        assertEquals(mActivity?.prevNumber,1.0+5.0)
        assertEquals(mActivity?.number,0.0)
    }

    @Test
    fun minusTest(){
        mActivity?.prevNumber = 1.0
        mActivity?.number=5.0
        mActivity?.operationState=OperationState.MINUS
        mActivity?.applyOperation()

        assertEquals(mActivity?.prevNumber,1.0-5.0)
        assertEquals(mActivity?.number,0.0)
    }
    @Test
    fun divideTest(){
        mActivity?.prevNumber = 1.0
        mActivity?.number=5.0
        mActivity?.operationState=OperationState.DIVIDE
        mActivity?.applyOperation()

        assertEquals(mActivity?.prevNumber,1.0/5.0)
        assertEquals(mActivity?.number,0.0)
    }
    @Test
    fun multuplyTest(){
        mActivity?.prevNumber = 1.0
        mActivity?.number=5.0
        mActivity?.operationState=OperationState.MULTIPLY
        mActivity?.applyOperation()

        assertEquals(mActivity?.prevNumber,1.0*5.0)
        assertEquals(mActivity?.number,0.0)
    }

    @Test
    fun decreaseToDecimalTest(){
        assertEquals(mActivity?.decreaseToDecimal(3,9.0),9.0/10.0.pow(3))
    }

    @After
    fun tearDown() {
        mActivity=null
    }
}