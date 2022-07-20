package com.au.mobileclientapi.service;

import com.au.mobileclientapi.dao.PostCodeRecord;

import java.util.List;

public interface MobileClientService {

    public List<PostCodeRecord> findByPostCode(String postCode);

    public List<PostCodeRecord> findBySuburb(String suburb);

    public PostCodeRecord addNewRecord(PostCodeRecord postCodeRecord);
}
