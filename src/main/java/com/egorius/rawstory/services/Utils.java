package com.egorius.rawstory.services;

import com.egorius.rawstory.bot.ServerBot;

class Utils {

    static String[] transformImg(String[] ids) {
        String[] img = new String[ids.length];

        int i = 0;
        for (String id : ids) {
            String path = ServerBot.serverBot.downloadImg(id);
            if (path.length() != 0) {
                img[i] = path;
                i++;
            }
        }
        return img;
    }
}
