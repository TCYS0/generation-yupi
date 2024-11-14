package org.fuhao.utils;

import java.io.*;
import java.util.Objects;

public class FileUtil {

    /**
     * @description 复制文件单个
     * @author fuhao
     * @Date 20:35 2024/11/14
     * Modification History:
     * Date         Author          Version            Description
     *------------------------------------------------------------
     * 2024/11/14     fuhao          v1.1.0               修改原因
     *
     **/
    public static void copy(File src, File dest) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(src);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            assert input != null;
            input.close();
            assert output != null;
            output.close();
        }
    }


    /**
     * @description 复制文件递归
     * @author fuhao
     * @Date 20:35 2024/11/14
     * Modification History:
     * Date         Author          Version            Description
     *------------------------------------------------------------
     * 2024/11/14     fuhao          v1.1.0               修改原因
     *
     **/
    public static void copy(String src, String dest) throws IOException {
        File srcFile = new File(src);
        File destFile = new File(dest, srcFile.getName());
        if (!srcFile.exists()) {
            throw new FileNotFoundException(src);
        }
        if (srcFile.isDirectory()) {
            destFile.mkdirs();
            File[] files = srcFile.listFiles();
            for (File file : Objects.requireNonNull(files)) {
                if (file.isDirectory()) {
                    copy(file.toString(), destFile.toString());
                }else {
                    copy(file, new File(destFile.toString(), file.getName()));
                }
            }
        }else {
            copy(srcFile, destFile);
        }
    }
}
