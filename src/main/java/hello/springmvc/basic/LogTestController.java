package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // 롬복이 제공
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "spring";

        System.out.println("name = " + name);

        /* 어떤 상태의 레벨인가를 log 보고 판별할 수 있다. -> 아래 레벨 순?*/

        log.debug("debug log={}", name);  // 개발 서버에서 보는거다?
        log.info("info log={}", name);   // 운영 서버?
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
