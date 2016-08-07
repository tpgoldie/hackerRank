package com.tpg.hr.angryprof

import com.tpg.hr.HackerRankSpec

class TestCaseSpec extends HackerRankSpec {
  feature("tests whether a class should be cancelled") {
    scenario("class not cancelled when number of students on time is greater than cancellation threshold") {
      val actual = new TestCase(4, 3, Array(-1, -3, -2, 0, 4, 2))
      actual.classCancelled should be("NO")
    }

    scenario("class not cancelled when number of students on time equals cancellation threshold") {
      val actual = new TestCase(4, 3, Array(-1, -3, 0, 2, 4, 2))
      actual.classCancelled should be("NO")
    }

    scenario("class cancelled when number of students on time is less than threshold") {
      val actual = new TestCase(4, 3, Array(1, -3, 2, 0, 2))
      actual.classCancelled should be("YES")
    }
  }
}
