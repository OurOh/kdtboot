package net.musecom.kdtboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.musecom.kdtboot.entity.BbsEntity;

public interface BbsRepository extends JpaRepository<BbsEntity, Long>{
   
    Page<BbsEntity> findByTitleContaining(String title, Pageable pageable);

    Page<BbsEntity> findByContentsContaining(String contents, Pageable pageable);

    Page<BbsEntity> findByWriterContaining(String writer, Pageable pageable);

    //업데이트를 위한 저장소 셋팅 : update bbs_bbs set count=count+1 where num=?
    @Modifying
    @Query(value="update BbsEntity b set b.count=b.count+1 where b.num=:id")
    void updateCount(@Param("id") Long id);
}

/*
 *  1. 저장 : save(entity) : insert
 *  2. 조회 : findById(id), findAll(), 
 *  3. 주어진 값이 있는지 조회 : boolean ex = exRepository.existsById(id);
 *  4. 수정 : save(entity) : update
 *  5. 삭제 : deleteById(id);
 *  6. 전체개시물의 수 : count();
 * 
 *  JPA - Pageable
 *  getPageNumber() - 현제 페이지 번호를 반환 (0 부터 시작)
 *  getPageSize() - 한 페이지에 최대 항목수
 *  getOffset() - 시작위치
 *  getSort() - 정렬방법
 *  next() - 다음페이지
 *  previous() : 이전페이지
 * 
 *  PageRequest(클래스) PageRequest(int page, int size, Sort sort, ...)
 */
