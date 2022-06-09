package anft.demo.service;

import DAO.DatabaseManager;
import DataVo.NftInfoVo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public void addNFT(int nftId, String label, String category, String createDate, int price, String uri, char isSell, String createUser) {
        databaseManager.setNewNft(nftId, label, category, createDate, price, uri, isSell, createUser);
    }
}
