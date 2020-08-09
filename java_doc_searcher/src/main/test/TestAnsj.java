import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

public class TestAnsj {
    public static void main(String[] args) {
        String str= "小明毕业于西安工业大学";
        List<Term> termList = ToAnalysis.parse(str).getTerms();
        System.out.println("开始");
        for (Term t : termList) {
            System.out.println(t.getName());
        }
        return;
    }
}
