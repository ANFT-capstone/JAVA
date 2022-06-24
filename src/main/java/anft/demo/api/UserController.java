package anft.demo.api;

import anft.demo.DataVo.UserInfoVo;
import anft.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    // 유저 전체 목록 조회
    @GetMapping
    public List<UserInfoVo> userList() {
        return userService.findAll();
    }

    // 유저 id로 조회
    @GetMapping(value = "/userId/{userId}")
    public UserInfoVo findByUserId(@PathVariable String userId) {

        return userService.findByUserId(userId);
    }

}
