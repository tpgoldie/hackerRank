package com.tpg.hr.stringcons;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Optional;

import static java.lang.String.format;

public abstract class CSubstring implements CString {
    private final Optional<CCharacter> character;
    private final Optional<CSubstring> substring;

    public CSubstring(Optional<CCharacter> character, Optional<CSubstring> substring) {
        this.character = character;
        this.substring = substring;
    }

    @Override
    public String toString() {
        String s1 = character.isPresent() ? format("%c", character.get().getTheCharacter()) : "";
        String s2 = substring.isPresent() ? format("%s", substring.get().toString()) : "";

        return format("%s %s", s1, s2);
    }

    @Override
    public boolean equals(Object that) {
        if (that == this) { return true; }
        if (!(that instanceof CSubstring)) { return false; }

        CSubstring other = (CSubstring) that;

        return new EqualsBuilder().append(other.character.isPresent() ? other.character.get() : null,
                this.character.isPresent() ? this.character.get() : null)
            .append(other.substring.isPresent() ? other.substring.get() : null,
                this.character.isPresent() ? this.substring.get() : null)
            .isEquals();
    }

    @Override
    public int hashCode() {
        int result = 37;

        result = result * 31 + (character.isPresent() ? character.get().hashCode() : 0);
        result = result * 31 + (substring.isPresent() ? substring.get().hashCode() : 0);

        return result;
    }
}
