package com.tpg.hr.plusminus

import java.io.ByteArrayInputStream

import com.tpg.hr.HackerRankSpec

class PlusMinusSpec extends HackerRankSpec {
  feature("plus minus") {
    scenario("calculate count of positive integers") {
      val input = new ByteArrayInputStream("6\n-4 3 -9 0 4 1".getBytes)
      val actual = PlusMinus.apply(input);

      actual.positiveIntegers() should be (3)
    }

    scenario("calculate count of negative integers") {
      val input = new ByteArrayInputStream("6\n-4 3 -9 0 4 1".getBytes)
      val actual = PlusMinus.apply(input);

      actual.negativeIntegers() should be (2)
    }

    scenario("calculate count of zeros") {
      val input = new ByteArrayInputStream("6\n-4 3 -9 0 4 1".getBytes)
      val actual = PlusMinus.apply(input);

      actual.zeroes() should be (1)
    }
  }
}
