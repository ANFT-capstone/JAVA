package anft.demo.api;

import anft.demo.DataVo.FunctionInfoVo;
import anft.demo.service.FunctionInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class MainController {

    private final FunctionInfoService functionInfoService;

    // NFT 전체 목록 조회
    @GetMapping
    public List<FunctionInfoVo> functionList() {
        System.out.println("main controller");
        return functionInfoService.findAll();
    }
}
