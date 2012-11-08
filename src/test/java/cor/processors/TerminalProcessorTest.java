package cor.processors;

import static com.googlecode.catchexception.CatchException.*;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.*;
import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import util.Any;

public class TerminalProcessorTest {

    @Test
    public void TestTerminalProcessorAlwaysElects() {
        assertThat(terminalProcessor().shouldProcess(Any.intValue())).isTrue();
    }

    @Test
    public void TestTerminalProcessorThrowsExceptionWhenProcessing() {
        when(terminalProcessor()).processThis(Any.intValue());
        then(caughtException()).isInstanceOf(IllegalArgumentException.class);
    }

    private TerminalProcessor terminalProcessor() {
        return new TerminalProcessor();
    }
}
