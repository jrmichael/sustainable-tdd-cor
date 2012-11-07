package cor.processors;


import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ProcessorDelegationTest {
    private MockProcessor firstProcessor;
    private MockProcessor secondProcessor;
    private int valueToProcess;
    private int returnedValue;
    private static final int IRRELEVANT = 4123;

    @Before
    public void Init() {
        // Setup
        secondProcessor = new MockProcessor(null);
        secondProcessor.willElect = true;
        firstProcessor = new MockProcessor(secondProcessor);
        firstProcessor.willElect = false;
        valueToProcess = IRRELEVANT;
        secondProcessor.returnValue = IRRELEVANT;

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

