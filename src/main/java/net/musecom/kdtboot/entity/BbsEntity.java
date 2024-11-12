package net.musecom.kdtboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import net.musecom.kdtboot.dto.BbsDto;

@Entity
@Getter
@Setter
@Table(name="bbs_bbs")
public class BbsEntity extends BbsTimeEntity{
   @Id //primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가   
   private Long num;

   @Column(length=255)
   private String title;
   
   @Column(columnDefinition = "TEXT")  //db에서 text타입으로 셋팅
   private String contents;

   @Column(length=40)
   private String writer;

   @Column(length=40)
   private String userid;

   @Column(length=40)
   private String password;

   @Column 
   private int count;

   /*
   @Column
   private Timestamp wdate;
   */

   public static BbsEntity toSaveEntity(BbsDto dto) {
      BbsEntity bbsEntity = new BbsEntity();
      bbsEntity.setTitle(dto.getTitle());
      bbsEntity.setContents(dto.getContents());
      bbsEntity.setWriter(dto.getWriter());
      bbsEntity.setUserid(dto.getUserid());
      bbsEntity.setPassword(dto.getPassword());
      bbsEntity.setCount(dto.getCount());

      return bbsEntity;
   }
}
