package com.test.rs.util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes("application/json")
public class CustomJsonReader<T> implements MessageBodyReader<T> {
    
    @Override
    public boolean isReadable(Class<?> type, Type genericType,
        Annotation[] annotations,MediaType mediaType) {
      return true;
    }

    @Override
    public T readFrom(Class<T> type, Type genericType, Annotation[] annotations,
        MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
        InputStream entityStream) throws IOException, WebApplicationException {
        
        Writer writer = new StringWriter();
        Reader reader = new BufferedReader(new InputStreamReader(entityStream, "UTF-8"));
        char[] buffer = new char[1024];
        int n = reader.read(buffer);
        writer.write(buffer, 0, n);
        String json = writer.toString();
        if (String.class == genericType)
            return type.cast(json);
        return new Gson().fromJson(json, genericType);
    }
}