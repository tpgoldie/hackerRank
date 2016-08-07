package com.tpg.hr.angryprof

import java.io.ByteArrayInputStream
import java.util

import com.tpg.hr.HackerRankSpec

class SolutionSpec extends HackerRankSpec {
  feature("run test data") {
    scenario("test case 10") {
      val is = new ByteArrayInputStream(TestDataTen.DataInputStream.getBytes)
      val solution = new Solution(is)
      val actual = solution.classesCancelled()

      val values: util.ArrayList[String] = new util.ArrayList()

      (List("YES", "NO", "YES", "NO") ++ List.fill(4)("NO") ++ List("YES", "NO")) foreach { v => values.add(v) }
      actual should be(values)
    }
  }
}
