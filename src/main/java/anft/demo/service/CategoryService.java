package anft.demo.service;

import anft.demo.DAO.DatabaseManager;
import anft.demo.DataVo.NftCategoryVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final DatabaseManager databaseManager;

    // NFT 카테고리 전체 목록 조회
    public List<NftCategoryVo> findAll() {
        return databaseManager.getAllCategory();
    }

    // 새로운 NFT 카테고리 정보 DB에 저장
    @Transactional
    public void addCatetory(String category, String createUser, int nftNums) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String createDate = today.format(dateTimeFormatter);

        databaseManager.setNewCategory(category, createDate, createUser, nftNums);
    }
}
