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
 * Created by proton on 02.03.2016.
 */
@Service
public class EbayServiceImpl implements EbayService {

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

        String name = doc.title();

        String result = metaElements.toString();

        Pattern MY_PATTERN = Pattern.compile("(itemprop=\"image\" src=\")(http:(.*?\\.jpg))");
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
