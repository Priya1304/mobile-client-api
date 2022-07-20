package com.au.mobileclientapi.repository;

import com.au.mobileclientapi.dao.PostCodeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCodeRecordRepository extends JpaRepository<PostCodeRecord,Long> {

    public List<PostCodeRecord> findByPostCode(String postCode);

    public  List<PostCodeRecord> findBySuburb(String suburb);

}
