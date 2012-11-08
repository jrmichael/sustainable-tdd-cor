package cor.processors;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import util.Any;

public class SmallValueProcessorTest {

    private SmallValueProcessor smallValueProcessor = new SmallValueProcessor(null);

    @Test
    public void TestSmallValueProcessorElectsCorrectly() {
        assertThat(shouldProcess(Processor.MIN_SMALL_VALUE)).isTrue();
        assertThat(shouldProcess(Processor.MIN_SMALL_VALUE - 1)).isFalse();
        assertThat(shouldProcess(Processor.MAX_SMALL_VALUE)).isTrue();
        assertThat(shouldProcess(Processor.MAX_SMALL_VALUE + 1)).isFalse();
    }

    @Test
    public void TestSmallValueProcessorProcessesCorrectly() {
        int valueToBeProcessed = Any.integerBetween(Processor.MIN_SMALL_VALUE, Processor.MAX_SMALL_VALUE);
        int expectedReturn = valueToBeProcessed * 2;
        assertThat(smallValueProcessor.processThis(valueToBeProcessed)).isEqualTo(expectedReturn);
    }

    protected boolean shouldProcess(int value) {
        return smallValueProcessor.shouldProcess(value);
    }
}
