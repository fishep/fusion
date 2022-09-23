package com.fishep.fusion.common.test;

import com.fishep.fusion.common.test.impl.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MockitoTest {

    @Mock
    SayService sayService;

    @InjectMocks
    ServiceImpl service;

    @Test
    void mockTest() {

        when(sayService.say(eq("hello"))).thenReturn("hello world");
        assertEquals("hello world", sayService.say("hello"));
        verify(sayService).say("hello");

        when(sayService.sayWelcome()).thenReturn("welcome");
        assertEquals("welcome", sayService.sayWelcome());
        verify(sayService).sayWelcome();

        String say = service.say("hello");
        assertEquals("hello world", say);

        service.sayNothing();

//        clearInvocations(sayService);
//        String say1 = service.say("hi");

//        verifyNoInteractions(sayService);
    }
}