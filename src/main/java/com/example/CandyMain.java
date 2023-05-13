package com.example;



import com.example.model.candy_HW_2.Candy;
import com.example.parser_HW_1_2.CandySTAXParser;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Nadia  Filatova
 * @since 5/13/23
 */

public class CandyMain {
    private static final String XML_FILE_URI = "src/main/resources/candies/candies.xml";

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        CandySTAXParser candySTAXParser = new CandySTAXParser();
        List<Candy> candies = candySTAXParser.parse(XML_FILE_URI);
        candies.forEach(System.out::println);
    }
}
