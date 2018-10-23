package com.contacts.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contacts.dto.ContactDto;
import com.contacts.response.RestResponse;
import com.contacts.search.PageableResult;
import com.contacts.search.SearchCriteria;
import com.contacts.service.ContactServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author caydogdu
 *
 *         This is a controller for rest services
 */
@Controller
@Api(value = "contacts")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactServiceImpl contactService;

    /**
     * @param SearchCriteria criteria
     *
     * @return RestResponse<List<ContactDTO>>
     */
    @ApiOperation(value = "Search and list contacts", response = ResponseEntity.class)
    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    public ResponseEntity<RestResponse<List<ContactDto>>> findContacts(@RequestBody SearchCriteria criteria) {

        RestResponse<List<ContactDto>> contactResponse = new RestResponse<>();
        ResponseEntity<RestResponse<List<ContactDto>>> response = new ResponseEntity<>(contactResponse, HttpStatus.OK);

        try {
            PageableResult<ContactDto> pageableResult = contactService.findContacts(criteria);
            response.getBody().setSuccess(true);
            response.getBody().setResultInfo(pageableResult);
            response.getBody().setResult((List<ContactDto>) pageableResult.getResult());
        } catch (Exception e) {
            logger.error("error", e);
            response.getBody().setSuccess(false);
        }

        return response;
    }

}
