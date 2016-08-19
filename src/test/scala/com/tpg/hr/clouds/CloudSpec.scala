package com.tpg.hr.clouds

import java.util.Optional

import com.tpg.hr.HackerRankSpec
import GameState.{CONTINUE, LOSE}

class CloudSpec extends HackerRankSpec {
  feature("cloud") {
    scenario("going from ordinary cloud to ordinary cloud continues game") {
      val c1 = new OrdinaryCloud()
      val c0 = new OrdinaryCloud(Optional.of(c1))

      val player = new Player("1", Optional.of(c0))
      val actual = player.jump

      actual should be(CONTINUE)
    }

    scenario("going from ordinary cloud to thunder cloud ends game") {
      val c2 = new OrdinaryCloud()
      val c1 = new ThunderCloud(Optional.of(c2))
      val c0 = new OrdinaryCloud(Optional.of(c1))

      val player = new Player("1", Optional.of(c0))
      val actual = player.jump

      actual should be(LOSE)
    }
  }
}
