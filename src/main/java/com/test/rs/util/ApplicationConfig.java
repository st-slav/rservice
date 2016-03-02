package com.test.rs.util;

import com.test.rs.rsevice.LocationRest;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("rs")
public class ApplicationConfig extends Application{
    
    private final Set<Class<?>> classes;
    
    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(LocationRest.class);

        classes = Collections.unmodifiableSet(c);
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
