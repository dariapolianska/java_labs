package org.example;

public class FiniteAutomaton {

    public enum State {
        S0, // старт
        S1, // T
        S2, // TE
        S3, // TES
        F   // TEST
    }

    public static String recognizeTestWord(String input) {
        State state = State.S0;

        for (char ch : input.toCharArray()) {
            switch (state) {
                case S0, F:
                    if (ch == 'T') {
                        state = State.S1;
                    }
                    break;

                case S1:
                    if (ch == 'E') {
                        state = State.S2;
//                    } else if (ch == 'T') {
////                        state = State.S1;
//                        continue;
                    } else if (ch != 'T') {
                        state = State.S0;
                    }
                    break;

                case S2:
                    if (ch == 'S') {
                        state = State.S3;
                    } else if (ch == 'T') {
                        state = State.S1;
                    } else {
                        state = State.S0;
                    }
                    break;

                case S3:
                    if (ch == 'T') {
                        state = State.F;
                    } else {
                        state = State.S0;
                    }
                    break;
            }
        }

        return state == State.F ? "F" : state.name();
    }
}