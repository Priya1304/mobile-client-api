package com.au.mobileclientapi.controller;

import com.au.mobileclientapi.dao.PostCodeRecord;
import com.au.mobileclientapi.exception.RecordNotFoundException;
import com.au.mobileclientapi.service.MobileClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.List;


@RestController
@RequestMapping(path = "/v1/")
@Validated
@Slf4j
public class MobileClientController {




    MobileClientService mobileClientService;

    @Autowired
    public MobileClientController(MobileClientService mobileClientService) {
        this.mobileClientService = mobileClientService;
    }

    /**
     * GET request to search by postCode
     * @param postCode must be 4 digits - Australian postcode format
     * @return The JSON response containing suburb information for a given postcode
     */
    @GetMapping(path = "/api/search/postCode/{postCode}")
    public ResponseEntity<List<PostCodeRecord>> searchByPostCode(@PathVariable("postCode")
                                              @Pattern(regexp ="\\d{4}", message = "Invalid Australian PostCode Format") String postCode) {
        log.info("Received GET Request to search by postcode: {} ", postCode);
        List<PostCodeRecord> searchResult = mobileClientService.findByPostCode(postCode);
        if (searchResult.isEmpty()) {
            throw new RecordNotFoundException("The PostCode is not found: "+ postCode);
        }
        log.info("Sending Response: {} ", searchResult);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }

    /**
     * GET request to search by suburb
     * @param suburb
     * @return The JSON response containing postcode information for a given suburb
     */
    @GetMapping(path = "/api/search/suburb/{suburb}")
    public ResponseEntity<List<PostCodeRecord>> searchBySuburbName(@PathVariable("suburb") String suburb) {
        log.info("Received GET Request to search by suburb name: {} ", suburb);
        List<PostCodeRecord> searchResult = mobileClientService.findBySuburb(suburb);
        if (searchResult.isEmpty()) {
            throw new RecordNotFoundException("The Suburb is not found: "+ suburb);
        }
        log.info("Sending Response: {} ", searchResult);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }

    /**
     * POST request to search by suburb
     * @param postCodeRecord
     * @return The JSON response containing postcode information for a given suburb
     */
    @PostMapping(path = "/api/update/addressRecord")
    public ResponseEntity<PostCodeRecord> addNewAddressRecord(@RequestBody PostCodeRecord postCodeRecord) {
        log.info("Received GET Request to search by suburb name: {} ", postCodeRecord);
        PostCodeRecord savedResult = mobileClientService.addNewRecord(postCodeRecord);
        log.info("Address Record created: {} ", savedResult);

        return new ResponseEntity<>(savedResult, HttpStatus.CREATED);
    }
}
