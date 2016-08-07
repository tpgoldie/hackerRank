package com.tpg.hr.divisiblesumpairs

import com.tpg.hr.HackerRankSpec

class DivisibleSumPairsSpec extends HackerRankSpec {
  feature("divisible sum pairs") {
    scenario("selects pairs where i < j and sum is divisible by k") {
      val array: Array[Int] = Array(4, 5, 6)
      val dsp = new DivisibleSumPairs(array, 2)

      val actual = dsp.pair(0, 2)

      assertProperties(actual , new Pair(4, 6), true, true)
    }

    scenario("selects pairs where i >= j and sum is divisible by k") {
      val array: Array[Int] = Array(4, 5, 6)
      val dsp = new DivisibleSumPairs(array, 2)

      val actual = dsp.pair(2, 0)

      assertProperties(actual , new Pair(6, 4), false, true)
    }

    scenario("selects pairs where i < j and sum is not divisible by k") {
      val array: Array[Int] = Array(4, 5, 6)
      val dsp = new DivisibleSumPairs(array, 2)

      val actual = dsp.pair(1, 2)

      assertProperties(actual , new Pair(5, 6), true, false)
    }

    scenario("selects pairs where i >= j and sum is not divisible by k") {
      val array: Array[Int] = Array(4, 5, 6)
      val dsp = new DivisibleSumPairs(array, 2)

      val actual = dsp.pair(2, 1)

      assertProperties(actual , new Pair(6, 5), false, false)
    }

    scenario("count pairs where i < j and sum is divisible by k") {
      val array: Array[Int] = Array(4, 5, 6, 7, 8)
      val dsp = new DivisibleSumPairs(array, 2)

      dsp.count should be(4)
    }

    scenario("count pairs where i < j and sum is divisible by 3 for array 1 3 2 6 1 2") {
      val array: Array[Int] = Array(1, 3, 2, 6, 1, 2)
      val dsp = new DivisibleSumPairs(array, 3)

      dsp.count should be(5)
    }

    scenario("count pairs where i < j and sum is divisible by 22 for large array") {
      val data = "43 95 51 55 40 86 65 81 51 20 47 50 65 53 23 78 75 75 47 73 25 27 14 8 26 58 95 28 3 23 48 69 26 3 73 52 34 7 40 33 56 98 71 29 70 71 28 12 18 49 19 25 2 18 15 41 51 42 46 19 98 56 54 98 72 25 16 49 34 99 48 93 64 44 50 91 44 17 63 27 3 65 75 19 68 30 43 37 72 54 82 92 37 52 72 62 3 88 82 71".split(" ")
      val values = data map { d => BigDecimal(d.trim).toInt }

      val array: Array[Int] = values.toList.toArray

      val dsp = new DivisibleSumPairs(array, 22)

      dsp.count should be(216)
    }

    scenario("zero count of pairs when array is invalid") {
      val dsp = new DivisibleSumPairs(null, 3)

      dsp.count should be(0)
    }

    scenario("zero count of pairs when array is empty") {
      val dsp = new DivisibleSumPairs(Array(1, 2), 0)

      dsp.count should be(0)
    }

    scenario("handle when k is zero") {
      val dsp = new DivisibleSumPairs(Array(), 0)

      dsp.count should be(0)
    }
  }

  private def assertProperties(actual: Pair, expected: Pair, isLessThan: Boolean, isDivisibleByK: Boolean) = {
    actual should be(expected)
    actual.getLeft < actual.getRight should be(isLessThan)
    actual.isDivisibleBy(2) should be(isDivisibleByK)
  }
}
