package com.tpg.hr.stringcons;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class PString {
    private final CString theString;

    public PString() {
        this(new Empty());
    }

    public PString(CString theString) {
        this.theString = theString;
    }

    public PString addCharacter(char value) {
        return new PString(theString.addCharacter(new CCharacter(value)));
    }

    public PString addSubstring(CSubstring value) {
        return null;
    }

    public CString getTheString() {
        return theString;
    }

    @Override
    public boolean equals(Object that) {
        if (that == this) { return true; }
        if (!(that instanceof PString)) { return false; }

        PString other = (PString) that;

        return new EqualsBuilder().append(other.theString, this.theString)
            .isEquals();
    }

    @Override
    public int hashCode() {
        int result = 37;

        result = result * 31 + theString.hashCode();

        return result;
    }
}
