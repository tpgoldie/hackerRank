package com.tpg.hr.core.math

import java.io.ByteArrayInputStream
import java.util
import java.util.Arrays.asList

import com.tpg.hr.HackerRankSpec

class SquareMatrixSpec extends HackerRankSpec {
  feature("matrix input") {
    scenario("read input from input stream") {
      val is = new String("3\n7 1 3")

      val bais = new ByteArrayInputStream(is.getBytes)
      val actual = SquareMatrix.apply(bais)
      val expected = new SquareMatrix(3)

      0 until 3 foreach { i =>
        expected.addRow(i, asList(7, 1, 3))
      }

      actual should be(expected)
    }

    scenario("read the number of test cases, followed by test cases input") {
      val input = "3\n11 2 4\n4 5 6\n10 8 -12"

      val is = new ByteArrayInputStream(input.getBytes)
      val matrix: SquareMatrix = SquareMatrix.apply(is)

      val expected = new SquareMatrix(3)

      expected.addRow(0, asList(11, 2, 4))
      expected.addRow(1, asList(4, 5, 6))
      expected.addRow(2, asList(10, 8, -12))

      matrix should equal(expected)
    }

    scenario("summing diagonals") {
      val actual = new SquareMatrix(2)
      actual.addRow(0, util.Arrays.asList(2, -1))
      actual.addRow(1, util.Arrays.asList(0, 4))

      actual.getMainDiagonalSum() should be(6)
      actual.getSecondaryDiagonalSum() should be(-1)
    }
  }
}
