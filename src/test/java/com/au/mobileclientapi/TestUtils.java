package com.au.mobileclientapi;

import com.au.mobileclientapi.dao.PostCodeRecord;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static PostCodeRecord getNewRecord() {

        PostCodeRecord postCodeRecord = new PostCodeRecord();
        postCodeRecord.setPostCode("3000");
        postCodeRecord.setSuburb("Melbourne");
        postCodeRecord.setId(1001L);

        return postCodeRecord;
    }

    public static List<PostCodeRecord> getSearchResult() {
        List<PostCodeRecord> postCodeRecordList = new ArrayList<>();
        PostCodeRecord postCodeRecord = new PostCodeRecord();
        postCodeRecord.setPostCode("3008");
        postCodeRecord.setSuburb("Docklands");
        postCodeRecord.setId(1002L);
        postCodeRecordList.add(postCodeRecord);
        return postCodeRecordList;
    }
}
