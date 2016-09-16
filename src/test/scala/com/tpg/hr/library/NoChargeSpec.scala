package com.tpg.hr.library

import java.util.Calendar

class NoChargeSpec extends FineSpec {
  feature("No charge") {

    scenario("when book is return before expected return date no fine applied") {
      Given("actual return date is before expected return date")
      val actualDate = new ActualDate(2015, Calendar.APRIL, 23)
      val expectedDate = new ExpectedDate(2015, Calendar.APRIL, 25)


      When("applying the returns charge")
      val charge = new ApplyReturnsCharge(actualDate, expectedDate).getCharge

      Then("the fine is zero")
      charge.getFine.doubleValue should be (0.0 +- 1e-2)
    }

    scenario("when book is return on the expected return date no fine applied") {
      Given("actual return date is the expected return date")
      val actualDate = new ActualDate(2015, Calendar.APRIL, 25)
      val expectedDate = new ExpectedDate(2015, Calendar.APRIL, 25)

      When("applying the returns charge")
      val charge = new ApplyReturnsCharge(actualDate, expectedDate).getCharge

      Then("the fine is zero")
      charge.getFine.doubleValue should be (0.0 +- 1e-2)
    }
  }
}
