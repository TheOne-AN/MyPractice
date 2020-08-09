package index;

import common.DocInfo;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 索引类需包含两方面内容 正排索引 倒排索引
public class Index {
    // word这个词在 docId 文档中的权重
    static public class Weight{
        public String word;
        public int docId;
        // weight 生成公式 ： 10*标题中出现的次数 + 正文中出现的次数
        public int weight;
    }
    private ArrayList<DocInfo> forwardIndex = new ArrayList<>();
    // 倒排索引  词 -> 一组 docId
    private HashMap<String,ArrayList<Weight>> invertedIndex = new HashMap<>();

    // Index 类需要提供的方法
    // 查正排
    public DocInfo getDocInfo(int docId) {
        return forwardIndex.get(docId);
    }
    // 查倒排
    public ArrayList<Weight> getInverted(String term) {
        return invertedIndex.get(term);
    }
    // 构建索引
    public void build(String inputPath) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("build start! ");

        // 1.打开文件，按行读取文件内容
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File(inputPath)));
        // 2.读取到每一行
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            // 3.构造正排过程 ： 按照 \3 来划分，结果构造成一个DocInfo对象，加入到正排索引
            DocInfo docInfo = buildForward(line);
            // 4.构造倒排索引
            byildInverted(docInfo);
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("buile finish! time :" +(finishTime - startTime) + "ms"  );
    }

    private void byildInverted(DocInfo docInfo) {
        //
        class WordCnt{
            public int titleCount;
            public int contentCount;

            public WordCnt(int titleCount, int contentCount) {
                this.titleCount = titleCount;
                this.contentCount = contentCount;
            }
        }
        HashMap<String,WordCnt> wordCntHashMap = new HashMap<>();
        // 针对 title 和 content 进行分词，
        // 1.针对标题分词
        List<Term> titleTerms = ToAnalysis.parse(docInfo.getTitle()).getTerms();
        // 2.遍历分词结果，统计每个词的出现次数
        for (Term term : titleTerms) {
            // 此处 word 已经被转成小写了
            String word = term.getName();
            WordCnt wordCnt = wordCntHashMap.get(word);
            if (wordCnt == null) {
                //当前次哈希表中不存在
                wordCntHashMap.put(word,new WordCnt(1,0));
            }else {
                wordCnt.titleCount++;
            }
        }
        // 3.针对正文分词
        List<Term> contentTerms = ToAnalysis.parse(docInfo.getContent()).getTerms();
        // 4.遍历分词结果，统计正文中每个词出现的次数
        for (Term term : contentTerms) {
            String word = term.getName();
            WordCnt wordCnt = wordCntHashMap.get(word);
            if (wordCnt == null) {
                wordCntHashMap.put(word,new WordCnt(0,1));
            }else {
                wordCnt.contentCount++;
            }
        }
        // 5.遍历 HashMap,构建 Weight 对象 并更新到倒排索引
        for (HashMap.Entry<String,WordCnt> entry : wordCntHashMap.entrySet()) {
            Weight weight = new Weight();
            weight.word = entry.getKey();
            weight.docId = docInfo.getDocId();
            // weight = 标题中出现次数 * 10 + 正文中出现次数
            weight.weight = entry.getValue().titleCount*10
                    + entry.getValue().contentCount;
            // weight 加入到倒排索引中. 倒排索引是一个 HashMap,
            // value 就是 Weight 构成的 ArrayList
            // 先根据这个词, 找到 HashMap 中对应的这个 ArrayList, 称为 "倒排拉链"
            ArrayList<Weight> invertedList = invertedIndex.get(entry.getKey());
            if (invertedList == null) {
                // 当前这个键值对不存在, 就新加入一个键值对就可以了
                invertedList = new ArrayList<>();
                invertedIndex.put(entry.getKey(), invertedList);
            }
            // invertedIndex 已经是一个合法的 ArrayList 了, 就可以把 weight 直接加入即可
            invertedList.add(weight);
        }
    }

    private DocInfo buildForward(String line) {
        // 把这一行按照 \3 进行划分
        // 分出来的三个部分 就是一个文档的 标题  URL  正文
        String[] tokens = line.split("\3");
        if (tokens.length != 3) {
            // 发现文件格式有问题,  不能让该问题影响到索引的构建， 所以只打印日志
            System.out.println("文件格式有问题： " + line);
            return null;
        }
        // 把新的 docInfo 插入到数组末尾
        // 数组长度是0，就插入到0号位置
        DocInfo docInfo = new DocInfo();
        // id 就是正排索引数组下标
        docInfo.setDocId(forwardIndex.size());
        docInfo.setTitle(tokens[0]);
        docInfo.setUrl(tokens[1]);
        docInfo.setContent(tokens[2]);
        forwardIndex.add(docInfo);
        return docInfo;
    }
}









