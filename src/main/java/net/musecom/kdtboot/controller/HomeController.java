package net.musecom.kdtboot.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import net.musecom.kdtboot.dto.BbsDto;
import net.musecom.kdtboot.service.BbsService;

@Controller
@RequiredArgsConstructor
public class HomeController {

   private final BbsService bbsService;

   @GetMapping("/")
   public String index(Model model,
     @RequestParam(name="page", defaultValue = "0") int page,
     @RequestParam(name="size", defaultValue = "15") int size,
     @RequestParam(name="searchKey", required = false) String searchKey,
     @RequestParam(name="searchVal", required = false) String searchVal
   ) {
      Pageable pageable = PageRequest.of(page, size, Sort.by("num").descending());
      Page<BbsDto> bbsPage;

      if ((searchKey != null && !searchKey.isEmpty()) && (searchVal != null && !searchVal.isEmpty())) {
         bbsPage = bbsService.search(searchKey, searchVal, pageable);
      } else {
         bbsPage = bbsService.findAll(pageable);
      }

      /* 페이지 그룹 미리 계산 */
      int currentGroup = (page / 15) + 1;
      int startPageOfGroup = (currentGroup - 1) * 15 + 1;
      int endPageOfGroup = Math.min(startPageOfGroup + 14, bbsPage.getTotalPages());

      model.addAttribute("bbsPage", bbsPage);
      model.addAttribute("startPageOfGroup", startPageOfGroup);
      model.addAttribute("endPageOfGroup", endPageOfGroup);

      return "index";
   }

   @GetMapping("/view/{num}")
   public String findById(@PathVariable Long num, Model model) {
      System.out.println("번호: " + num);
      // bbsService.updateCount(num);
      // BbsDto dto = bbsService.findById(num);
      // model.addAttribute("bbs", dto);
      return "view";
   }

   @GetMapping("/write")
   public String write() {
      return "write";
   }

   @PostMapping("/write")
   public String writeForm(@ModelAttribute BbsDto dto) {
      bbsService.save(dto);
      return "redirect:/";
   }
}
