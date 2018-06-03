package com.ay;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppTest.class)
@TestPropertySource("classpath:application.properties")
public class MessageTest {
    @Autowired
    private MessageSource messageSource;

    @Test
    public void startTest() {
        Assertions.assertThat(messageSource).isNotNull();
    }

    @Test
    public void should_return_message() {
        Assertions.assertThat(messageSource.getMessage("message.print", null, Locale.getDefault())).isEqualTo("测试");
    }

    @Test
    public void exception_message_result() {
        Assertions.assertThat(messageSource.getMessage("exception.args.not.empty",new String[]{"param"},Locale.getDefault())).isEqualTo("param 不能为空");
    }
}
