package de.igweb.igfileconfigurations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FileSettings {

    /**
     * The path to the file
     **/
    String value();

}
