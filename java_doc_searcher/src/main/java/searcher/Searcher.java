package searcher;

import common.DocInfo;
import index.Index;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class WeightComparator implements Comparator<Index.Weight>{

    @Override
    public int compare(Index.Weight o1, Index.Weight o2) {
        // 如果 o1<o2 返回 一个 <0 的数字
        // 如果 o1>o2 返回一个 >0 的数字
        // == 返回 0
        return o2.weight - o1.weight;
    }
}

// 完成搜索的核心
public class Searcher {
    private Index index = new Index();
    public Searcher() throws IOException {
        index.build("d:/raw_data.txt");
    }
    public List<Result> search(String query) {
        // 1.分词  针对查询词进行分词
        List<Term> terms = ToAnalysis.parse(query).getTerms();
        // 2.触发 针对查询词的分词结果一次查找倒排索引，得到一大堆相关 docId
        // 这个 ArrayList 中保存每个分词结果，得到的倒排拉链的整体结果
        ArrayList<Index.Weight> allTokenResult = new ArrayList<>();
        for (Term term : terms) {
            // 此处 word 全是小写
            String word = term.getName();
            List<Index.Weight> invertedList= index.getInverted(word);
            if (invertedList == null) {
                // 用户输入的这个词很生僻 所有文档都不存在
                continue;
            }
            allTokenResult.addAll(invertedList);
        }
        // 3.排序 按照权重进行排序
        // 匿名内部类
        allTokenResult.sort(new WeightComparator());
        // 4.包装结果
        ArrayList<Result> results = new ArrayList<>();
        for (Index.Weight weight : allTokenResult) {
            // 根据 weight 中包含的 docId 找到对应的 DocInfo 对象
            DocInfo docInfo = index.getDocInfo(weight.docId);
            Result result = new Result();
            result.setTitle(docInfo.getTitle());
            result.setClickUrl(docInfo.getUrl());
            result.setShowUrl(docInfo.getUrl());
            //  GenDesc 从正文中摘取摘要信息，
            // 根据这个词，找到这个词在正文中的位置
            // 在把这个词周围的文本获取到，得到一个片段
            result.setDesc(GenDesc(docInfo.getContent(),weight.word));
            results.add(result);
        }
        return results;
    }

    private String GenDesc(String content, String word) {
        // 查找 word 在 content中出现的位置
        int firstPos = content.toLowerCase().indexOf(word);
        if (firstPos == -1) {
            // 极端情况， 该词旨在标题中出现，正文没有
            return "";
        }
        // 从 firstPos 开始往前找60个（若干个）字符，如果前面不足60 个就从正文头部开始
        int descBeg = firstPos < 60 ? 0 :firstPos - 60;
        // 从 firstPos 开始往后找160个（若干个）字符，如果后面不足160个字符，就一直到结尾
        if (descBeg + 160 >content.length()) {
            return content.substring(descBeg);
        }
        return  content.substring(descBeg) + "...";
    }
}
