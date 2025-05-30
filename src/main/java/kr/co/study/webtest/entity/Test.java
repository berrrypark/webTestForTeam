package kr.co.study.webtest.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Schema(description = "Test 엔티티")
public class Test {

    @Id
    @Schema(description = "테스트 코드", example = "MFMB002")
    private String feeDvcd;

    @Schema(description = "테스트 코드 이름", example = "등록")
    private String feeDvcdNm;
}
