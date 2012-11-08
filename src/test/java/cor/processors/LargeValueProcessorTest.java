package cor.processors;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

public class LargeValueProcessorTest {

    private static final int VALUE = 10001;
    private static final int HIGH_VALUE = 20001;
    private static final int LOW_VALUE = 1;
    Processor delegate = Mockito.mock(Processor.class);
    LargeValueProcessor processor = new LargeValueProcessor(delegate);

    @Test
    public void ElectsCorrectly() {
		processor.process(VALUE);
		
		verifyZeroInteractions(delegate);

    }

    @Test
    public void DoesNotElectOnTooHighValue() {
    	processor.process(HIGH_VALUE);
    	
    	verify(delegate).process(HIGH_VALUE);
    	
    }

    @Test
    public void DoesNotElectOnTooLowValue() {
    	processor.process(LOW_VALUE);
    	
    	verify(delegate).process(LOW_VALUE);
    	
    }

    @Test
    public void ProcessesCorrectly() {
    	int result = processor.process(VALUE);
    	Assertions.assertThat(result).isEqualTo(VALUE / 2);
    }

}