package cor.processors;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Test;
import org.mockito.Mockito;

public class SmallValueProcessorTest {

    private static final int VALUE = 5;
    private static final int HIGH_VALUE = 10001;
	private static final int NEGATIVE_VALUE = -5;
    Processor delegate = Mockito.mock(Processor.class);
    SmallValueProcessor processor = new SmallValueProcessor(delegate);

	@Test
    public void SmallValueProcessorElectsCorrectlyOnSmallValue() {
		processor.process(VALUE);
		
		verifyZeroInteractions(delegate);
    }
	
	@Test
	public void SmallValueProcessorShouldNotElectOnHighValue() throws Exception {
		processor.process(HIGH_VALUE);
		
		verify(delegate).process(HIGH_VALUE);
		
	}
	@Test
	public void SmallValueProcessorShouldNotElectOnNegativeValue() throws Exception {
		processor.process(NEGATIVE_VALUE);
		
		verify(delegate).process(NEGATIVE_VALUE);
		
	}

    @Test
    public void SmallValueProcessorProcessesCorrectly() {
    	int result = processor.process(VALUE);
    	assertThat(result).isEqualTo(VALUE*2);
    }

}
