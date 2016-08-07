package com.tpg.hr.diagdiff

import java.util

import com.tpg.hr.HackerRankSpec

class SquareMatrixSpec extends HackerRankSpec {
  feature("matrix") {
    scenario("summing diagonals") {
      val actual = new SquareMatrix(2)
      actual.addRow(0, util.Arrays.asList(2, -1))
      actual.addRow(1, util.Arrays.asList(0, 4))

      actual.getMainDiagonalSum() should be(6)
      actual.getSecondaryDiagonalSum() should be(-1)
    }
  }
}
