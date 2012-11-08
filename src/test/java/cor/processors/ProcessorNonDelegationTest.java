package cor.processors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Test;

public class ProcessorNonDelegationTest {

    @Test
    public void NoDelegationWhenProcessorElects() {
    	Processor delegate = mock(Processor.class);
    	Processor processor = notDelegatingProcessor(delegate);
    	
    	processor.process(0);
    	
    	verifyZeroInteractions(delegate);
    }
    
	private Processor notDelegatingProcessor(Processor delegate) {
		Processor processor = new Processor(delegate) {
			@Override
			protected boolean isItMine(int value) {
				return true;
			}

			@Override
			protected int doProcess(int value) {
				return 0;
			}
		};
		return processor;
	}

}
