package net.musecom.kdtboot.dto;

import java.sql.Timestamp;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BbsDto {
    private long num;
    private String title;
    private String contents;
    private String writer;
    private String userid;
    private String password;
    private int count;
    private LocalDateTime datetime;


    public static BbsDto toBbsDto(BbsEntity BbsEntity){
        BbsDto dto = new BbsDto();

        dto.setNum(bbsEntity.getNum());
        dto.settitle(bbsEntity.getTitle());
        dto.setContents(bbsEntity.getCount());
        dto.setWriter(bbsEntity.getWriter());
        dto.setUserid(bbsEntity.getUserid());
        dto.setPassword(bbsEntity.getPassword());
        dto.setCount(bbsEntity.getCount());
        dto.setWdate(bbsEntity.getWdate());
        
        
    }
}
