
package com.au.mobileclientapi.controller;

import com.au.mobileclientapi.TestUtils;
import com.au.mobileclientapi.dao.PostCodeRecord;
import com.au.mobileclientapi.exception.RecordNotFoundException;
import com.au.mobileclientapi.service.MobileClientService;
import org.assertj.core.api.Assertions;
import org.hamcrest.core.Is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MobileClientControllerTest {

/*    @Autowired
    MockMvc mockMvc;*/

    @Autowired
    MobileClientService mobileClientService;

    @Autowired
    MobileClientController mobileClientController;


    @Test
    public void shouldReturnPostCode() throws Exception {

        ResponseEntity<List<PostCodeRecord>>  responseEntity = mobileClientController.searchByPostCode("3008");

        assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), Is.is(TestUtils.getSearchResult()));

    }

    @Test
    public void shouldReturnSuburbName() throws Exception {

        ResponseEntity<List<PostCodeRecord>>  responseEntity = mobileClientController.searchBySuburbName("Docklands");

        assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), Is.is(TestUtils.getSearchResult()));

    }

    @Test
    public void shouldAddNewRecord() throws Exception {
        ResponseEntity<PostCodeRecord>  responseEntity = mobileClientController.addNewAddressRecord(TestUtils.getNewRecord());
        assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.CREATED));

    }

    @Test(expected = RecordNotFoundException.class)
    public void shouldReturnExceptionWhenPostCodeIsInvalid() throws Exception {

        ResponseEntity<List<PostCodeRecord>>  responseEntity = mobileClientController.searchBySuburbName("3006");

        assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.BAD_REQUEST));
        assertThat(responseEntity.getBody(), Is.is(TestUtils.getSearchResult()));

    }



}

