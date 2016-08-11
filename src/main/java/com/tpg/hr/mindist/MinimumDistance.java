package com.tpg.hr.mindist;

import com.tpg.hr.core.math.Pair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MinimumDistance {
    private final List<List<Pair<Integer, Integer>>> rows = new ArrayList();

    private final int size;

    public MinimumDistance(InputStream is) {
        Scanner scanner = new Scanner(is);

        size = scanner.nextInt();

        List<Integer> data = new ArrayList<>();

        while(scanner.hasNextInt()) {
            data.add(scanner.nextInt());
        }

        for (int i = 0; i < size; i++) {
            List<Pair<Integer, Integer>> row = new ArrayList();

            for (int j = 0; j < size; j++) {
                row.add(new Pair(data.get(i), data.get(j)));
            }

            rows.add(row);
        }
    }

    public int getValue() {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    Pair<Integer, Integer> pair = rows.get(i).get(j);
                    if (pair.isTheSame()) {
                        values.add(Math.abs(i - j));
                    }
                }
            }
        }

        return values.stream().min(Comparator.comparing(i -> i.intValue())).orElse(-1);
    }
}
