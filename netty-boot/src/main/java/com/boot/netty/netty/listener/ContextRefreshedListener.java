package com.boot.netty.netty.listener;

import com.boot.netty.netty.bin.Biz;
import com.boot.netty.netty.common.Constans;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @program: netty-boot
 * @description:
 * @author: lxf
 * @create: 2019-11-21 10:58
 **/
@Component
public class ContextRefreshedListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        Map<String, Object> bizMap = applicationReadyEvent.getApplicationContext().getBeansWithAnnotation(Biz.class);
        for (Map.Entry<String, Object> entry : bizMap.entrySet()) {
            Object object = entry.getValue();
            Class c = object.getClass();
            Annotation[] annotations = c.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Biz.class)) {
                    Biz biz = (Biz) annotation;

                    Constans.coursesTable.put(biz.value(),object);

                }
            }
        }
    }

}
