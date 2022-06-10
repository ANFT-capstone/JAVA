package anft.demo.service;

import anft.demo.DAO.DatabaseManager;
import anft.demo.DataVo.NftInfoVo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NFTService {

    private final DatabaseManager databaseManager;

    // NFT 전체 목록 조회
    public List<NftInfoVo> findAll() {
        return databaseManager.getAllNft();
    }

    // NFT id로 조회
    public NftInfoVo findByNftId(int nftId) {
        return databaseManager.getNftByNftId(nftId);
    }

    // NFT URI로 조회
    public NftInfoVo findByNftId(String nftUri) {
        return databaseManager.getNftByNftId(nftUri);
    }

    // NFT 제작자 id로 조회
    public List<NftInfoVo> findByUserId(String userId) {
        return databaseManager.getNftListByUserId(userId);
    }

    // 새로운 NFT 정보 DB에 저장
    @Transactional
    public void addNFT(String label, String category, int price, String uri, char isSell, String createUser) {

        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String createDate = today.format(dateTimeFormatter);

        databaseManager.setNewNft(label, category, createDate, price, uri, isSell, createUser);
    }
}
