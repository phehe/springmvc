package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 기본 요청
     * 둘다 허용 /hello-basic, /hello-basic/
     * HTTP 메서드 모두 허용 GET, HEAD, POST, PUT, PATCH, DELETE
     */
    //     @RequestMapping({"/hello-basic","/hello-go"})   --> mapping 여러개 가능 {안에}
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        logger.info("helloBasic");
        return "ok";
    }

    /**
     * method 특정 HTTP 메서드 요청만 허용
     * GET, HEAD, POST, PUT, PATCH, DELETE
     */
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        logger.info("mappingGetV1");
        return "ok";
    }


    /**
     * 편리한 축약 애노테이션 (코드보기)
     *
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        logger.info("mapping-get-v2");
        return "ok";
    }

    /*
     *  PathVariable 사용
     *  변수명이 같으면 생략 가능
     *
     *  @PathVariable("userId") String userId -> @PathVariable userId
     *  /mapping/userA
     * */

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        logger.info("mappingPath userId={}", data);
        return "ok";
    }

    /*
     *   PathVariable 다중 사용
     * */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        logger.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }
}
