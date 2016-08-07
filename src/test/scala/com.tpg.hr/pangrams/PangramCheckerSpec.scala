package com.tpg.hr.pangrams;

import com.tpg.hr.HackerRankSpec

class PangramCheckerSpec extends HackerRankSpec {
  feature("checking for pangram") {
    scenario("string is pangram") {
      Given("A string is a valid pangram")
      val input = "We promptly judged antique ivory buckles for the next prize"

      When("checked")
      val actual = new PangramChecker().check(input)

      Then("returns true")
      actual should be("pangram")
    }

    scenario("string is not pangram") {
      Given("A string is not a valid pangram")
      val input = "We promptly judged antique ivory buckles for the prize"

      When("checked")
      val actual = new PangramChecker().check(input)

      Then("returns false")
      actual should be("not pangram")
    }

    scenario("null string is not pangram") {
      Given("A null string is not a valid pangram")
      val input = null

      When("checked")
      val actual = new PangramChecker().check(input)

      Then("returns false")
      actual should be("not pangram")
    }

    scenario("empty string is not pangram") {
      Given("An empty string is not a valid pangram")
      val input = ""

      When("checked")
      val actual = new PangramChecker().check(input)

      Then("returns false")
      actual should be("not pangram")
    }
  }
}
