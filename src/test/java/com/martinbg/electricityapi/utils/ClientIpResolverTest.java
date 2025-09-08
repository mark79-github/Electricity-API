package com.martinbg.electricityapi.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientIpResolverTest {

    @Mock
    private ServletRequestAttributes servletRequestAttributes;

    @Mock
    private HttpServletRequest httpServletRequest;

    @InjectMocks
    private ClientIpResolver clientIpResolver;

    @BeforeEach
    void setUp() {
        when(servletRequestAttributes.getRequest()).thenReturn(httpServletRequest);
    }

    @Test
    void testGetClientIpAddress_WithXForwardedFor_SingleIP() {
        String expectedIp = "192.168.1.100";
        when(httpServletRequest.getHeader("X-Forwarded-For")).thenReturn(expectedIp);

        try (MockedStatic<RequestContextHolder> mockedRequestContextHolder = mockStatic(RequestContextHolder.class)) {
            mockedRequestContextHolder.when(RequestContextHolder::currentRequestAttributes)
                    .thenReturn(servletRequestAttributes);

            String actualIp = clientIpResolver.getClientIpAddress();

            assertEquals(expectedIp, actualIp);
            verify(httpServletRequest).getHeader("X-Forwarded-For");
            verify(httpServletRequest, never()).getHeader("X-Real-IP");
            verify(httpServletRequest, never()).getRemoteAddr();
        }
    }

    @Test
    void testGetClientIpAddress_WithXForwardedFor_MultipleIPs() {
        String xForwardedFor = "192.168.1.100, 10.0.0.1, 172.16.0.1";
        String expectedIp = "192.168.1.100";
        when(httpServletRequest.getHeader("X-Forwarded-For")).thenReturn(xForwardedFor);

        try (MockedStatic<RequestContextHolder> mockedRequestContextHolder = mockStatic(RequestContextHolder.class)) {
            mockedRequestContextHolder.when(RequestContextHolder::currentRequestAttributes)
                    .thenReturn(servletRequestAttributes);

            String actualIp = clientIpResolver.getClientIpAddress();

            assertEquals(expectedIp, actualIp);
        }
    }

    @Test
    void testGetClientIpAddress_WithXForwardedFor_WithSpaces() {
        String xForwardedFor = "  192.168.1.100  , 10.0.0.1  ";
        String expectedIp = "192.168.1.100";
        when(httpServletRequest.getHeader("X-Forwarded-For")).thenReturn(xForwardedFor);

        try (MockedStatic<RequestContextHolder> mockedRequestContextHolder = mockStatic(RequestContextHolder.class)) {
            mockedRequestContextHolder.when(RequestContextHolder::currentRequestAttributes)
                    .thenReturn(servletRequestAttributes);

            String actualIp = clientIpResolver.getClientIpAddress();

            assertEquals(expectedIp, actualIp);
        }
    }

    @Test
    void testGetClientIpAddress_WithXRealIP_WhenXForwardedForIsNull() {
        String expectedIp = "203.0.113.195";
        when(httpServletRequest.getHeader("X-Forwarded-For")).thenReturn(null);
        when(httpServletRequest.getHeader("X-Real-IP")).thenReturn(expectedIp);

        try (MockedStatic<RequestContextHolder> mockedRequestContextHolder = mockStatic(RequestContextHolder.class)) {
            mockedRequestContextHolder.when(RequestContextHolder::currentRequestAttributes)
                    .thenReturn(servletRequestAttributes);

            String actualIp = clientIpResolver.getClientIpAddress();

            assertEquals(expectedIp, actualIp);
            verify(httpServletRequest).getHeader("X-Forwarded-For");
            verify(httpServletRequest).getHeader("X-Real-IP");
            verify(httpServletRequest, never()).getRemoteAddr();
        }
    }

    @Test
    void testGetClientIpAddress_WithXRealIP_WhenXForwardedForIsEmpty() {
        String expectedIp = "203.0.113.195";
        when(httpServletRequest.getHeader("X-Forwarded-For")).thenReturn("");
        when(httpServletRequest.getHeader("X-Real-IP")).thenReturn(expectedIp);

        try (MockedStatic<RequestContextHolder> mockedRequestContextHolder = mockStatic(RequestContextHolder.class)) {
            mockedRequestContextHolder.when(RequestContextHolder::currentRequestAttributes)
                    .thenReturn(servletRequestAttributes);

            String actualIp = clientIpResolver.getClientIpAddress();

            assertEquals(expectedIp, actualIp);
        }
    }

    @Test
    void testGetClientIpAddress_WithRemoteAddr_WhenBothHeadersAreNull() {
        String expectedIp = "127.0.0.1";
        when(httpServletRequest.getHeader("X-Forwarded-For")).thenReturn(null);
        when(httpServletRequest.getHeader("X-Real-IP")).thenReturn(null);
        when(httpServletRequest.getRemoteAddr()).thenReturn(expectedIp);

        try (MockedStatic<RequestContextHolder> mockedRequestContextHolder = mockStatic(RequestContextHolder.class)) {
            mockedRequestContextHolder.when(RequestContextHolder::currentRequestAttributes)
                    .thenReturn(servletRequestAttributes);

            String actualIp = clientIpResolver.getClientIpAddress();

            assertEquals(expectedIp, actualIp);
            verify(httpServletRequest).getHeader("X-Forwarded-For");
            verify(httpServletRequest).getHeader("X-Real-IP");
            verify(httpServletRequest).getRemoteAddr();
        }
    }

    @Test
    void testGetClientIpAddress_WithRemoteAddr_WhenBothHeadersAreEmpty() {
        String expectedIp = "127.0.0.1";
        when(httpServletRequest.getHeader("X-Forwarded-For")).thenReturn("");
        when(httpServletRequest.getHeader("X-Real-IP")).thenReturn("");
        when(httpServletRequest.getRemoteAddr()).thenReturn(expectedIp);

        try (MockedStatic<RequestContextHolder> mockedRequestContextHolder = mockStatic(RequestContextHolder.class)) {
            mockedRequestContextHolder.when(RequestContextHolder::currentRequestAttributes)
                    .thenReturn(servletRequestAttributes);

            String actualIp = clientIpResolver.getClientIpAddress();

            assertEquals(expectedIp, actualIp);
        }
    }

    @Test
    void testGetClientIpAddress_IPv6Address() {
        String expectedIp = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        when(httpServletRequest.getHeader("X-Forwarded-For")).thenReturn(expectedIp);

        try (MockedStatic<RequestContextHolder> mockedRequestContextHolder = mockStatic(RequestContextHolder.class)) {
            mockedRequestContextHolder.when(RequestContextHolder::currentRequestAttributes)
                    .thenReturn(servletRequestAttributes);

            String actualIp = clientIpResolver.getClientIpAddress();

            assertEquals(expectedIp, actualIp);
        }
    }
}
