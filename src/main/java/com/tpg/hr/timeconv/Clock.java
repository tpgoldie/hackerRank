package com.tpg.hr.timeconv;

abstract class Clock {
    public final static String COLON = ":";

    protected final String hh;
    protected final String mm;
    protected final String ss;
    protected final String suffix;

    protected Clock(String in) {
        String[] tokens = in.split(COLON);
        hh = tokens[0];
        mm = tokens[1];

        String temp = tokens[2];
        if (temp.contains(TwelveHourSuffix.AM.name())) {
            ss = tokens[2].substring(0, 2);
            suffix = TwelveHourSuffix.AM.name();
        }
        else if (temp.contains(TwelveHourSuffix.PM.name())) {
            ss = tokens[2].substring(0, 2);
            suffix = TwelveHourSuffix.PM.name();
        }
        else {
            ss = tokens[2];
            suffix = "";
        }
    }

    public String getHh() {
        return hh;
    }

    public String getMm() {
        return mm;
    }

    public String getSs() {
        return ss;
    }

    public String getSuffix() {
        return suffix;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof Clock)) { return false; }

        Clock other = (Clock) that;

        if (!other.hh.equals(this.hh)) { return false; }
        if (!other.mm.equals(this.mm)) { return false; }
        if (!other.ss.equals(this.ss)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 31;

        result = hh.hashCode() * result + result;
        result = mm.hashCode() * result + result;
        result = ss.hashCode() * result + result;

        if (!((suffix == null) || (suffix.isEmpty()))) { result = suffix.hashCode() * result + result; }

        return result;
    }

    public String toString() {
        return String.format("%s:%s:%s", hh, mm, ss);
    }
}
