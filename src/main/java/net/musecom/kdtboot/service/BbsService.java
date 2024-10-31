package net.musecom.kdtboot.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.musecom.kdtboot.dto.BbsDto;
import net.musecom.kdtboot.entity.BbsEntity;
import net.musecom.kdtboot.repository.BbsRepository;

@Service
@RequiredArgsConstructor
public class BbsService {


    private final BbsRepository bbsRepository;

    public List<BbsDto> findAll(){
        List<BbsEntity> bbsEntity = bbsRepository.findAll();
        //entity에서 가져온 리스트를 dto로 변환해줘야 리턴한다.
        List<BbsDto> dtoList = new ArrayList<>();
        for(BbsEntity bbsEntity : bbsEntities){
            dtoList.add(BbsDto.toBbsDto(bbsEntity));
        }
        return dtoList;

    }

}
