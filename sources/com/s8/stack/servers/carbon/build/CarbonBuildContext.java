package com.s8.stack.servers.carbon.build;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import com.s8.stack.servers.carbon.assets.WebAsset;
import com.s8.stack.servers.carbon.web.AssetContainerModule;
import com.s8.stack.servers.carbon.web.AssetUpdateModule;


/**
 * 
 * @author pierreconvert
 *
 */
public class CarbonBuildContext {

	
	/**
	 * 
	 */
	private final Path localPath;

	
	/**
	 * 
	 */
	private final String webPathname;

	
	/**
	 * 
	 */
	protected final AssetContainerModule container;

	
	/**
	 * 
	 */
	protected final AssetUpdateModule updater;

	
	/**
	 * 
	 */
	protected final Set<String> excludedWebPathnames;

	
	protected final boolean isVerbose;

	/**
	 * 
	 * @param container
	 * @param updater
	 */
	public CarbonBuildContext(AssetContainerModule container, 
			AssetUpdateModule updater, 
			String webPathname, 
			Path localPath,
			boolean isVerbose) {
		super();
		this.container = container;
		this.updater = updater;
		this.excludedWebPathnames = new HashSet<String>();
		this.isVerbose = isVerbose;
		this.webPathname = webPathname;
		this.localPath = localPath;
	}



	public CarbonBuildContext(CarbonBuildContext context, String webPathname, Path localPath) {
		super();
		
		// copy previous context
		this.container = context.container;
		this.updater = context.updater;
		this.excludedWebPathnames = context.excludedWebPathnames;
		this.isVerbose = context.isVerbose;
		
		// pathnames
		this.webPathname = webPathname;
		this.localPath = localPath;
	}


	public boolean isWebPathnameExcluded(String pathname) {
		return this.excludedWebPathnames.contains(pathname);
	}


	public void exclude(String pathname) {
		this.excludedWebPathnames.add(pathname);
	}



	public WebAsset get(String webPathname) {
		return container.get(webPathname);
	}


	public boolean hasBeenCaptured(String webPathname) {
		return container.hasEntry(webPathname);
	}


	public AssetContainerModule getContainer() {
		return container;
	}


	public AssetUpdateModule getUpdater() {
		return updater;
	}





	public Path getLocalPath() {
		return localPath;
	}

	public String getWebPathname() {
		return webPathname;
	}







	/**
	 * 
	 * @param pathname
	 * @return
	 */
	public CarbonBuildContext move(String pathname) {
		return new CarbonBuildContext(this,
				webPathname.concat(pathname), 
				localPath.resolve(pathname));
	}

	
	/**
	 * 
	 * @param webPathname
	 * @param path
	 * @return
	 */
	public CarbonBuildContext relocate(String webPathname, Path path) {
		return new CarbonBuildContext(this, webPathname, path);
		
	}


	/**
	 * 
	 * @return
	 */
	public boolean isVerbose() {
		return isVerbose;
	}
	
	
	public boolean isWebPathnameRegistered() {
		return container.hasEntry(webPathname);
	}


}
