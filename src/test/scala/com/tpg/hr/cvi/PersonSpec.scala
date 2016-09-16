package com.tpg.hr.cvi

import java.io.{BufferedOutputStream, ByteArrayOutputStream, OutputStream}

import com.tpg.hr.HackerRankSpec

class PersonSpec extends HackerRankSpec {
  feature("person") {
    scenario("age is positive") {
      val actual = new Person(25)
      actual.getAge > 0 should be(true)
    }

    scenario("age is negative") {
      val os = new ByteArrayOutputStream()

      val actual = new Person(-25, new BufferedOutputStream((os)))
      actual.getAge should be(0)
      os.toString should be("Age is not valid, setting age to 0.")
    }

    scenario("age is zero") {
      val os = new ByteArrayOutputStream()

      val actual = new Person(0, new BufferedOutputStream((os)))
      actual.getAge should be(0)
      os.toString should be("Age is not valid, setting age to 0.")
    }

    scenario("year passes") {
      val actual = new Person(25)
      actual.yearPasses() should be(26)
    }

    scenario("if age < 13 print 'You are young.'") {
      val os = new ByteArrayOutputStream()

      val actual = new Person(12, new BufferedOutputStream((os)))

      actual.amIOld()

      os.toString should be("You are young.")
    }

    scenario("if age equals 13 print 'You are a teenager.'") {
      val os = new ByteArrayOutputStream()

      val actual = new Person(13, new BufferedOutputStream((os)))

      actual.amIOld()

      os.toString should be("You are a teenager.")
    }

    scenario("if age less than 18 print 'You are a teenager.'") {
      val os = new ByteArrayOutputStream()

      val actual = new Person(17, new BufferedOutputStream((os)))

      actual.amIOld()

      os.toString should be("You are a teenager.")
    }

    scenario("if age equals 18 print 'You are old.'") {
      val os = new ByteArrayOutputStream()

      val actual = new Person(18, new BufferedOutputStream((os)))

      actual.amIOld()

      os.toString should be("You are old.")
    }

    scenario("if age > 18 print 'You are old.'") {
      val os = new ByteArrayOutputStream()

      val actual = new Person(19, new BufferedOutputStream((os)))

      actual.amIOld()

      os.toString should be("You are old.")
    }
  }
}
