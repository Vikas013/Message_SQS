package com.demo.aws.sqs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("msgRepository")
public interface MsgRepo extends JpaRepository<Msg,Integer> {
}

