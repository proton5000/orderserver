package com.orderserver.shops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by proton on 01.03.2016.
 */
@Service
public class ShopRouterServiceImpl implements ShopRouterService {

    Map result = new HashMap<String, String>();

    @Autowired
    AliexpressService aliexpressService;

    @Autowired
    EbayService ebayService;

    @Autowired
    AmazonService amazonService;

    @Override
    public Map imgAndNameOrder(String linkOrder) throws IOException {

        if (linkOrder.toLowerCase().contains("aliexpress")) {

            result  = aliexpressService.imgUrl(linkOrder);

        } else if (linkOrder.toLowerCase().contains("ebay")) {

            result  = ebayService.imgUrl(linkOrder);

        } else if (linkOrder.toLowerCase().contains("amazon")) {

            result  = amazonService.imgUrl(linkOrder);

        } else {
            result.put("name", "no compatible site");
            result.put("imgUrl", linkOrder);
        }

        return result;
    }
}
