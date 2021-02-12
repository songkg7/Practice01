package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 작성자

    @NotNull
    private String subject; // 제목

    @NotNull
    @Lob
    private String mainText; // 본문

    private LocalDateTime createTime;

    @Column(columnDefinition = "bigint default 0")
    private Long viewCount; // 조회수

    public static Board createBoard(Member member, String subject, String mainText) {
        Board board = new Board();
        board.setMember(member);
        board.setSubject(subject);
        board.setMainText(mainText);
        board.setCreateTime(LocalDateTime.now());
        board.setViewCount(0L);

        return board;
    }



}
