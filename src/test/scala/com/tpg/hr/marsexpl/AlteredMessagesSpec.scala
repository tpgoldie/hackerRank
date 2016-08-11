package com.tpg.hr.marsexpl

import com.tpg.hr.HackerRankSpec

class AlteredMessagesSpec extends HackerRankSpec {
  feature("mars exploration") {
    scenario("count altered messages") {
      val input = "SOSOOSOSOSOSOSSOSOSOSOSOSOS"

      val actual = new AlteredMessages(input)
      actual.getValue should be(12)
    }
  }
}
