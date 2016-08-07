package com.tpg.hr.diagdiff

import java.io.ByteArrayInputStream
import java.util.Arrays.asList

import com.tpg.hr.HackerRankSpec

class InputReaderSpec extends HackerRankSpec {
  feature("read input") {
    scenario("read the number of test cases, followed by test cases input") {
      val input = "3\n" + "11 2 4\n4 5 6\n" + "10 8 -12\n"
      val is = new ByteArrayInputStream(input.getBytes)
      val reader = new InputReader(is)

      reader.getMatrixSize should be(3)

      val expected = new SquareMatrix(3)

      expected.addRow(0, asList(11, 2, 4))
      expected.addRow(1, asList(4, 5, 6))
      expected.addRow(2, asList(10, 8, -12))

      reader.getMatrix should equal(expected)
    }
  }
}
