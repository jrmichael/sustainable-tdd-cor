package cor.processors;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import util.Any;

public class TerminalProcessorTest {

	TerminalProcessor processor = new TerminalProcessor();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
    @Test
    public void AlwaysElects() throws Exception {
		assertThat(processor.isItMine(Any.intValue())).isTrue();
    }

    @Test
    public void ThrowsExceptionWhenProcessing() {
    	expectedException.expect(IllegalArgumentException.class);
    	processor.process(Any.intValue());
    }

}
