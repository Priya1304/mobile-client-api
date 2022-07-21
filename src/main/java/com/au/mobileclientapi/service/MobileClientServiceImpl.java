package com.au.mobileclientapi.service;

import com.au.mobileclientapi.dao.PostCodeRecord;
import com.au.mobileclientapi.repository.PostCodeRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MobileClientServiceImpl implements MobileClientService{

    PostCodeRecordRepository postCodeRecordRepository;

    @Autowired
    public MobileClientServiceImpl(PostCodeRecordRepository postCodeRecordRepository) {
        this.postCodeRecordRepository = postCodeRecordRepository;
    }

    /**
     * Finds by postcode
     * @param postCode
     * @return
     */
    @Override
    public List<PostCodeRecord> findByPostCode(String postCode) {
       return postCodeRecordRepository.findByPostCode(postCode);
    }

    /**
     * Finds by suburb
     * @param suburb
     * @return
     */
    @Override
    public List<PostCodeRecord> findBySuburb(String suburb) {
        return postCodeRecordRepository.findBySuburb(suburb);
    }

    /**
     * Adds new record
     * @param postCodeRecord
     * @return
     */
    @Override
    public PostCodeRecord addNewRecord(PostCodeRecord postCodeRecord) {
        return postCodeRecordRepository.save(postCodeRecord);
    }
}
