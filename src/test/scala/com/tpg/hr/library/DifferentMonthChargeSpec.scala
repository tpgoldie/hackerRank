package com.tpg.hr.library

import java.util.Calendar

class DifferentMonthChargeSpec extends FineSpec {
  feature("Different month charge") {
    scenario("when book is returned after the expected return month but still within the same calendar year " +
      "as the expected return date then fine is 500 hackos x the number of months late") {
      Given("actual return date is after expected return date")
      And("in a different calendar month but same calendar year")
      val actualDate = new ActualDate(2015, Calendar.SEPTEMBER, 13)
      val expectedDate = new ExpectedDate(2015, Calendar.APRIL, 25)

      When("applying the returns charge")
      val charge = new ApplyReturnsCharge(actualDate, expectedDate).getCharge

      Then("the fine is 500 hackos x the number of months late")
      charge.getFine.doubleValue should be ((500 * 5.0) +- 1e-2)
    }
  }
}
