package org.galapagos.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.galapagos.domain.PageDTO;
import org.galapagos.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public void list(@ModelAttribute("cri") Criteria cri, Model model) {

        log.info("list" + cri);
        int total = boardService.getTotal(cri);

        //model.addAttribute("list", boardService.getList());
        model.addAttribute("list", boardService.getList(cri));
        model.addAttribute("pageMaker", new PageDTO(cri, total)); //임의로 123 요청
    }

    @GetMapping("/register")
    public void register() {
        log.info("register");
    }

    @PostMapping("/register")
    public String register(BoardVO boardVO, RedirectAttributes rttr) {

        log.info("register : " + boardVO);

        boardService.register(boardVO);

        rttr.addFlashAttribute("result", boardVO.getBno());

        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/modify"})
    public void get(@RequestParam("bno") Long bno,
                    @ModelAttribute("cri") Criteria cri,
                    Model model) {

        log.info("/get or modify");
        model.addAttribute("board", boardService.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO board,
                         @ModelAttribute("cri") Criteria cri,
                         RedirectAttributes rttr) {
        log.info("modify : " + board);

        if (boardService.modify(board)) {
            //Flash --> 1회성
            rttr.addFlashAttribute("result", "success");
            rttr.addAttribute("bno", board.getBno());
            rttr.addAttribute("pageNum", cri.getPageNum());
            rttr.addAttribute("amount", cri.getAmount());
        }
        return "redirect:/board/get";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno,
                         @ModelAttribute("cri") Criteria cri,
                         RedirectAttributes rttr) {

        log.info("remove..." + bno);
        if (boardService.remove(bno)) {
            rttr.addFlashAttribute("result", "success");
            rttr.addAttribute("pageNum", cri.getPageNum());
            rttr.addAttribute("amount", cri.getAmount());
        }
        return "redirect:/board/list";
    }
}
