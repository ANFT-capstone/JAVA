package anft.demo.service;

import anft.demo.DAO.DatabaseManager;
import anft.demo.DataVo.NftCategoryVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public void addCatetory(int categoryId, String category, String createDate, String createUser, int nftNums) {
        databaseManager.setNewCategory(categoryId, category, createDate, createUser, nftNums);
    }
}
