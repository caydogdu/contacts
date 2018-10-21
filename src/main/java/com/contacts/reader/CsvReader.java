package com.contacts.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.contacts.dto.ContactDto;

@Service
public class CsvReader implements Reader {

    private static final Logger LOGGER = Logger.getLogger(CsvReader.class.getName());

    @Override
    public List<ContactDto> getData(String fileName) throws IOException {

        LOGGER.log(Level.INFO, "Reading file {0}", fileName);
        List<ContactDto> contacts = new ArrayList<>();
        InputStream inputFS = null;

        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        if (url == null) {
            throw new FileNotFoundException();
        }
        File inputFile = new File(url.getFile());
        inputFS = new FileInputStream(inputFile);
        Object[] lines = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputFS))) {
            lines = reader.lines().toArray();
        }
        for (Object line : lines) {
            ContactDto contact = new ContactDto();
            String[] items = ((String) line).split(",");
            contact.setName(items[0]);
            contact.setUrl(items[1]);
            contacts.add(contact);
        }
        inputFS.close();

        return contacts;
    }
}