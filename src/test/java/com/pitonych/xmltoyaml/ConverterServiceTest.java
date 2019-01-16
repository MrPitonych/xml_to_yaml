package com.pitonych.xmltoyaml;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;


import com.pitonych.xmltoyaml.service.ConverterService;

public class ConverterServiceTest {

    private ConverterService converterService;

    {
        try {
            converterService = new ConverterService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void NothingInside() throws Exception {

        String xml_input = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<yaml>"+
                "</yaml>";

        String yml_output = "";

        String actual = null;
        try {
            actual = converterService.parseXML(xml_input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Result not as expected", yml_output, actual);
    }

    @Test
    public void NoHeader() throws Exception {

        String xml_input = "<yaml>"+
                "</yaml>";

        String yml_output = "";

        String actual = null;
        try {
            actual = converterService.parseXML(xml_input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Result not as expected", yml_output, actual);

    }

    @Test
    public void testShort() throws Exception {

        String xml_input = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<yaml>"+
                "<profile>"+
                "<profile_list>preview.integration.com</profile_list>"+
                "<profile_list>preview1.integration.com</profile_list>"+
                "<profile_list>preview2.integration.com</profile_list>"+
                "</profile>"+
                "<manage>true</manage>"+
                "</yaml>";

        String yml_output = "profile:"+System.lineSeparator()+
                "  - preview2.integration.com"+System.lineSeparator()+
                "  - preview1.integration.com"+System.lineSeparator()+
                "  - preview.integration.com"+System.lineSeparator()+
                "manage: true"+System.lineSeparator();

        String actual = null;
        try {
            actual = converterService.parseXML(xml_input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Result not as expected", yml_output, actual);

    }


    @Test
    public void testReal() throws Exception {

        String xml_input = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<yaml>"+
                "<primary>mapa1</primary>"+
                "<secondary>mapa2</secondary>"+
                "<profile>"+
                "<profile_l>preview.integration.com</profile_l>"+
                "<profile_l>preview1.integration.com</profile_l>"+
                "<profile_l>preview2.integration.com</profile_l>"+
                "</profile>"+
                "<manage>true</manage>"+
                "</yaml>";

        String yml_output = "primary: mapa1"+System.lineSeparator()+
                "secondary: mapa2"+System.lineSeparator()+
                "profile:"+System.lineSeparator()+
                "  - preview2.integration.com"+System.lineSeparator()+
                "  - preview1.integration.com"+System.lineSeparator()+
                "  - preview.integration.com"+System.lineSeparator()+
                "manage: true"+System.lineSeparator();

        String actual = null;
        try {
            actual = converterService.parseXML(xml_input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Result not as expected", yml_output, actual);

    }



    @Test
    public void testExtended() throws Exception {

        String xml_input = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<yaml>"+
                "<primary>mapa1</primary>"+
                "<secondary>mapa2</secondary>"+
                "<profile>"+
                "<profile_elem>preview.integration.com</profile_elem>"+
                "<profile_elem>preview1.integration.com</profile_elem>"+
                "<profile_elem>preview2.integration.com</profile_elem>"+
                "</profile>"+
                "<manage>true</manage>"+
                "<internal_structure>"+
                "<internal::element>elem1</internal::element>"+
                "<internal::element1>elem2</internal::element1>"+
                "</internal_structure>"+
                "<external_structure>"+
                "<external::element>elem1</external::element>"+
                "<external::element1>elem2</external::element1>"+
                "</external_structure>"+

                "</yaml>";

        String yml_output = "primary: mapa1"+System.lineSeparator()+
                "secondary: mapa2"+System.lineSeparator()+
                "profile:"+System.lineSeparator()+
                "  - preview2.integration.com"+System.lineSeparator()+
                "  - preview1.integration.com"+System.lineSeparator()+
                "  - preview.integration.com"+System.lineSeparator()+
                "manage: true"+System.lineSeparator()+
                "internal_structure:"+System.lineSeparator()+
                "  internal::element1: elem2"+System.lineSeparator()+
                "  internal::element: elem1"+System.lineSeparator()+
                "external_structure:"+System.lineSeparator()+
                "  external::element: elem1"+System.lineSeparator()+
                "  external::element1: elem2"+System.lineSeparator();

        String actual = null;
        try {
            actual = converterService.parseXML(xml_input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Result not as expected", yml_output, actual);
    }

    @Test
    public void testSimpleInsideCombo() throws Exception {

        String xml_input = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<yaml>"+
                "<primary>mapa1</primary>"+
                "<secondary>mapa2</secondary>"+
                "<profile>"+
                "<profile_elem>preview.integration.com</profile_elem>"+
                "<profile_elem>preview1.integration.com</profile_elem>"+
                "<profile_elem>preview2.integration.com</profile_elem>"+
                "<some_stuff_inside>text</some_stuff_inside>"+
                "</profile>"+
                "<manage>true</manage>"+
                "</yaml>";

        String yml_output = "primary: mapa1"+System.lineSeparator()+
                "secondary: mapa2"+System.lineSeparator()+
                "profile:"+System.lineSeparator()+
                "  - preview2.integration.com"+System.lineSeparator()+
                "  - preview1.integration.com"+System.lineSeparator()+
                "  - preview.integration.com"+System.lineSeparator()+
                "  some_stuff_inside: text"+System.lineSeparator()+
                "manage: true"+System.lineSeparator();

        String actual = null;
        try {
            actual = converterService.parseXML(xml_input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Result not as expected", yml_output, actual);
    }


}
