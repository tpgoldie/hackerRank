package com.tpg.hr.angryprof;

import java.io.ByteArrayInputStream
import java.util

import com.tpg.hr.HackerRankSpec;

class InputReaderSpec extends HackerRankSpec {
  feature("read input") {
    scenario("read the number of test cases, followed by test cases input") {
      val input = "2\n" + "4 3\n-1 -3 4 2\n" + "4 2\n0 -1 2 1\n"
      val is = new ByteArrayInputStream(input.getBytes)
      val reader = new InputReader(is)

      reader.getNumberOfTestCases should be(2)

      val expected: util.ArrayList[TestCase] = new util.ArrayList()
      expected.add(new TestCase(4, 3, Array(-1, -3, 4, 2)))
      expected.add(new TestCase(4, 2, Array(0, -1, 2, 1)))

      reader.getTestCases should equal(expected)
    }
  }
}
