package com.contacts.reader;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.contacts.Application;
import com.contacts.dto.ContactDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CsvReaderTest {

    @Autowired
    private Reader csvReader;

    @Test
    public void getDataTest() throws Exception {

        List<ContactDto> data = csvReader.getData("people.csv");
        assertTrue(data.size() > 0);

    }

}
