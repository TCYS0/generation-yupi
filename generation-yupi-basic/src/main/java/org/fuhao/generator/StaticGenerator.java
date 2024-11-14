package org.fuhao.generator;

import org.fuhao.utils.FileUtil;

import java.io.IOException;

public class StaticGenerator {
    public static void main(String[] args) throws IOException {
        String src = "E:\\windows\\Desktop\\project\\generation-yupi\\generation-yupi-projects\\acm-template\\src\\com\\yupi\\acm";
        String dest = "E:\\windows\\Desktop\\project\\generation-yupi\\generation-yupi-basic\\src\\main\\java\\org\\fuhao\\out";
        FileUtil.copy(src,dest);
    }
}
