package com.tpg.hr.clouds

import java.util.Optional

import com.tpg.hr.HackerRankSpec
import com.tpg.hr.clouds.GameState.{LOSE, WIN}

class CloudsSpec extends HackerRankSpec {
  feature("clouds game") {
    scenario("player wins game") {
      val c2 = new OrdinaryCloud()
      val c1 = new OrdinaryCloud(Optional.of(c2))
      val c0 = new OrdinaryCloud(Optional.of(c1))

      val clouds = new Clouds("1", Optional.of(c0))

      clouds.play

      clouds.getJumps should be(2)

      val gameState = clouds.play

      gameState should be(WIN)
    }

    scenario("player loses game") {
      val c2 = new OrdinaryCloud()
      val c1 = new ThunderCloud(Optional.of(c2))
      val c0 = new OrdinaryCloud(Optional.of(c1))

      val clouds = new Clouds("1", Optional.of(c0))

      val gameState = clouds.play

      clouds.getJumps should be(1)
      gameState should be(LOSE)
    }

    scenario("player wins game with thunder cloud present") {
      val c2 = new OrdinaryCloud()
      val c1 = new ThunderCloud(Optional.of(c2))
      val c0 = new OrdinaryCloud(Optional.of(c1))

      val clouds = new Clouds("1", Optional.of(c0))

      val gameState = clouds.play

      clouds.getJumps should be(2)
      gameState should be(WIN)
    }
  }
}
