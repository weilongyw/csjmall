package com.csj.framework.utils;

import io.github.yedaxia.apidocs.Docs;

/**
 * 生成文档的工具
 *
 * @author baojialong
 * @Title: GenerateApiDOC
 * @Description:
 * @date 2018/11/14 10:07
 */

public class GenerateApiDOC {


    private static final String porjectName = "mall";

    public static void main(String[] args) {
        Docs.DocsConfig docsConfig = new Docs.DocsConfig();
        String property = System.getProperty("user.dir") + "mall-web-admin\\";
        String[] dirArray = property.split(porjectName);
        String projectPath = dirArray[0] + porjectName;
        docsConfig.setProjectPath(projectPath);
        docsConfig.setDocsPath(projectPath + "\\apidocs");
        Docs.buildHtmlDocs(docsConfig);
    }

}
