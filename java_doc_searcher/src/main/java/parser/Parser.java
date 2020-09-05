package parser;
// 预处理模块
/*
遍历文档目录 读取所有 html 文档内容，把结果解析为行文本文件
每一行文档，每一行中都包含 文档标题 文档URL 文档正文(去掉 html 标签)
*/
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//是一个单独可执行的类
public class Parser {
    public static final String INPUT_PATH = "D:\\API\\docs 8\\api";
    public static final String OUTPUT_PATH = "D:\\raw_data.txt";
    //完成整个预处理的过程
    public static void main(String[] args) throws IOException {
        FileWriter resultFileWriter = new FileWriter(new File(OUTPUT_PATH));
        ArrayList<File> fileList = new ArrayList<>();
        enumFile(INPUT_PATH,fileList);
        // 2. 针对枚举的文件进行遍历
        // 把文件转换成需要的结构化数据
        for (File f : fileList) {
            // 最终输出的 raw.text 文件 每行对应一个 html 文件
            String line = covertLine(f);
            resultFileWriter.write(line);
        }
        resultFileWriter.close();
        return;
    }
    // 此处 raw_data 文件用行文本表示只是一种表示方式
    // 也可以用 json xml 或者其他任何方式
    private static String covertLine(File f) throws IOException {
        // 1.根据 f 转换出标题
        String title = convertTitle(f);
        // 2.根据 f 转换出 url
        String url = convertUrl(f);
        // 3.根据 f 转换成正文
        String content = covertContent(f);
        // 4. 把上面3部分拼成一行文本
        //  \3起到分割三个部分的效果
        //  "\3"  表示 End of Text 表示文本结束
        //  在一个 html 文本文件中不会存在 "\3" 这种不可见字符
        // 使用其他的不可见字符也可以 "\1" "\2" "\5" 效果一样
        return title + "\3" + url + "\3" + content + "\n";
    }

    private static String covertContent(File f) throws IOException {
        // 把 html 中的标签去掉
        // 把 \n 去掉
        FileReader fileReader = new FileReader(f);
        boolean isContent = true;
        StringBuilder output = new StringBuilder();
        while (true) {
            int ret = fileReader.read();
            if (ret == -1) {
                // 读完了
                break;
            }
            char c = (char)ret;
            if (isContent){
                //当前部分是正文
                if(c == '<') {
                    isContent = false;
                    continue;
                }
                if ( c == '\n' || c == '\r') {
                    c = ' ';
                }
                output.append(c);
            }else {
                // 当前部分内容是标签
                //不去写 output
                if (c == '>') {
                    isContent = true;
                }
            }

        }
        fileReader.close();
        return output.toString();
    }

    private static String convertUrl(File f) {
        //  part1 对应线上文档的 url
        String part1 = "https://docs.oracle.com/javase/8/docs/api";
        String part2 = f.getAbsolutePath().substring(INPUT_PATH.length());
        return  part1 + part2;
    }

    private static String convertTitle(File f) {
        // 把文件名作为标题就可以， 不是全路径 去点 .html 后缀
        // 文件名 ：xxx.html
        // 全路径： D://XXX/XXX/XXX.HTML
        String name = f.getName();
        return  name.substring(0,name.length() - ".html".length() );
    }

    // 当前方法执行完成后，
    // 就把 INPUT_PATH 目录下所有子目录的 html 加入 fileList 中
    private static void enumFile(String inputPath, ArrayList<File> fileList) {
        //把 inputPath 对应的文件递归的遍历一遍
        File root = new File(inputPath);
        // listFiles 相当于 Linux上的 ls 命令
        File[] files = root.listFiles();
        //遍历当前的目录和文件,分别处理
        for (File f : files ) {
            if (f.isDirectory()) {
                //  f 是目录，递归调用 enumFile
                enumFile(f.getAbsolutePath(),fileList);
            } else if (f.getAbsolutePath().endsWith(".html")) {
                // f 不是一个目录，看文件后缀是不是.html
                // 是 .html  就把这个文件的对象加入到fileList 中
                fileList.add(f);
            }
        }
    }
}
