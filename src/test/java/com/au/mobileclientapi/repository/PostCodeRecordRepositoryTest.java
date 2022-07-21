package com.au.mobileclientapi.repository;

import com.au.mobileclientapi.TestUtils;
import com.au.mobileclientapi.dao.PostCodeRecord;
import org.assertj.core.api.Assertions;
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
public class PostCodeRecordRepositoryTest {

    @Autowired
    PostCodeRecordRepository postCodeRecordRepository;

    @Test
    public void shouldFindByPostCode() {
        List<PostCodeRecord> actualResponse = postCodeRecordRepository.findByPostCode("3000");
        assertThat(actualResponse, Is.is(getExpectedResponse()));

    }

    @Test
    public void shouldFindBySuburb() {
        List<PostCodeRecord> actualResponse = postCodeRecordRepository.findBySuburb("Melbourne");
        assertThat(actualResponse, Is.is(getExpectedResponse()));

    }
    @Test
    public void shouldSaveNewRecord() {
        postCodeRecordRepository.save(TestUtils.getNewRecord());
        List<PostCodeRecord> postCodeRecordList = postCodeRecordRepository.findAll();
        Assertions.assertThat(postCodeRecordList.stream().findFirst().get()).isEqualTo(TestUtils.getNewRecord());
        Assertions.assertThat(postCodeRecordList).isNotNull();
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