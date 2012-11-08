package cor.processors;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import util.Any;

public class ProcessorNonDelegationTest {

    @Test
    public void TestNoDelegationWhenProcessorElects() {
        MockProcessor secondProcessor = new MockProcessor(null);
        MockProcessor firstProcessor = new MockProcessor(secondProcessor);
        firstProcessor.willElect = true;

        firstProcessor.process(Any.intValue());

        assertThat(secondProcessor.wasAskedtoProcess).isFalse();
    }
}
