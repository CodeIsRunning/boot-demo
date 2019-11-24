package com.example.cleanerhtml;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.seimicrawler.xpath.JXDocument;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CleanerhtmlApplicationTests {

    @Test
    void contextLoads() throws Exception {


        Document doc = Jsoup.connect("https://www.iqiyi.com").get();


        JXDocument jxDocument = JXDocument.create(doc);

        List<Object> list = jxDocument.sel("//*[@id=\"block-B\"]/div[2]/div/ul");

        Element element = (Element) list.get(0);

        for (Element e : element.children()
                ) {
            System.out.println(e.child(0).attributes().get("href"));
            System.out.println(e.child(0).text());
        }
    }

    public List<Movie> test() throws Exception {

        List<Movie> list = new ArrayList<>();


        String baseUrl = "http://www.haojilu1.com";

        Document doc = Jsoup.connect("http://www.haojilu1.com/pd/1-1.html").get();

        Elements elements = doc.select("div.k_list-lb");

        for (Element element :elements
                ) {
            Movie movie = new Movie();

            String secondUrl = baseUrl + element.children().get(0).children().get(0).children().get(0).children().get(0).attributes().get("href");


            doc = Jsoup.connect(secondUrl).get();

            JXDocument jxDocument11 = JXDocument.create(doc);

            List<Object> list1 = jxDocument11.sel("//*[@id=\"k_jianjie-2b\"]/a/img");

            Element eee = (Element) list1.get(0);

            movie.setPicUrl(eee.attributes().get("src"));

            Elements elements1 = doc.select("div.k_jianjie-3a-5");




            for (Element e : elements1
                    ) {
                Elements es = e.children();

                if (org.springframework.util.CollectionUtils.isEmpty(es)){
                    continue;
                }

                es = es.get(0).children();

                for (Element es1 : es
                        ) {

                    for (Element element1 :es1.children()){


                    String s = element1.attributes().get("href");
                    if (StringUtils.isNotEmpty(s) && s.contains("html")) {
                        String thridUrl = baseUrl+s;
                        doc = Jsoup.connect(thridUrl).get();

                        String result = StringUtils.substringBetween(doc.toString(), "https", "$");
                        if (StringUtils.isNotEmpty(result) && result.contains("m3u8")) {
                            movie.setTargetUrl(result);
                            list.add(movie);
                            System.out.println(result);
                            break;
                        }
                    }
                }}

            }

        }

return list;

    }

    @Test
    public void s()throws Exception{
        test();
    }

    public static Document getDocument(String url) throws IOException, InterruptedException {
        WebClient wc = new WebClient(BrowserVersion.CHROME);
        //是否使用不安全的SSL
        wc.getOptions().setUseInsecureSSL(true);
        //启用JS解释器，默认为true
        wc.getOptions().setJavaScriptEnabled(true);
        //禁用CSS
        wc.getOptions().setCssEnabled(false);
        //js运行错误时，是否抛出异常
        wc.getOptions().setThrowExceptionOnScriptError(false);
        //状态码错误时，是否抛出异常
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        //是否允许使用ActiveX
        wc.getOptions().setActiveXNative(false);
        //等待js时间
        wc.waitForBackgroundJavaScript(600 * 1000);
        //设置Ajax异步处理控制器即启用Ajax支持
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
        //设置超时时间
        wc.getOptions().setTimeout(1000000);
        //不跟踪抓取
        wc.getOptions().setDoNotTrackEnabled(false);
        WebRequest request = new WebRequest(new URL(url));
        request.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:62.0) Gecko/20100101 Firefox/62.0");
        request.setAdditionalHeader("Cookie", "PLAY_LANG=cn; _plh=b9289d0a863a8fc9c79fb938f15372f7731d13fb; PLATFORM_SESSION=39034d07000717c664134556ad39869771aabc04-_ldi=520275&_lsh=8cf91cdbcbbb255adff5cba6061f561b642f5157&csrfToken=209f20c8473bc0518413c226f898ff79cd69c3ff-1539926671235-b853a6a63c77dd8fcc364a58&_lpt=%2Fcn%2Fvehicle_sales%2Fsearch&_lsi=1646321; _ga=GA1.2.2146952143.1539926675; _gid=GA1.2.1032787565.1539926675; _plh_notime=8cf91cdbcbbb255adff5cba6061f561b642f5157");
        try {
            //模拟浏览器打开一个目标网址
            HtmlPage htmlPage = wc.getPage(request);
            //为了获取js执行的数据 线程开始沉睡等待
            //Thread.sleep(1000);//这个线程的等待 因为js加载需要时间的
            //以xml形式获取响应文本
            String xml = htmlPage.asXml();
            //并转为Document对象return
            return Jsoup.parse(xml);
            //System.out.println(xml.contains("结果.xls"));//false
        } catch (FailingHttpStatusCodeException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
