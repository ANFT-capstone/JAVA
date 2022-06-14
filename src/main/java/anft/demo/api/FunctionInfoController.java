package anft.demo.api;

import anft.demo.DataVo.FunctionInfoVo;
import anft.demo.DataVo.NftCategoryVo;
import anft.demo.service.FunctionInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static anft.demo.api.FunctionIndex.CATETORY_LIST;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/{id}/function")
public class FunctionInfoController {

    private final FunctionInfoService functionInfoService;

    // 사용가능한 전체 함수 목록 조회
    @GetMapping
    public List<FunctionInfoVo> functionList() {

        return functionInfoService.findAll();
    }
}
