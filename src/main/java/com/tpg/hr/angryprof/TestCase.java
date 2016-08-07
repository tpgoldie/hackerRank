package com.tpg.hr.angryprof;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class TestCase {
    private final int N;
    private final int K;
    private final Integer[] arrivalTimes;
    private final int hc;

    public TestCase(int N, int K, Integer[] arrivalTimes) {
        this.N = N;
        this.K = K;
        this.arrivalTimes = arrivalTimes;

        hc = hashCode();
    }

    public String classCancelled() {
        return isClassCancelled() ? "YES" : "NO";
    }

    private boolean isClassCancelled() {
        List<Integer> dataStream = new ArrayList<>(asList(arrivalTimes));
        List<Integer> onTime = dataStream.stream().filter(d -> d <= 0).collect(toList());

        return onTime.size() < K;
    }

    public boolean equals(Object that) {
        if (that == this) { return true; }
        if (!(that instanceof TestCase)) { return false; }

        TestCase other = (TestCase) that;

        return new EqualsBuilder()
            .append(other.N, N)
            .append(other.K, K)
            .append(other.arrivalTimes, arrivalTimes)
                .isEquals();
    }

    public int hashCode() {
        if (hc > 0) { return hc; }

        return new HashCodeBuilder()
            .append(N).append(K).append(arrivalTimes)
                .toHashCode();
    }

    public String toString() {
        return String.format("%d %d %s", N, K, arrivalTimes.toString());
    }
}
