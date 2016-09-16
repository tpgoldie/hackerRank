package com.tpg.hr.library

import java.util.Calendar

class SameMonthChargeSpec extends FineSpec {
  feature("Same month fine rule") {
    scenario("when book is returned after the expected return day but in the same calendar month and year " +
      "as the expected return date then fine is 15 hackos x the number of days late") {
      Given("actual return date is after expected return date")
      And("in the same calendar month and year")
      val actualDate = new ActualDate(2015, Calendar.APRIL, 28)
      val expectedDate = new ExpectedDate(2015, Calendar.APRIL, 25)

      When("applying the returns charge")
      val charge = new ApplyReturnsCharge(actualDate, expectedDate).getCharge

      Then("the fine is 15 hackos x the number of days late")
      charge.getFine.doubleValue should be ((15 * 3.0) +- 1e-2)
    }
  }
}
