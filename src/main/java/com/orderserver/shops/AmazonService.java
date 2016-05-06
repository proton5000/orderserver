package com.orderserver.shops;

import java.io.IOException;
import java.util.Map;

/**
 * Created by proton on 04.03.2016.
 */
public interface AmazonService {

    Map imgUrl (String linkOrder) throws IOException;
}
