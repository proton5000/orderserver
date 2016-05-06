package com.orderserver.shops;

import java.io.IOException;
import java.util.Map;

/**
 * Created by proton on 02.03.2016.
 */
public interface EbayService {
    Map imgUrl (String linkOrder) throws IOException;
}
