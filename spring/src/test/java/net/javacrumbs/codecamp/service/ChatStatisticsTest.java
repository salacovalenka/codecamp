package net.javacrumbs.codecamp.service;

import net.javacrumbs.codecamp.common.Logger;
import net.javacrumbs.codecamp.common.Message;
import org.junit.Test;

import static java.util.Arrays.asList;
import static net.javacrumbs.codecamp.common.Message.Severity.DEBUG;
import static net.javacrumbs.codecamp.common.Message.Severity.INFO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChatStatisticsTest {
    private final Logger logger = mock(Logger.class);
    private final LogStatistics logStatistics = new LogStatistics(logger);

    @Test
    public void shouldReturnEmptyIfThreadNotFound() {
        assertThat(logStatistics.findLongestMessage().isPresent()).isFalse();
    }

    @Test
    public void shouldReturnLongest() {
        Message message1 = new Message(DEBUG, "short");
        Message message2 = new Message(INFO, "long message");
        when(logger.getMessages()).thenReturn(asList(message1, message2));

        assertThat(logStatistics.findLongestMessage()).containsSame(message2);
    }


}