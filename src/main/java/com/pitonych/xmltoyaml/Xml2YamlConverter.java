package com.pitonych.xmltoyaml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Provides Spring entry point for xml_to_yaml
 */
@SpringBootApplication
public class Xml2YamlConverter {
    /**
     * Passing command line arguments to it while launches Spring application
     *
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Xml2YamlConverter.class, args);
    }
}
