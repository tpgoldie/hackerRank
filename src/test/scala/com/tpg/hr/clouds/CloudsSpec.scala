package com.tpg.hr.clouds

import java.util.Optional

import com.tpg.hr.HackerRankSpec

class CloudsSpec extends HackerRankSpec {
  feature("clouds game") {
    scenario("jumps count with no thunder clouds") {
      val c2 = new OrdinaryCloud()
      val c1 = new OrdinaryCloud(Optional.of(c2))
      val c0 = new OrdinaryCloud(Optional.of(c1))

      val clouds = new Clouds("1", Optional.of(c0))

      clouds.start

      clouds.getJumps should be(2)
    }
  }
}
