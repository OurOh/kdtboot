package net.musecom.kdtboot.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.musecom.kdtboot.dto.BbsDto;
import net.musecom.kdtboot.entity.BbsEntity;
import net.musecom.kdtboot.repository.BbsRepository;

@Service
@RequiredArgsConstructor
public class BbsService {

    private final BbsRepository bbsRepository;

    public Page<BbsDto> findAll(Pageable pageable) {
        Page<BbsEntity> bbsEntity = bbsRepository.findAll(pageable);
        return bbsEntity.map(BbsDto::toBbsDto);  
    }

    public Page<BbsDto> search(String searchKey, String searchVal, Pageable pageable) {
        Page<BbsEntity> bbsEntity;
        switch(searchKey) {
            case "title":
                bbsEntity = bbsRepository.findByTitleContaining(searchVal, pageable);
                break;
            case "writer":
                bbsEntity = bbsRepository.findByWriterContaining(searchVal, pageable);
                break;
            case "contents":
                bbsEntity = bbsRepository.findByContentsContaining(searchVal, pageable);
                break;
            default:
                bbsEntity = Page.empty();
                break;
        }
        return bbsEntity.map(BbsDto::toBbsDto);  
    }

    public void save(BbsDto dto) {
        BbsEntity bbsEntity = BbsEntity.toSaveEntity(dto); 
        bbsRepository.save(bbsEntity);
    }
   
    @Transactional
    public void updateCount(Long id){
        bbsRepository.updateCount(id);
    }

    public BbsDto findById(Long id) {
        Optional<BbsEntity> opBbsEntity = bbsRepository.findById(id);
        if(opBbsEntity.isPresent()){
            BbsEntity bbsEntity = opBbsEntity.get();
            BbsDto dto = BbsDto.toBbsDto(bbsEntity);
            return dto;
        }else{
            return null;
        }    
    }
}
