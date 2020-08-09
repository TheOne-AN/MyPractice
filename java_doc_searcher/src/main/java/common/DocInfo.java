
// common 包表示每个模块可能会会用到的公共信息
package common;

//表示一个文档对象（HTML文档）
public class DocInfo {
    // docId 文档的唯一身份标识（不能重复）
    private int docId;
    // 该文档的标题，简单粗暴的使用文件名
    private String title;
    // 该文档对应的先生文档的 url
    // 根据本地文件路径可以构造出线上文档的 url
    private String url;
    // 该文档的正文，把 html 标签去掉留下的内容
    private String content;

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
