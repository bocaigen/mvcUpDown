package com.my.portExcel;

import com.my.entity.InfoV;
import com.my.importExcel.ImportExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zhangxibo on 2018/1/21.
 */
@Controller
@RequestMapping("/excel")
public class PortExcelController {

    @RequestMapping("/excel.do")
    public String toExcel(HttpServletRequest request){

        return "excel";
    }

    @RequestMapping("/uploadExcel.do")
    public String uploadExcel(HttpServletRequest request) throws Exception{
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println("通过传统方式form表单提交 导入excel文件！");

        InputStream in = null;
        List<List<Object>> listob = null;
        MultipartFile upfile = multipartRequest.getFile("upfile");
        if(upfile.isEmpty()){
            throw new Exception("文件不存在！");
        }
        in = upfile.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in, upfile.getOriginalFilename());
        in.close();

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for(int i = 0; i < listob.size(); i++){
            List<Object> lo = listob.get(i);
            InfoV v = new InfoV();
            v.setCode(String.valueOf(lo.get(0)));
            v.setName(String.valueOf(lo.get(1)));
            v.setDate(String.valueOf(lo.get(2)));
            v.setMoney(String.valueOf(lo.get(3)));

            System.out.println(("打印信息-->机构:"+v.getCode()+"  名称："+v.getName()+"  名称："+v.getDate()+"  资产："+v.getMoney()));
        }
        return "success";
    }

    @RequestMapping("/ajaxUploadExcel.do")
    @ResponseBody
    public void ajaxUploadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println("通过 jquery.form.js 提供的ajax方式上传文件！");

        InputStream in = null;
        List<List<Object>> listob = null;
        MultipartFile upfile = multipartRequest.getFile("upfile");
        if(upfile.isEmpty()){
            throw new Exception("文件不存在！");
        }
        in = upfile.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in, upfile.getOriginalFilename());
        in.close();

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for(int i = 0; i < listob.size(); i++){
            List<Object> lo = listob.get(i);
            InfoV v = new InfoV();
            v.setCode(String.valueOf(lo.get(0)));
            v.setName(String.valueOf(lo.get(1)));
            v.setDate(String.valueOf(lo.get(2)));
            v.setMoney(String.valueOf(lo.get(3)));

            System.out.println(("打印-->机构:"+v.getCode()+"  名称："+v.getName()+"  名称："+v.getDate()+"  资产："+v.getMoney()));
        }

        PrintWriter out = null;
        response.setCharacterEncoding("utf-8");
        out = response.getWriter();
        out.print("文件导入成功！！！");
        out.flush();
        out.close();
    }


}
