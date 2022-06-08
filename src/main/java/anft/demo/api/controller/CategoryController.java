package anft.demo.api.controller;

import DataVo.NftCategoryVo;
import DataVo.NftInfoVo;
import anft.demo.api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/catetory")
public class CategoryController {

    private final CategoryService categoryService;

    // NFT 카테고리 전체 목록 조회
    @GetMapping
    public List<NftCategoryVo> catetoryList() {

        return categoryService.findAll();
    }

    // 새로운 NFT 카테고리 정보 DB에 저장
    @PostMapping
    public void addCatetory(int categoryId, String category, String createUser, int nftNums) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMdd");
        String createDate = today.format(dateTimeFormatter);

        categoryService.addCatetory(categoryId, category, createDate, createUser, nftNums);
    }
}
