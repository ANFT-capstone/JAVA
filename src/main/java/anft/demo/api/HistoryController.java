package anft.demo.api;

import anft.demo.DataVo.RequestHistoryVo;
import anft.demo.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/history")
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping
    public List<RequestHistoryVo> historyList() {
        return historyService.findAll();
    }

}
