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
		Processor processor = factory.getProcessor();
		assertThat(processor).isInstanceOf(LargeValueProcessor.class);
		assertThat(processor.delegate).isInstanceOf(SmallValueProcessor.class);
		assertThat(processor.delegate.delegate).isInstanceOf(TerminalProcessor.class);
    }

}
