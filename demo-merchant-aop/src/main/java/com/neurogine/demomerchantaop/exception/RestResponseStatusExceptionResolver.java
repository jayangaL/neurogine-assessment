package com.neurogine.demomerchantaop.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.springframework.http.HttpHeaders;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import java.io.IOException;

@Component
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try{
            if (ex instanceof JpaSystemException){
                return handleJpaSystemException((JpaSystemException)ex,response);
            }

        }catch (Exception handlerException){
            logger.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception" , handlerException);
        }
        return null;
    }

    private ModelAndView handleJpaSystemException(JpaSystemException ex,HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_CONFLICT);
        String accept = response.getHeader(HttpHeaders.ACCEPT);

        return new ModelAndView();
    }
}
