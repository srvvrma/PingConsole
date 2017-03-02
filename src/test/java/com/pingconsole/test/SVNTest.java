package com.neo.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class SVNTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String url = "https://nucnocorpsvn.nucleussoftware.com:18080/svn/neo_cas/branches/neo";
		String name = "saurabh.verma1";
		String password = "Saurav@2211";
		SVNRepository repository = null;
		long startRevision = 0;
		long endRevision = 0; // HEAD (the latest) revision
		Collection logEntries = null;
		try {
			repository = SVNRepositoryFactory.create(SVNURL
					.parseURIDecoded(url));
			ISVNAuthenticationManager authManager = SVNWCUtil
					.createDefaultAuthenticationManager(name, password);
			repository.setAuthenticationManager(authManager);
			endRevision = repository.getLatestRevision();
			startRevision = endRevision - 5;
			logEntries = repository.log(new String[] { "" }, null,
					startRevision, endRevision, true, true);
			for (Iterator entries = logEntries.iterator(); entries.hasNext();) {
				SVNLogEntry logEntry = (SVNLogEntry) entries.next();
				System.out
						.println("---------------------------------------------");
				System.out.println("revision: " + logEntry.getRevision());
				System.out.println("author: " + logEntry.getAuthor());
				System.out.println("date: " + logEntry.getDate());
				System.out.println("log message: " + logEntry.getMessage());

				if (logEntry.getChangedPaths().size() > 0) {
					System.out.println();
					System.out.println("changed paths:");
					Set changedPathsSet = logEntry.getChangedPaths().keySet();

					for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths
							.hasNext();) {
						SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry
								.getChangedPaths().get(changedPaths.next());
						System.out
								.println(" "
										+ entryPath.getType()
										+ " "
										+ entryPath.getPath()
										+ ((entryPath.getCopyPath() != null) ? " (from "
												+ entryPath.getCopyPath()
												+ " revision "
												+ entryPath.getCopyRevision()
												+ ")"
												: ""));
					}
				}
			}
		} catch (SVNException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
