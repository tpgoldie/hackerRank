package com.tpg.hr.stringcons;

import java.util.Optional;

import static java.util.Optional.of;

public class NonEmpty extends CSubstring {
    public NonEmpty(CCharacter character) {
        this(character, of(new Empty()));
    }

    public NonEmpty(CCharacter character, Optional<CSubstring> substring) {
        super(of(character), substring);
    }

    @Override
    public CString addCharacter(CCharacter character) {
        return new NonEmpty(character, of(this));
    }

    @Override
    public boolean equals(Object that) {
        if (that == this) { return true; }
        if (!(that instanceof NonEmpty)) { return false; }
        if (!(super.equals(that))) { return false; }

        return true;
    }
}
