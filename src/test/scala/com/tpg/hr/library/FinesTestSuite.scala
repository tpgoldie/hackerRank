package com.tpg.hr.library

import java.io.{ByteArrayOutputStream, ByteArrayInputStream}

import org.scalatest.{Matchers, FunSuite}

class FinesTestSuite extends FunSuite with Matchers {
  test("Return a same month charge") {
    val input = new ByteArrayInputStream(("9 6 2015" + "\n" + "6 6 2015").getBytes);

    val solution = new Solution(input);

    val baos : ByteArrayOutputStream = new ByteArrayOutputStream();

    val actual = solution.solve();

    actual should be(45)
  }

  test("Return no charge") {
    val input = new ByteArrayInputStream(("31 12 2009" + "\n" + "1 1 2010").getBytes);

    val solution = new Solution(input);

    val baos : ByteArrayOutputStream = new ByteArrayOutputStream();

    val actual = solution.solve();

    actual should be(0)
  }
}
