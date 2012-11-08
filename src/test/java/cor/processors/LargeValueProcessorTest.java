package cor.processors;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import util.Any;

public class LargeValueProcessorTest {
    private LargeValueProcessor largeValueProcessor = new LargeValueProcessor(null);

    @Test
    public void TestLargeValueProcessorElectsCorrectly() {
        assertThat(shouldProcess(Processor.MIN_LARGE_VALUE)).isTrue();
        assertThat(shouldProcess(Processor.MIN_LARGE_VALUE - 1)).isFalse();
        assertThat(shouldProcess(Processor.MAX_LARGE_VALUE)).isTrue();
        assertThat(shouldProcess(Processor.MAX_LARGE_VALUE + 1)).isFalse();
    }

    @Test
    public void TestLargeValueProcessorProcessesCorrectly() {
        int valueToBeProcessed = Any.integerBetween(Processor.MIN_LARGE_VALUE, Processor.MAX_LARGE_VALUE);
        int expectedReturn = valueToBeProcessed / 2;
        assertThat(largeValueProcessor.processThis(valueToBeProcessed)).isEqualTo(expectedReturn);
    }

    private boolean shouldProcess(int value) {
        return largeValueProcessor.shouldProcess(value);
    }

}