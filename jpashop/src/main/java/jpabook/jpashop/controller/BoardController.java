package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Board;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.BoardService;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final MemberRepository memberRepository;

    @GetMapping("/board")
    public String boardList(Model model) {
        // 게시판 초기화면에 기존에 존재하는 게시글들을 뿌려주기 위해 전체 검색으로 가져온다.
        List<Board> boardLists = boardService.findBoard();

        model.addAttribute("boardLists", boardLists);
        return "/board/board";
    }

    @GetMapping("/board/createForm")
    public String createProc(Model model) {
        model.addAttribute("form", new BoardCreateForm());
        return "board/createForm";
    }

    @PostMapping("/board/createForm")
    public String createForm(BoardCreateForm form, Principal principal) {

        log.info("BoardController");

        String connectUser = principal.getName();
        Optional<Member> member = memberRepository.findByEmail(connectUser);

        member.ifPresent(value -> boardService.create(value, form.getSubject(), form.getMainText()));

        return "redirect:/board";
    }

    // select board
    @GetMapping("/board/{boardId}")
    public String selectBoard(@PathVariable Long boardId, Model model) {
        Board board = boardService.findOne(boardId);

        // 조회수 증가
        boardService.updateViewCount(boardId);

        model.addAttribute("board", board);

        return "board/selectForm";
    }

    // board update
    @GetMapping("/board/{boardId}/edit")
    public String updateBoardForm(@PathVariable Long boardId, Model model, Principal principal) {
        // 수정할 게시글 정보 가져오기
        Board board = boardService.findOne(boardId);

        // FIXME: 조금 더 세련된 코딩방법 고민해보기
        // if 문의 연속사용은 좋지 않고, 검색기능을 만들기 전까지 user 는 반드시 존재할 것이므로 옵셔널로 체크하기 전에 걸러내는 방법을 찾자
        // BoardService 에서 로직을 처리하는 것이 더 나을 것 같다.
        Optional<Member> user = memberRepository.findByEmail(principal.getName());
        if (user.isPresent()) {
            // 로그인한 사용자가 작성자인지 확인
            if (user.get().getId().equals(board.getId())) {
                // 수정 버튼을 클릭할 경우 표시해줄 value 세팅
                model.addAttribute("board", board);
                return "board/updateForm";
            } else {
                return "redirect:/board";
            }
        }

        return "redirect:/";

    }

    // post board update
    @PostMapping("/board/{boardId}/edit")
    public String updateForm(@PathVariable Long boardId, @ModelAttribute("board") BoardCreateForm form) {

        boardService.update(boardId, form.getSubject(), form.getMainText());
        return "redirect:/board";
    }


    // 현재 로그인한 유저의 아이디 가져오기
//    @GetMapping("/username")
//    @ResponseBody
//    public String currentUserName(Principal principal) {
//        return principal.getName();
//    }

}
