package com.orderserver.services;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by proton on 23.02.2016.
 */
@Service
public class CleanLinkImpl implements CleanLink {

    @Override
    public String cleanLink(String link) {

        Pattern cleanLinkPattern = Pattern.compile("(\\S+html)");

        Matcher cleanLinkMatcher = cleanLinkPattern.matcher(link);

        String s = "";
        if (cleanLinkMatcher.find()) {
            s = cleanLinkMatcher.group(0);
        }

        return s;
    }
}
