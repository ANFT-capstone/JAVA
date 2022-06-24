package anft.demo.api;

import anft.demo.DataVo.NftInfoVo;
import anft.demo.service.HistoryService;
import anft.demo.service.NFTService;
import anft.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static anft.demo.api.FunctionIndex.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/{id}/nft")
public class NFTController {

    private final NFTService nftService;
    private final UserService userService;
    private final HistoryService historyService;

    // NFT 전체 목록 조회
    @GetMapping
    public List<NftInfoVo> nftList(@PathVariable(value = "id") String userId) {

        // 요청한 유저가 DB에 없는 경우 DB에 추가
        userService.validateUser(userId);

        // 히스토리 업데이트
        String parameter = "none";
        historyService.addHistory(userId, NFT_LIST.ordinal(), parameter, 'S');
        return nftService.findAll();
    }

    // NFT id로 조회
    @GetMapping(value = "/nftId/{nftId}")
    public NftInfoVo findByNftId(@PathVariable(value = "nftId") int nftId, @PathVariable(value = "id") String userId) {

        // 요청한 유저가 DB에 없는 경우 DB에 추가
        if(userService.validateUser(userId)) userService.addUser(userId);

        // 히스토리 업데이트
        String parameter = "nftId";
        historyService.addHistory(userId, FIND_NFT_BY_NFT_ID.ordinal(), parameter, 'S');

        return nftService.findByNftId(nftId);
    }

    // NFT URI로 조회
    @GetMapping(value = "/nftUri/{nftUri}")
    public NftInfoVo findByNftUri(@PathVariable(value = "nftUri") String nftUri, @PathVariable(value = "id") String userId) {

        // 요청한 유저가 DB에 없는 경우 DB에 추가
        if(userService.validateUser(userId)) userService.addUser(userId);

        // 히스토리 업데이트
        String parameter = "nftUri";
        historyService.addHistory(userId, FIND_NFT_BY_NFT_URI.ordinal(), parameter, 'S');

        return nftService.findByNftId(nftUri);
    }

    // NFT 제작자 id로 조회
    @GetMapping(value = "/userId/{userId}")
    public List<NftInfoVo> findByUserId(@PathVariable(value = "userId") String id, @PathVariable(value = "id") String userId) {

        // 요청한 유저가 DB에 없는 경우 DB에 추가
        if(userService.validateUser(userId)) userService.addUser(userId);

        // 히스토리 업데이트
        String parameter = "userId";
        historyService.addHistory(userId, FIND_NFT_BY_USER_ID.ordinal(), parameter, 'S');

        return nftService.findByUserId(id);
    }

    // 새로운 NFT 정보 DB에 저장
    @PostMapping
    public void addNFT(String label, String category, int price, String uri, char isSell, String createUser,
                       @PathVariable(value = "id") String userId) {

        // 요청한 유저가 DB에 없는 경우 DB에 추가
        if(userService.validateUser(userId)) userService.addUser(userId);

        // 히스토리 업데이트
        String parameter = "label, category, price, uri, isSell, createUser";
        historyService.addHistory(userId, ADD_NFT.ordinal(), parameter, 'S');


        nftService.addNFT(label, category, price, uri, isSell, createUser);
    }
}
