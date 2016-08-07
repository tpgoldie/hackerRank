package com.tpg.hr.stringcons;

import static java.util.Optional.empty;

public class Empty extends CSubstring {
    public Empty() {
        super(empty(), empty());
    }

    @Override
    public CString addCharacter(CCharacter character) {
        return new NonEmpty(character);
    }

    @Override
    public boolean equals(Object that) {
        if (that == this) { return true; }
        if (!(that instanceof Empty)) { return false; }
        if (!(super.equals(that))) { return false; }

        return true;
    }
}
