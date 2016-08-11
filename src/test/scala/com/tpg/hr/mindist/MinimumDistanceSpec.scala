package com.tpg.hr.mindist

import java.io.ByteArrayInputStream

import com.tpg.hr.HackerRankSpec

class MinimumDistanceSpec extends HackerRankSpec {
  feature("minimum distance") {
    scenario("calculate the minimum distance") {
      val input = "6\n7 1 3 4 1 7"

      val is = new ByteArrayInputStream(input.getBytes)
      val actual: MinimumDistance = new MinimumDistance(is)

      actual.getValue should be(3)
    }
  }
}
