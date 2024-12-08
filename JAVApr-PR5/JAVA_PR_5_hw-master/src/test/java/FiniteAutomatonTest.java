import org.example.FiniteAutomaton;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.Arguments;

public class FiniteAutomatonTest {

    @ParameterizedTest
    @MethodSource("provideTestCasesForRecognizeTestWord")
    void testRecognizeTestWord(String input, String expected) {
        assertEquals(expected, FiniteAutomaton.recognizeTestWord(input));
    }

    private static Stream<Arguments> provideTestCasesForRecognizeTestWord() {
        return Stream.of(
                arguments("abcTESTabc", "F"),//
                arguments("TESTTEST", "F"),//
                arguments("TTEST", "F"),//
                arguments("abcTTESTabc", "F"),
                arguments("TEST", "F"),
                arguments("TES", "S3"),
                arguments("T", "S1"),
                arguments("TE", "S2"),
                arguments("", "S0"),
                arguments("TESTing", "F"),
                arguments("abcTESTingTEST", "F"),
                arguments("abc", "S0"),
                arguments("TEX", "S0"),
                arguments("TESabcTEST", "F"),
                arguments("TESabcTET", "S1")
        );
    }
}