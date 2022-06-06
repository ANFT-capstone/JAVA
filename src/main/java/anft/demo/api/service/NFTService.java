package anft.demo.api.service;

import DAO.DatabaseManager;
import DataVo.NftInfoVo;
import DataVo.UserInfoVo;
import anft.demo.api.domain.entity.NFT;
import anft.demo.api.domain.repository.NFTRepository;
import anft.demo.api.dto.NFTDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NFTService {

    private final DatabaseManager databaseManager;

    // NFT 전체 목록 조회
    public List<NftInfoVo> findAll() {
        return databaseManager.getAllNft();
    }

    /*
    // NFT 소유자 지갑 주소로 찾기
    public List<NftInfoVo> findByOwnerAddr(@RequestParam String ownerAddress) {
        //return databaseManager.getNftByOwnerAddr();
    }

    // NFT 제작자 지갑 주소로 찾기
    public List<NftInfoVo> findByCreatorAddr(@RequestParam String creatorAddress) {
        //return databaseManager.getNftByCreatorAddr();
    }

    // 새로운 NFT 정보 DB에 저장
    @Transactional
    public NftInfoVo addNFT() {
        return databaseManager.save(new NftInfoVo());
    }
    */
}
