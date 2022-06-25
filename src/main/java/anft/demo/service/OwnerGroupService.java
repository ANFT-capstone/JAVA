package anft.demo.service;

import anft.demo.DAO.DatabaseManager;
import anft.demo.DataVo.NftInfoVo;
import anft.demo.DataVo.NftOwnerGroupInfoVo;
import anft.demo.DataVo.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerGroupService {

    private final DatabaseManager databaseManager;

    // NFT id로 조회
    public List<UserInfoVo> findOwnerGroupByNftId(int nftId) {

        return databaseManager.getOwnerListByNftId(nftId);
    }

}
