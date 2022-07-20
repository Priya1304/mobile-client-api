package com.au.mobileclientapi.service;

import com.au.mobileclientapi.dao.PostCodeRecord;
import com.au.mobileclientapi.repository.PostCodeRecordRepository;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MobileClientServiceImplTest {

    @Autowired
    MobileClientServiceImpl mobileClientService;

    @Autowired
    PostCodeRecordRepository postCodeRecordRepository;

    @Test
    public void shouldFindByPostCode() {
        List<PostCodeRecord> actualResponse = mobileClientService.findByPostCode("3000");
        assertThat(actualResponse, Is.is(getExpectedResponse()));

    }

    @Test
    public void shouldFindBySuburb() {
        List<PostCodeRecord> actualResponse = mobileClientService.findBySuburb("Melbourne");
        assertThat(actualResponse, Is.is(getExpectedResponse()));

    }

    private List<PostCodeRecord> getExpectedResponse() {
        List<PostCodeRecord> postCodeRecordList = new ArrayList<>();
        PostCodeRecord postCodeRecord = new PostCodeRecord();
        postCodeRecord.setPostCode("3000");
        postCodeRecord.setSuburb("Melbourne");
        postCodeRecord.setId(1001L);
        postCodeRecordList.add(postCodeRecord);
        return postCodeRecordList;
    }

}