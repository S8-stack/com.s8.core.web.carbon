package com.s8.stack.servers.carbon.build.filters.basics;

import com.s8.io.xml.annotations.XML_Type;
import com.s8.stack.servers.carbon.assets.WebAsset;
import com.s8.stack.servers.carbon.assets.basics.JSON_WebAsset;
import com.s8.stack.servers.carbon.build.CarbonBuildContext;


@XML_Type(name="json-filter")	
public class JSON_Filter extends BasicWebAssetFilter {


	@Override
	public WebAsset createAsset(CarbonBuildContext ctx) {
		return new JSON_WebAsset(ctx.getContainer(), ctx.getWebPathname(), ctx.getLocalPath(), 
				cacheControl, fragmentLength);
	}

	@Override
	public String[] expose(String webPathname) {
		return new String[]{ webPathname };
	}	
	
}