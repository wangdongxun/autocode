package com.martin;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CodeUtil
{
    private Configuration cfg;
    private String outDir = "";
    private String basePkg = "";
    private String author = "";
    private String table = "";
    private String model = "";
    private String bizName = "";
    private String bizUnit = "";
    private String curTime = "";

    private String basePath="";
    Map<String, Object> map = null;
    Map root = new HashMap();
    Map xmlMap = null;

    public CodeUtil()
            throws Exception
    {
        XmlRead xmlRead = new XmlRead();
        this.xmlMap = xmlRead.getXml();
        this.outDir = this.xmlMap.get("outDir").toString();
        this.basePkg = this.xmlMap.get("basePkg").toString();
        this.author = this.xmlMap.get("author").toString();
        this.table = this.xmlMap.get("table").toString();
        this.model = this.xmlMap.get("model").toString();
        this.bizName = this.xmlMap.get("bizName").toString();
        this.bizUnit = this.xmlMap.get("bizUnit").toString();

        this.basePath=this.basePkg.replace(".","/")+"/";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.curTime = df.format(new Date());

        this.root.put("curTime", this.curTime);
        this.root.put("author", this.author);
        this.root.put("bizName", this.bizName);
        this.root.put("basePkg", this.basePkg);
        this.root.put("bizUnit", this.bizUnit);
        this.root.put("model", this.model);
        this.root.put("bizName", this.bizName);


        this.cfg = new Configuration();

        this.cfg.setClassForTemplateLoading(getClass(), "/template");
        this.map = TableUtil.transferTable(this.table);
        this.root.put("keyList", this.map.get("keyList"));
        this.root.put("columnList", this.map.get("columnList"));
    }

    public void createController()
            throws Exception
    {
        Template template = this.cfg.getTemplate("createController.ftl");
        String fileName = this.model + "Controller.java";
        String savePath = "/src/main/java/"+this.basePath +this.bizUnit + "/controller/";
        createFile(this.root, this.outDir, savePath, fileName, template);
    }

    public void createBean() throws Exception
    {
        Template template = this.cfg.getTemplate("createBean.ftl");
        String fileName = this.model + "Bean.java";
        String savePath = "/src/main/java/"+this.basePath +this.bizUnit + "/bean/";
        createFile(this.root, this.outDir, savePath, fileName, template);
    }

    public void createInfo()
            throws Exception
    {
        Template template = this.cfg.getTemplate("createInfo.ftl");
        String fileName = this.model + "Dto.java";
        String savePath = "/src/main/java/"+this.basePath +this.bizUnit + "/dto/";
        createFile(this.root, this.outDir, savePath, fileName, template);
    }
//
//    public void createSV()
//            throws Exception
//    {
//        Template template = this.cfg.getTemplate("createSV.ftl");
//        String fileName = this.modelName + ".java";
//        String savePath = "/jusfoun-idl/src/main/java/com/shujia/jusfoun/idl/" + this.center + "/service/";
//        createFile(this.root, this.project_path, savePath, fileName, template);
//    }
//
//    public void createSVImpl()
//            throws Exception
//    {
//        Template template = this.cfg.getTemplate("createSVImpl.ftl");
//        String fileName = this.modelName + "Impl.java";
//        String savePath = "/jusfoun-bll/src/main/java/com/shujia/jusfoun/bll/" + this.center + "/";
//        createFile(this.root, this.project_path, savePath, fileName, template);
//    }
//
//    public void createMapper()
//            throws Exception
//    {
//        Template template = this.cfg.getTemplate("createMapper.ftl");
//        String fileName = this.modelName + "Mapper.java";
//        String savePath = "/jusfoun-idl/src/main/java/com/shujia/jusfoun/idl/" + this.center + "/dao/";
//        createFile(this.root, this.project_path, savePath, fileName, template);
//    }
//
//    public void createMapperXml()
//            throws Exception
//    {
//        Template template = this.cfg.getTemplate("createMapperXml.ftl");
//        String fileName = this.modelName + "Mapper.xml";
//        String savePath = "/jusfoun-dal/src/main/resources/mappings/";
//        createFile(this.root, this.project_path, savePath, fileName, template);
//    }
//
//    public void createUrl()
//            throws Exception
//    {
//        Template template = this.cfg.getTemplate("createUrl.ftl");
//        StringWriter tmpOut = new StringWriter();
//        template.process(this.root, tmpOut);
//
//        URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
//        String filePath = null;
//        try
//        {
//            filePath = URLDecoder.decode(url.getPath(), "utf-8");
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        if (filePath.endsWith(".jar")) {
//            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
//        }
//        File file = new File(filePath);
//        filePath = file.getAbsolutePath();
//
//        BufferedWriter out = new BufferedWriter(new FileWriter(filePath + "/URL.txt", false));
//        out.write(tmpOut.toString());
//        out.close();
//        tmpOut.close();
//    }
//
//    public void updateACLConsumerXml()
//            throws Exception
//    {
//        Template template = this.cfg.getTemplate("createACLConsumer.ftl");
//        StringWriter tmpOut = new StringWriter();
//        template.process(this.root, tmpOut);
//        tmpOut.close();
//
//        String filePath = this.xmlMap.get("aclConsumer").toString().replace("%", this.xmlMap.get("center").toString());
//        BufferedWriter out = new BufferedWriter(new FileWriter(this.project_path + "/" + filePath, true));
//        out.write(tmpOut.toString());
//        out.close();
//    }
//
//    public void updateBLLProviderXml()
//            throws Exception
//    {
//        Template template = this.cfg.getTemplate("createBLLProvider.ftl");
//        StringWriter tmpOut = new StringWriter();
//        template.process(this.root, tmpOut);
//        tmpOut.close();
//
//        String filePath = this.xmlMap.get("bllProvider").toString().replace("%", this.xmlMap.get("center").toString());
//        BufferedWriter out = new BufferedWriter(new FileWriter(this.project_path + "/" + filePath, true));
//        out.write(tmpOut.toString());
//        out.close();
//    }
//
//    public void updateBLLConsumerXml()
//            throws Exception
//    {
//        Template template = this.cfg.getTemplate("createBLLConsumer.ftl");
//        StringWriter tmpOut = new StringWriter();
//        template.process(this.root, tmpOut);
//        tmpOut.close();
//
//        String filePath = this.xmlMap.get("bllConsumer").toString().replace("%", this.xmlMap.get("center").toString());
//        BufferedWriter out = new BufferedWriter(new FileWriter(this.project_path + "/" + filePath, true));
//        out.write(tmpOut.toString());
//        out.close();
//    }
//
//    public void updateDALProviderXml()
//            throws Exception
//    {
//        Template template = this.cfg.getTemplate("createDALProvider.ftl");
//        StringWriter tmpOut = new StringWriter();
//        template.process(this.root, tmpOut);
//        tmpOut.close();
//
//        String filePath = this.xmlMap.get("dalProvider").toString().replace("%", this.xmlMap.get("center").toString());
//        BufferedWriter out = new BufferedWriter(new FileWriter(this.project_path + "/" + filePath, true));
//        out.write(tmpOut.toString());
//        out.close();
//    }

    private void createFile(Map root, String projectPath, String savePath, String fileName, Template template)
            throws Exception
    {
        String realFileName = projectPath + savePath + fileName;
        String realSavePath = projectPath + "/" + savePath;

        File newsDir = new File(realSavePath);
        if (!newsDir.exists()) {
            newsDir.mkdirs();
        }
        System.out.println(realFileName);

        Writer out = new OutputStreamWriter(new FileOutputStream(realFileName), "UTF-8");
        template.process(root, out);
    }

    private String checkPath(String s)
            throws Exception
    {
        if (!s.endsWith("/")) {
            s = s + "/";
        }
        return s.replaceAll("\\\\", "/");
    }
}
