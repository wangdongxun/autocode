package com.martin;

public class StartCode
{
    public static void main(String[] args)
            throws Exception
    {
        CodeUtil util = new CodeUtil();
        util.createController();
        util.createBean();
        util.createInfo();
//        util.createSV();
//        util.createSVImpl();
//        util.createUrl();
//        util.createMapper();
//

//        String s = args[0];
//        CodeUtil util = new CodeUtil();
//        if (s.equalsIgnoreCase("0"))
//        {
//            util.createController();
//            util.createBean();
//            util.createInfo();
//            util.createSV();
//            util.createSVImpl();
//            util.createUrl();
//            util.createMapper();
//            util.createMapperXml();
//            util.updateACLConsumerXml();
//            util.updateBLLProviderXml();
//            util.updateBLLConsumerXml();
//            util.updateDALProviderXml();
//        }
//        else if (s.equalsIgnoreCase("1"))
//        {
//            util.createController();
//            util.createBean();
//            util.createInfo();
//            util.createSV();
//            util.createSVImpl();
//            util.createUrl();
//        }
//        else if (s.equalsIgnoreCase("2"))
//        {
//            util.createMapper();
//            util.createMapperXml();
//        }
//        else if (s.equalsIgnoreCase("3"))
//        {
//            util.updateACLConsumerXml();
//            util.updateBLLProviderXml();
//            util.updateBLLConsumerXml();
//            util.updateDALProviderXml();
//        }
    }
}
