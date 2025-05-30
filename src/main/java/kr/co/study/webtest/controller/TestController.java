package kr.co.study.webtest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.study.webtest.service.TestService;
import kr.co.study.webtest.entity.Test;
import kr.co.study.webtest.global.Error;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "테스트 API", description = "테스트 컨트롤러")
@Log4j2
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    @Operation(
            summary = "DB 연결 테스트",
            description = "저장된 코드를 바탕으로 데이터를 DB에서 가져옵니다.",
            responses = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Test.class)))
                    ,@ApiResponse(responseCode = "500", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))}
    )
    public Test index() {
        return testService.findByFeeDvcd("MFMB002");
    }

    @GetMapping("/hello")
    @Operation(
            summary = "헬스 체크",
            description = "서버와 접속이 되는지 확인 합니다.",
            responses = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/text", examples = @ExampleObject(value = "\"OK\"")))
                    ,@ApiResponse(responseCode = "500", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))}
    )
    public String hello() {
        return "hello world";
    }

}