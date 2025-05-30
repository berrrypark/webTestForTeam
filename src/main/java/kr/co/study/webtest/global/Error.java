package kr.co.study.webtest.global;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "에러 DTO")
@AllArgsConstructor
@Data
public class Error {

    @Schema(description = "응답 코드", example = "9999")
    String returnCode;

    @Schema(description = "응답 메시지", example = "예상치 못한 에러 발생")
    String returnMsg;
}

