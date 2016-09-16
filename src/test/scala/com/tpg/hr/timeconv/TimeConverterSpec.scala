package com.tpg.hr.timeconv

import com.tpg.hr.HackerRankSpec

class TimeConverterSpec extends HackerRankSpec {
  feature("converting twelve hour into twenty four hour") {
    scenario("convert 12:00:00AM to twenty-four hour") {
      val actual = new TimeConverter()
      actual.convert("12:00:00AM") should be("00:00:00")
    }

    scenario("convert 12:59:59AM to twenty-four hour") {
      val actual = new TimeConverter()
      actual.convert("12:59:59AM") should be("00:59:59")
    }

    scenario("convert 11:43:37AM to twenty-four hour") {
      val actual = new TimeConverter()
      actual.convert("11:43:37AM") should be("11:43:37")
    }

    scenario("convert 12:43:37PM to twenty-four hour") {
      val actual = new TimeConverter()
      actual.convert("12:43:37PM") should be("12:43:37")
    }

    scenario("convert 01:45:56PM to twenty-four hour") {
      val actual = new TimeConverter()
      actual.convert("01:45:56PM") should be("13:45:56")
    }

    scenario("convert 11:45:56PM to twenty-four hour") {
      val actual = new TimeConverter()
      actual.convert("11:45:56PM") should be("23:45:56")
    }
  }
}
