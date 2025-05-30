package kr.co.study.webtest.service;

import kr.co.study.webtest.entity.Test;
import kr.co.study.webtest.mapper.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final TestRepository testRepository;

    public Test findByFeeDvcd(String feeDvcd) {
        return testRepository.findByFeeDvcd(feeDvcd);
    }
}
