package com.tpg.hr.stringcons;

import java.util.Optional

import com.tpg.hr.HackerRankSpec;

class PStringSpec extends HackerRankSpec {
  feature("p string construction") {
    scenario("can add a single character") {
      val actual = new PString().addCharacter('e')

      actual should have(
        'getTheString (new NonEmpty(new CCharacter('e')))
      )
    }

    ignore("can add a substring") {
      val e = new CCharacter('e')

      val m = new CCharacter('m')
      val me = new NonEmpty(m, Optional.of(new NonEmpty(e)))

      val r = new CCharacter('r')

      val actual = new PString(new NonEmpty(r)).addSubstring(me)

      actual should have(
        'getTheString(new NonEmpty(r, Optional.of(me)))
      )
    }
  }
}
