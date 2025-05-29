package kr.co.study.webtest.mapper;

import kr.co.study.webtest.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, String> {

    Test findByFeeDvcd(String feeDvcd);
}
