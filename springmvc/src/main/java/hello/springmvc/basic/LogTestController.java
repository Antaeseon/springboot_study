package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//RestController로 지정하면 string을 return해도 string 그대로 반환한다.
//@Slf4j를 넣으면 log 변수 자동 생성된다.
//@Slf4j
@RestController
public class LogTestController {
    //package 명이 slf4j인지 꼭 확인 필요
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";



        //이렇게 하면 시간, thread 등등 다양한 정보가 나타난다.
        //각각의 계으로 된다. properties에 info 설정하면 info,warn,error만 출력
        log.trace("trace log={}",name);
        log.debug("debug log={}",name);
        log.info("info log={}",name);
        log.warn("warn log={}",name);
        log.error("error log={}",name);

        //이렇게 사용을 하면 안된다. 이렇게 하면 출력이 되지도 않는 문자열 +가 일어나 리소스 낭비가 일어난다.
        // 문자가 합쳐진 최종 결과까지 하고 안되는거랑
        // 매개변수로 넘기는거는 다르다.
        log.info("info log " + name);


        return "ok";
    }

}
