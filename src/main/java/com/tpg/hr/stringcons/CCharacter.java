package com.tpg.hr.stringcons;

import static java.util.Optional.of;

public class CCharacter implements CString {
    private final char value;

    public CCharacter(char value) {
        this.value = value;
    }

    public char getTheCharacter() {
        return value;
    }

    @Override
    public CString addCharacter(CCharacter character) {
        CSubstring substring = new NonEmpty(this);
        return new NonEmpty(character, of(substring));
    }

    @Override
    public boolean equals(Object that) {
        if (that == this) { return true; }
        if (!(that instanceof CCharacter)) { return false; }

        CCharacter other = (CCharacter) that;
        return (other.value == this.value);
    }

    @Override
    public int hashCode() {
        int result = 37;
        result = result * 31 + (int) value;
        return result;
    }
}
