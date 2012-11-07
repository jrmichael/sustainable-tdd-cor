package cor.processors;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class ConstantSpecificationTest {

    @Test
    public void SpecifyConstants() {
        assertThat(Processor.MIN_SMALL_VALUE).isEqualTo(1);
        assertThat(Processor.MAX_SMALL_VALUE).isEqualTo(10000);
        assertThat(Processor.MIN_LARGE_VALUE).isEqualTo(10001);
        assertThat(Processor.MAX_LARGE_VALUE).isEqualTo(20000);
    }
}
