package anft.demo.api;

import anft.demo.DataVo.NftInfoVo;
import anft.demo.DataVo.UserInfoVo;
import anft.demo.service.OwnerGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static anft.demo.api.FunctionIndex.FIND_NFT_BY_NFT_ID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/ownerGroup")
public class OwnerGroupController {

    private final OwnerGroupService ownerGroupService;

    // NFT id로 조회
    @GetMapping(value = "/nftId/{nftId}")
    public List<UserInfoVo> findOwnerGroupByNftId(@PathVariable(value = "nftId") int nftId) {
        return ownerGroupService.findOwnerGroupByNftId(nftId);
    }
}
