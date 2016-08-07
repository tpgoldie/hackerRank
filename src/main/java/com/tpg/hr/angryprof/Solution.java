package com.tpg.hr.angryprof;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution solution = new Solution(System.in);
        solution.classesCancelled();
    }

    private final InputReader reader;

    public Solution(InputStream is) {
        reader = new InputReader(is);
    }

    public List<String> classesCancelled() {
        return reader.getTestCases().stream()
            .map(tc -> tc.classCancelled()).collect(toList());
    }
}