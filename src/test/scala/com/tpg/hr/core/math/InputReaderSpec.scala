package com.tpg.hr.core.math

import java.io.ByteArrayInputStream
import java.util.Arrays._

import com.tpg.hr.HackerRankSpec

class InputReaderSpec extends HackerRankSpec {
  feature("input reader for matrix") {
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
  }
}
