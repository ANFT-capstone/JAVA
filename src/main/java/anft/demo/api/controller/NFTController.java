package anft.demo.api.controller;

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

    // NFT DB에 추가
    @PostMapping
    public NFT addNFT(@RequestParam(value="hashcode", required = true) String hashcode, String ownerId, @RequestParam(required = true) Double price) {
        if(ownerId == null)
            ownerId = "none";
        return nftService.addNFT(hashcode, ownerId, price);
    }

    // DB의 NFT 리스트 가져오기
    @GetMapping
    public Iterable<NFT> nfts() {
        return nftService.findAll();
    }

    // NFT의 hashcode로 가져오기
    @GetMapping(value = "/searchByHashcode/{hashcode}")
    public Optional<NFT> findByHashcode(@PathVariable String hashcode) {
        return Optional.ofNullable(nftService.findByHashcode(hashcode));
    }

    // NFT의 소유자 id로 가져오기
    @GetMapping(value = "/searchByOwnerId/{ownerId}")
    public Optional<List<NFT>> findByOwnerId(@PathVariable String ownerId) {
        return Optional.ofNullable(nftService.findAllByOwnerId(ownerId));
    }

    // NFT의 hashcode로 지우기
    @DeleteMapping
    public void deleteNFTByHashcode(@RequestParam String hashcode) {
        nftService.deleteNFT(hashcode);
    }
}
