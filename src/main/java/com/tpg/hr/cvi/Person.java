package com.tpg.hr.cvi;

import java.io.BufferedOutputStream;
import java.io.PrintStream;

public class Person {
    private int age;

    private final PrintStream pos;

    public Person(int initialAge) {
        this(initialAge, new BufferedOutputStream(System.out));
    }

    Person(int initialAge, BufferedOutputStream bos) {
        this(initialAge, new PrintStream(bos));
    }

    Person(int initialAge, PrintStream pos) {
        this.pos = pos;

        if (initialAge > 0) {
            age = initialAge;
        }
        else {
            age = 0;

            print("Age is not valid, setting age to 0.");
        }
    }

    private void print(String msg) {
        pos.print(msg);
        pos.flush();
    }

    public int getAge() {
        return age;
    }

    public void amIOld() {
        if (age < 13) { print("You are young."); }
        else if ((age > 12) && (age < 18)) { print("You are a teenager."); }
        else { print("You are old."); }
    }

    public int yearPasses() { return ++age; }
}
