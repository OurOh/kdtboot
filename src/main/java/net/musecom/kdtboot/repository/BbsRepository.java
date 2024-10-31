package net.musecom.kdtboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.musecom.kdtboot.entity.BbsEntity;

public interface BbsRepository extends JpaRepository<BbsEntity, Long>{



}

/*
1. 저장 save(entity) : insert
2. 조회 findById(id), findAll(),
3. 주어진 값이 있는지 조회: boolean ex = exRepository.existById(id);
4. 수정: save(entity) : update
5. 삭제: deleteById(id);
6. 전체 게시물의 수: count();
*/ 