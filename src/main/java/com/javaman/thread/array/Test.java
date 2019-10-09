package com.javaman.thread.array;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import lombok.Data;

/**
 * @author pengzhe
 * @date 2019-10-09 15:20
 */
public class Test {
    public static void main(String[] args) {
        String missionDtoString = "[\n"
            + "    {\n"
            + "        \"missionTemplateId\":19,\n"
            + "        \"status\":1,\n"
            + "        \"iconUrl\":\"https://gw.alicdn.com/tfs/TB1wBVEcET1gK0jSZFrXXcNCXXa-204-204.png\",\n"
            + "        \"actionText\":\"View Reward\",\n"
            + "        \"timeline\":\"\",\n"
            + "        \"entityType\":\"Mission\",\n"
            + "        \"type\":\"old_user_pay_orders\",\n"
            + "        \"id\":\"1\",\n"
            + "        \"bgColor\":\"#317EF3\",\n"
            + "        \"title\":\"Make a Purchase\",\n"
            + "        \"description\":\"Get Reward Now!\",\n"
            + "        \"subtitle\":\"12 Coins\",\n"
            + "        \"missionInstanceId\":3683081,\n"
            + "        \"actionUrl\":\"https://pages.lazada.com.ph/wow/i/ph/marketing/hotdeals?hybrid=1\"\n"
            + "    },\n"
            + "    {\n"
            + "        \"missionTemplateId\":17,\n"
            + "        \"status\":1,\n"
            + "        \"iconUrl\":\"https://gw.alicdn.com/tfs/TB1UwoAg4z1gK0jSZSgXXavwpXa-204-204.png\",\n"
            + "        \"actionText\":\"View Reward\",\n"
            + "        \"timeline\":\"\",\n"
            + "        \"entityType\":\"Mission\",\n"
            + "        \"type\":\"user_share\",\n"
            + "        \"id\":\"2\",\n"
            + "        \"bgColor\":\"#D93ADD\",\n"
            + "        \"title\":\"Share Items\",\n"
            + "        \"description\":\"Get Reward Now!\",\n"
            + "        \"subtitle\":\"6 Coins\",\n"
            + "        \"missionInstanceId\":0,\n"
            + "        \"actionUrl\":\"https://pages.lazada.com.ph/wow/i/ph/marketing/yourdailydeals?hybrid=1\"\n"
            + "    },\n"
            + "    {\n"
            + "        \"missionTemplateId\":15,\n"
            + "        \"status\":1,\n"
            + "        \"iconUrl\":\"https://gw.alicdn.com/tfs/TB1_hkEg7T2gK0jSZFkXXcIQFXa-204-204.png\",\n"
            + "        \"actionText\":\"View Reward\",\n"
            + "        \"timeline\":\"\",\n"
            + "        \"entityType\":\"Mission\",\n"
            + "        \"type\":\"lazgame_play_finished\",\n"
            + "        \"id\":\"3\",\n"
            + "        \"bgColor\":\"#AB42E8\",\n"
            + "        \"title\":\"Play Popping Star\",\n"
            + "        \"description\":\"Get Reward Now!\",\n"
            + "        \"subtitle\":\"3 Coins\",\n"
            + "        \"missionInstanceId\":0,\n"
            + "        \"actionUrl\":\"https://pages.lazada.com"
            + ".ph/wow/i/ph/gamecenter/small-games?hybrid=1&wh_query=popping-star&lzd_navbar_hidden=true"
            + "&wx_navbar_hidden=true&wx_navbar_transparent=true&gameId=5\"\n"
            + "    }\n"
            + "]";

        List<MissionDto> missionDtoList = JSON.parseArray(missionDtoString, MissionDto.class);
        missionDtoList.forEach(missionDto -> {
            System.out.println(missionDto.getUserType());
        });
    }

    @Data
    private static class MissionDto {
        private String actionUrl;
        private String unloginActionUrl;
        private String bgColor;
        private String iconUrl;
        private int status;
        private String title;
        private String subtitle;
        private String type;
        private String actionText;
        private int missionInstanceId;
        private int missionTemplateId;
        private String timeline;
        private String userType;
        private Map<String, Object> trackingParam;
        private String benefitIcon;

    }
}
