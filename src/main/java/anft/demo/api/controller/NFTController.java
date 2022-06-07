package anft.demo.api.controller;

import DAO.DatabaseManager;
import DataVo.NftInfoVo;
import anft.demo.api.domain.entity.NFT;
import anft.demo.api.service.NFTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    // NFT id로 조회
    @GetMapping(value = "/searchByNftId/{NftId}")
    public NftInfoVo findByNftId(@PathVariable int nftId) {
        return nftService.findByNftId(nftId);
    }

    // NFT URI로 조회
    @GetMapping(value = "/searchByNftUri/{NftUri}")
    public NftInfoVo findByNftId(@PathVariable String NftUri) {
        return nftService.findByNftId(NftUri);
    }

    // NFT 제작자 id로 조회
    @GetMapping(value = "/searchByUserId/{UserId}")
    public List<NftInfoVo> findByUserId(@PathVariable String UserId) {
        return nftService.findByUserId(UserId);
    }

    // 새로운 NFT 정보 DB에 저장
    @PostMapping
    public void addNFT(int nftId, String label, String category, int price, String uri, char isSell, String createUser) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd");
        String createDate = today.format(dateTimeFormatter);

        nftService.addNFT(nftId, label, category, createDate, price, uri, isSell, createUser);
    }
}
