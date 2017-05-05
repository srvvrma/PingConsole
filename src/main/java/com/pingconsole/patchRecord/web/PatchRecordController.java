package com.pingconsole.patchRecord.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pingconsole.dashboard.service.UserDashboardService;
import com.pingconsole.environment.domain.EnvironmentDTO;
import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.patchManager.domain.PatchManagerDTO;
import com.pingconsole.patchRecord.domain.PatchRecordDTO;
import com.pingconsole.patchRecord.service.PatchRecordService;

@Controller
@RequestMapping("/patchRecord")
public class PatchRecordController {

  @Value("${jiraUrl}")
  private static String jiraUrl;

  @Autowired
  private EnvironmentService environmentService;

  @Autowired
  private UserDashboardService userDashboardService;

  @Autowired
  private PatchRecordService patchRecordService;

  @RequestMapping("/showAll")
  public String showAllPatchManager(Model model) {
    model.addAttribute("patchRecordDTOs", patchRecordService.findAllDTOs());
    model.addAttribute("jiraUrl",jiraUrl + "/browse/");
    return "patchRecord/index";
  }

  @RequestMapping("/createUpdate")
  public String loadCreateUpdatePatchRecord(Model model, @RequestParam Long id) {
    PatchRecordDTO patchRecordDTO = null;
    if (id == null) {
      patchRecordDTO = new PatchRecordDTO();
    } else {

    }
    List<EnvironmentDTO> environementDTOs = environmentService.getAllEnvironment();
    model.addAttribute("allUsers", userDashboardService.getAllUserList());
    model.addAttribute("environments", environementDTOs);
    model.addAttribute("patchRecordDTO", patchRecordDTO);
    return "patchRecord/createUpdate";
  }

  @RequestMapping(value = "/createUpdate", method = RequestMethod.POST)
  public String createUpdatePatchManager(Model model,
      @ModelAttribute PatchRecordDTO patchRecordDTO) {
    patchRecordService.savePatchRecord(patchRecordDTO);
    return "blank";
  }

  @RequestMapping(value = "/remove", method = RequestMethod.GET)
  public String createUpdatePatchManager(Model model, @RequestParam Long id) {
    patchRecordService.removePatchRecord(id);
    return "blank";
  }

  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }
}
