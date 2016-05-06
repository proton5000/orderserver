package com.orderserver.shops;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by proton on 18.02.2016.
 */
@Service
public class AliexpressServiceImpl implements AliexpressService {


    Map imgNameOrder = new HashMap<String, String>();

    @Override
    public Map imgUrl(String linkOrder) throws IOException {

        Document doc = Jsoup.connect(linkOrder)
                .followRedirects(true)
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .header("Accept-Language", "en,ru")
                .header("Accept-Encoding", "gzip,deflate,sdch")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36")
                .maxBodySize(0)
                .timeout(10000)
                .get();

        Elements metaElements = doc.getAllElements();
        String name;

        if (linkOrder.contains("group.aliexpress")) {
            name = metaElements.select(".product-name").text();
        } else {
            name = doc.title();
        }

        String result = metaElements.toString();
        System.out.println(result);
        //String result = page.asXml();

        Pattern MY_PATTERN = Pattern.compile("(<meta property=\"og:image\" content=\"|<img img-src=\"|<img id=\"big-img\" src=\")(http:(.*?\\.jpg))");
        String s = "";

        Matcher m = MY_PATTERN.matcher(result);

        if (m.find()) {
            s = m.group(2);
            //System.out.println(s);
        }

        imgNameOrder.put("name", name);
        imgNameOrder.put("imgUrl", s);

        return imgNameOrder;
    }
}

//        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setRedirectEnabled(true);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
//        webClient.getOptions().setCssEnabled(true);
//        webClient.getOptions().setPopupBlockerEnabled(true);
//        webClient.waitForBackgroundJavaScriptStartingBefore(10000);
//        webClient.waitForBackgroundJavaScript(10000);
//        webClient.getOptions().setTimeout(10000);
//        HtmlPage page = webClient.getPage(linkOrder);

//        System.out.printf(page.toString());

//        String name = page.getTitleText();