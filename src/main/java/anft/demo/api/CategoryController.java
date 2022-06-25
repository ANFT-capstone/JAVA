package anft.demo.api;

import anft.demo.DataVo.NftCategoryVo;
import anft.demo.service.CategoryService;
import anft.demo.service.HistoryService;
import anft.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static anft.demo.api.FunctionIndex.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/{id}/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final UserService userService;
    private final HistoryService historyService;

    // NFT 카테고리 전체 목록 조회
    @GetMapping
    public List<NftCategoryVo> catetoryList(@PathVariable(value = "id") String userId) {

        // 요청한 유저가 DB에 없는 경우 DB에 추가
        if(userService.validateUser(userId)) userService.addUser(userId);

        // 히스토리 업데이트
        String parameter = "none";
        historyService.addHistory(userId, CATEGORY_LIST.ordinal(), parameter, 'S');

        return categoryService.findAll();
    }

    // 새로운 NFT 카테고리 정보 DB에 저장
    @PostMapping
    public void addCatetory(String category, String createUser, int nftNums,
                            @PathVariable(value = "id") String userId) {

        // 요청한 유저가 DB에 없는 경우 DB에 추가
        if(userService.validateUser(userId)) userService.addUser(userId);

        // 히스토리 업데이트
        String parameter = "category, createUser, nftNums";
        historyService.addHistory(userId, ADD_NFT.ordinal(), parameter, 'S');

        categoryService.addCategory(category, createUser, nftNums);
    }
}
