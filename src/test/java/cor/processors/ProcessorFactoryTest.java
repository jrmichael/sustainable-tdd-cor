package cor.processors;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class ProcessorFactoryTest {

	ProcessorFactory factory = new ProcessorFactory();
	
    @Test
    public void FactoryReturnsProperType() {
    	Processor processor = factory.getProcessor();
    	assertThat(processor).isNotNull().isInstanceOf(Processor.class);
    }

    @Test
    public void FactoryReturnsProperChainOfProcessors() {
    	ProcessorFactory mockedFactory = mock(ProcessorFactory.class);
    	TerminalProcessor terminalProcessor = new TerminalProcessor();
    	SmallValueProcessor smallValueProcessor = new SmallValueProcessor(terminalProcessor);
    	LargeValueProcessor largeValueProcessor = new LargeValueProcessor(smallValueProcessor);
		when(mockedFactory.terminalProcessor()).thenReturn(terminalProcessor);
		when(mockedFactory.smallValueProcessor(any(Processor.class))).thenReturn(smallValueProcessor);
		when(mockedFactory.largeValueProcessor(any(Processor.class))).thenReturn(largeValueProcessor);
		when(mockedFactory.getProcessor()).thenCallRealMethod();
		
		Processor processor = mockedFactory.getProcessor();
		
		verify(mockedFactory).terminalProcessor();
		verify(mockedFactory).smallValueProcessor(terminalProcessor);
		verify(mockedFactory).largeValueProcessor(smallValueProcessor);
    	assertThat(processor).isEqualTo(largeValueProcessor);
    	
    }

}
