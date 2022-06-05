package anft.demo.api.service;

import anft.demo.api.domain.entity.NFT;
import anft.demo.api.domain.repository.NFTRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NFTService {

    private final NFTRepository nftRepository;

    @Transactional
    public NFT addNFT(@RequestParam(required = true) String hashcode, String ownerId, @RequestParam(required = true) Double price) {
        return nftRepository.save(new NFT(hashcode, ownerId, price));
    }

    public NFT findByHashcode(@RequestParam String hashcode) {
        return nftRepository.findByHashcode(hashcode);
    }

    public List<NFT> findAllByOwnerId(@RequestParam String ownerId) {
        return nftRepository.findAllByOwnerId(ownerId);
    }

    public List<NFT> findAll() {
        return nftRepository.findAll();
    }

    public void deleteNFT(@RequestParam String hashcode) {
        nftRepository.deleteById(nftRepository.findByHashcode(hashcode).getId());
    }
}
