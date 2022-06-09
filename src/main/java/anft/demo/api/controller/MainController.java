package anft.demo.api.controller;

import DataVo.FunctionInfoVo;
import DataVo.NftInfoVo;
import anft.demo.api.service.FunctionInfoService;
import anft.demo.api.service.NFTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class MainController {

    private final FunctionInfoService functionInfoService;

    // NFT 전체 목록 조회
    @GetMapping
    public List<FunctionInfoVo> functionList() {

        return functionInfoService.findAll();
    }
}
