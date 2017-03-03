package com.pingconsole.patch.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import com.pingconsole.patch.dto.PatchData;
import com.pingconsole.patch.service.FileDirectoryService;

@Controller
@RequestMapping(value = "/patch")
public class PatchController {
  @Value("${svn.url}")
  private String url;

  @Value("${svn.username}")
  private String name;

  @Value("${svn.password}")
  private String password;
  
  private static final String CREATE_PATCH_PAGE = "patch/index";
  
  @Autowired
  private FileDirectoryService fileDirectoryService;

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public String createNewPatch(ModelMap map) {

      return CREATE_PATCH_PAGE;
  }
  
  
  @RequestMapping(value = "/generatePatch", method = RequestMethod.POST)
  public void export(HttpServletResponse response,
          @RequestParam String revisionNumber, @RequestParam String jiraId,
          @RequestParam String patchPath) throws IOException {
      response.setContentType("text/plain");
      response.setHeader("Content-Disposition", "attachment;filename="
              + jiraId + "_rev_" + revisionNumber + ".txt");
      ServletOutputStream out = response.getOutputStream();
      for (String s : fileDirectoryService.generatePatchPath(patchPath)) {
          out.println(s);
      }
      out.print(';');
      out.flush();
      out.close();
  }
  
  @SuppressWarnings("rawtypes")
  @RequestMapping(value = "/getDataByRevNo", method = RequestMethod.GET)
  @ResponseBody
  public PatchData getDataByRevNo(ModelMap map,
          @RequestParam String revNumbers) throws SVNException {

      PatchData patchData = new PatchData();
      if (revNumbers.contains("-")) {
          String[] revNo = revNumbers.split("-");
          ArrayList<String> path = new ArrayList<>();
          patchData.setPath(path);
          long temp = 0;
          Collection logEntries = getLogEntriesbetweenRevNumber(Integer.parseInt(revNo[0]), Integer.parseInt(revNo[1]));
          for (Iterator entries = logEntries.iterator(); entries.hasNext();) {
              SVNLogEntry logEntry = (SVNLogEntry) entries.next();
              if (logEntry.getRevision() > temp) {
                  patchData.setRevNumber((int) logEntry.getRevision());
                  patchData.setAuthor(logEntry.getAuthor());
                  patchData.setDate(logEntry.getDate().toString());
                  patchData.setJiraId(logEntry.getMessage());
                  temp = logEntry.getRevision();
              }

              if (logEntry.getChangedPaths().size() > 0) {
                  Set changedPathsSet = logEntry.getChangedPaths().keySet();

                  for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths
                          .hasNext();) {
                      SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry
                              .getChangedPaths().get(changedPaths.next());
                      path.add(entryPath.getPath());
                  }
              }
          }

      } else {
          String[] revNo = revNumbers.split(",");
          ArrayList<String> path = new ArrayList<>();
          patchData.setPath(path);
          long temp = 0;
          for (String s : revNo) {
              Collection logEntries = getLogEntriesByRevNumber(Integer
                      .parseInt(s));
              for (Iterator entries = logEntries.iterator(); entries
                      .hasNext();) {
                  SVNLogEntry logEntry = (SVNLogEntry) entries.next();
                  if (logEntry.getRevision() > temp) {
                      patchData.setRevNumber((int) logEntry.getRevision());
                      patchData.setAuthor(logEntry.getAuthor());
                      patchData.setDate(logEntry.getDate().toString());
                      patchData.setJiraId(logEntry.getMessage());
                      temp = logEntry.getRevision();
                  }

                  if (logEntry.getChangedPaths().size() > 0) {
                      Set changedPathsSet = logEntry.getChangedPaths()
                              .keySet();

                      for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths
                              .hasNext();) {
                          SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry
                                  .getChangedPaths().get(changedPaths.next());
                          path.add(entryPath.getPath());
                      }
                  }
              }
          }

      }

      return patchData;

  }
  @SuppressWarnings({ "rawtypes" })
  private Collection getLogEntriesByRevNumber(int revNumber)
          throws SVNException {

      SVNRepository repository = SVNRepositoryFactory.create(SVNURL
              .parseURIDecoded(url));
      ISVNAuthenticationManager authManager = SVNWCUtil
              .createDefaultAuthenticationManager(name, password);
      repository.setAuthenticationManager(authManager);
      Collection logEntries = repository.log(new String[] { "" }, null,
              revNumber, revNumber, true, true);
      return logEntries;
  }

  @SuppressWarnings({ "rawtypes" })
  private Collection getLogEntriesbetweenRevNumber(int revNumberFrom,
          int revNumberTo) throws SVNException {

      SVNRepository repository = SVNRepositoryFactory.create(SVNURL
              .parseURIDecoded(url));
      ISVNAuthenticationManager authManager = SVNWCUtil
              .createDefaultAuthenticationManager(name, password);
      repository.setAuthenticationManager(authManager);
      Collection logEntries = repository.log(new String[] { "" }, null,
              revNumberFrom, revNumberTo, true, true);
      return logEntries;
  }

}
