package com.orderserver.shops;

import java.io.IOException;
import java.util.Map;

/**
 * Created by proton on 01.03.2016.
 */
public interface ShopRouterService {

    Map imgAndNameOrder(String linkOrder) throws IOException;
}
