package anft.demo.api.controller;

import DAO.DatabaseManager;
import DataVo.NftInfoVo;
import anft.demo.api.domain.entity.NFT;
import anft.demo.api.service.NFTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/nft")
public class NFTController {

    private final NFTService nftService;

    // NFT 전체 목록 조회
    @GetMapping
    public List<NftInfoVo> nftList() {

        return nftService.findAll();
    }

    /*
    // NFT 소유자 지갑 주소로 찾기
    @GetMapping(value = "/searchByOwner/{ownerAddr}")
    public List<NftInfoVo> findByOwnerAddr(@PathVariable String ownerAddr) {
        //return nftService.findByOwnerAddr(ownerAddr);
    }

    // NFT 제작자 지갑 주소로 찾기
    @GetMapping(value = "/searchByCreator/{creatorAddr}")
    public List<NftInfoVo> findByCreatorAddr(@PathVariable String creatorAddr) {
        //return nftService.findByCreatorAddr(creatorAddr);
    }

    // 새로운 NFT 정보 DB에 저장
    @PostMapping
    public NftInfoVo addNFT() {
        return nftService.addNFT();
    }
    */
}
