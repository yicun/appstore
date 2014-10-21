package me.chyc.appstore;

import me.chyc.http.WebPageGetter;
import me.chyc.utils.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by yicun.chen on 10/18/14.
 */
public class AppRankLoader {
    public static void main(String args[]) throws Exception {
        String url = "http://www.apple.com/cn/itunes/charts/paid-apps/";
        String html = WebPageGetter.getWebPage(url,"utf-8");
        Document document = Jsoup.parse(html);
        Element section = document.getElementsByTag("section").first();
        Elements elements = section.getElementsByTag("li");
        for (Element element: elements){
            int strong = StringUtils.toInt(element.getElementsByTag("strong").first().text());
            String href = element.select("a[href]").first().attr("href");
            String img = element.select("img").first().attr("src");
            String alt = element.select("h3").first().select("a[href]").first().text();
            String cat = element.select("h4").first().select("a[href]").first().text();

            System.out.println(strong);
            System.out.println(href);
            System.out.println(img);
            System.out.println(alt);
            System.out.println(cat);
        }

    }
}
