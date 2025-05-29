package kr.co.study.webtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Test {

    @Id
    private String feeDvcd;
    private String feeDvcdNm;
}
