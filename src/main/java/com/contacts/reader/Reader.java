package com.contacts.reader;

import java.io.IOException;
import java.util.List;

import com.contacts.dto.ContactDto;

/**
 *
 * @author caydogdu This is a interface for getting data
 */
public interface Reader {

    List<ContactDto> getData(String fileName) throws IOException;

}
