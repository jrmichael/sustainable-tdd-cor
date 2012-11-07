package cor.processors;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class ProcessorDelegationTest {
    private MockProcessor firstProcessor;
    private MockProcessor secondProcessor;
    private int valueToProcess;
    private int returnedValue;

    @Before
    public void Init() {
        // Setup
        secondProcessor = new MockProcessor(null);
        secondProcessor.willElect = true;
        firstProcessor = new MockProcessor(secondProcessor);
        firstProcessor.willElect = false;
        valueToProcess = Any.intValue();
        secondProcessor.returnValue = Any.intValue();

        // Common Trigger
        returnedValue = firstProcessor.process(valueToProcess);
    }

    @Test
    public void TestDelegationHappensWhenItShould() {
        assertThat(secondProcessor.wasAskedtoProcess).isTrue();
    }

    @Test
    public void TestDelegationHappensWithUnchangedParameter() {
        assertThat(valueToProcess).isEqualTo(secondProcessor.valueReceived);
    }

    @Test
    public void TestDelegationHappensWithUnchangedReturn() {
        assertThat(returnedValue).isEqualTo(secondProcessor.returnValue);
    }
}
