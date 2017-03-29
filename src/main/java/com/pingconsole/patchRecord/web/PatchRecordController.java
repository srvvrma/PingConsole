package com.pingconsole.patchRecord.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/patchManager")
public class PatchRecordController {
  
  public String loadCreateUpdatePatchRecord(Model model, @RequestParam Long id){
    
    
    return "patchManager/createUpdate";
  }

}
