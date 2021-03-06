/*
 * Created on Apr 12, 2007 by Zach Bailey
 * 
 * Please feel free to distribute this code in any way, with or without this notice.
 */
package com.cms.webservices;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hannonhill.www.ws.ns.AssetOperationService.AssetOperationHandler;
import com.hannonhill.www.ws.ns.AssetOperationService.AssetOperationHandlerServiceLocator;
import com.hannonhill.www.ws.ns.AssetOperationService.Authentication;
import com.hannonhill.www.ws.ns.AssetOperationService.EntityTypeString;
import com.hannonhill.www.ws.ns.AssetOperationService.Identifier;
import com.hannonhill.www.ws.ns.AssetOperationService.Path;
import com.hannonhill.www.ws.ns.AssetOperationService.Read;
import com.hannonhill.www.ws.ns.AssetOperationService.ReadResult;

/**
 * Tests the webservices framework by doing a read of the ROOT folder.
 * 
 * @author Zach Bailey
 * @since 0.1
 */
public class TestRead
{
    /**
     * Tests reading of the Base Folder in a given Site
     * 
     * From inside Eclipse, run this test using:
     * 
     * - alt+shift+x, t (Windows)
     * - option+command+x, t (Mac)
     * 
     * @throws Exception
     */
    @Test
    public void testBaseFolderRead() throws Exception
    {
        Identifier toRead = new Identifier();
        Path path = new Path();
        path.setPath("/");
        path.setSiteName("bradley");
        toRead.setPath(path);
        toRead.setType(EntityTypeString.folder);

        Read read = new Read();
        read.setIdentifier(toRead);

        Authentication authentication = new Authentication();
        authentication.setUsername("bradley.wagner");
        authentication.setPassword("soosad");

        AssetOperationHandlerServiceLocator serviceLocator = new AssetOperationHandlerServiceLocator();
        AssetOperationHandler handler = serviceLocator.getAssetOperationService();
        ReadResult result = handler.read(authentication, toRead);

        assertTrue(result.getSuccess().equals("true") ? true : false);
    }
}
