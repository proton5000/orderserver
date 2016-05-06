package com.orderserver.shops;

import java.io.IOException;
import java.util.Map;

/**
 * Created by proton on 18.02.2016.
 */
public interface AliexpressService {

    Map imgUrl (String linkOrder) throws IOException;

}
