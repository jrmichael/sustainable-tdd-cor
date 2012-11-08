package cor.processors;

import static java.util.Arrays.*;
import static org.fest.assertions.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.Any;

public class ProcessorFactoryTest {

    @Test
    public void TestFactoryReturnsProperType() {
        Processor processor = new ProcessorFactory().getProcessor();
        assertThat(processor).isInstanceOf(Processor.class);
    }

    @Test
    public void TestFactoryReturnsProperChainOfProcessors() {
        Log log = new Log();
        ProcessorFactory factory = new TestableProcessorFactory(log);
        Processor processorChain = factory.getProcessor();
    
        processorChain.process(Any.intValue());
    
        log.assertContainsTypesExactly(asList(LargeValueProcessor.class, SmallValueProcessor.class, TerminalProcessor.class));
    }

    public class LoggingMockProcessor extends Processor {

        public boolean willElect = false;
        private Class<? extends Processor> clazz;
        private Log log;

        protected LoggingMockProcessor(Processor aProcessor) {
            super(aProcessor);
        }

        public LoggingMockProcessor(Log log, Class<? extends Processor> clazz, Processor processor) {
            super(processor);
            this.log = log;
            this.clazz = clazz;
        }

        @Override
        protected boolean shouldProcess(int value) {
            log.add(clazz);
            return willElect;
        }

        @Override
        protected int processThis(int value) {
            return 0;
        }

    }

    public class TestableProcessorFactory extends ProcessorFactory {

        private Log log;

        public TestableProcessorFactory(Log log) {
            this.log = log;
        }

        @Override
        Processor createLargeValueProcessor(Processor processor) {
            return new LoggingMockProcessor(log, LargeValueProcessor.class, processor);
        }

        @Override
        Processor createSmallValueProcessor(Processor processor) {
            return new LoggingMockProcessor(log, SmallValueProcessor.class, processor);
        }

        @Override
        Processor createTerminalProcessor() {
            LoggingMockProcessor processor = new LoggingMockProcessor(log, TerminalProcessor.class, null);
            processor.willElect = true;
            return processor;
        }

    }

    public class Log {

        private List<Class<? extends Processor>> processors = new ArrayList<>();

        public void assertSize(int correctChainLength) {
            assertThat(processors).hasSize(correctChainLength);
        }

        public void add(Class<? extends Processor> clazz) {
            processors.add(clazz);
        }

        public void assertContainsTypesExactly(List<Class<? extends Processor>> correctCollection) {
            assertThat(processors).isEqualTo(correctCollection);
        }
    }
}
