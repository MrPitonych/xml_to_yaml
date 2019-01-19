package com.pitonych.xmltoyaml.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.pitonych.xmltoyaml.service.ConverterService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.XMLStreamException;
/**
 * Provides web controllers for the xml_to_yaml api
 */
@Api
@RestController
public class Converter {

    @Autowired
    private ConverterService converterService;
    /**
     * Controller for XML to YAML conversion requests
     *
     * @param xml - input XML to be converted
     * @return YAML output when possible together with HTTP code
     * matching occurred exception or 200 if okay.
     */
    @ApiOperation(value = "XML to YAML Converter")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Converted XML to YAML"),
            @ApiResponse(code = 400, message = "Invalid XML"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping(
            value = "/convert",
            consumes = "application/xml",
            produces = "application/x-yaml"
    )
    public ResponseEntity<String> convert(
            @ApiParam(
                    name = "xml",
                    value = "XML to convert",
                    required = true,
                    examples = @Example(
                            @ExampleProperty(
                                    mediaType = "application/json",
                                    value = "<note><to>Tove</to><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>"
                            )
                    )
            )
            @RequestBody String xml) {
        try {
            // parse XML as element map and return YAML
            String yaml = converterService.parseXML(xml);
            return new ResponseEntity<>(yaml, HttpStatus.OK);
        } catch (JsonParseException | XMLStreamException e) {
            e.printStackTrace();
            // something wrong with input
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
