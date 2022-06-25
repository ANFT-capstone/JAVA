package anft.demo.api;

import anft.demo.DataVo.FunctionInfoVo;
import anft.demo.DataVo.NftCategoryVo;
import anft.demo.service.FunctionInfoService;
import anft.demo.service.HistoryService;
import anft.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static anft.demo.api.FunctionIndex.CATEGORY_LIST;
import static anft.demo.api.FunctionIndex.NFT_LIST;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/{id}/function")
public class FunctionInfoController {

    private final FunctionInfoService functionInfoService;
    private final UserService userService;
    private final HistoryService historyService;

    // 사용가능한 전체 함수 목록 조회
    @GetMapping
    public List<FunctionInfoVo> functionList(@PathVariable(value = "id") String userId) {

        // 요청한 유저가 DB에 없는 경우 DB에 추가
        if(userService.validateUser(userId)) userService.addUser(userId);

        // 히스토리 업데이트
        String parameter = "none";
        historyService.addHistory(userId, NFT_LIST.ordinal(), parameter, 'S');

        return functionInfoService.findAll();
    }
}
