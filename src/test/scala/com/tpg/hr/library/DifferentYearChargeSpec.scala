package com.tpg.hr.library

import java.util.Calendar

class DifferentYearChargeSpec extends FineSpec {
  feature("Different year charge") {
    scenario("when book is returned after the expected return year then the fins is 10000 hackos") {
      Given("actual return date is after expected return date")
      And("in a different calendar year")
      val actualDate = new ActualDate(2017, Calendar.SEPTEMBER, 13)
      val expectedDate = new ExpectedDate(2015, Calendar.APRIL, 25)

      When("applying the returns charge")
      val charge = new ApplyReturnsCharge(actualDate, expectedDate).getCharge

      Then("the fine is 10000 hackos")
      charge.getFine.doubleValue should be (10000.0 +- 1e-2)
    }
  }
}
