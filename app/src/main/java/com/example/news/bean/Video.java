package com.example.news.bean;

import java.util.List;

public class Video {
    private List<VideoRecomBean> Video_Recom;

    public List<VideoRecomBean> getVideo_Recom() {
        return Video_Recom;
    }
    public void setVideo_Recom(List<VideoRecomBean> Video_Recom) {
        this.Video_Recom = Video_Recom;
    }
    public static class VideoRecomBean {
        /**
         * sizeHD : 7018
         * mp4Hd_url : https://flv2.bn.netease.com/videolib1/1905/27/7coggx0i1/HD/7coggx0i1-mobile.mp4
         * description : 小男孩带狗狗溜达，结果半路遇见仇家大白鹅，下一秒憋住不要笑!
         * title : 小男孩带狗狗溜达，结果半路遇见仇家大白鹅，下一秒憋住不要笑!
         * mp4_url : https://flv2.bn.netease.com/videolib1/1905/27/7coggx0i1/SD/7coggx0i1-mobile.mp4
         * cover : http://videoimg.ws.126.net/cover/20190527/kn4QN7w6i_cover.jpg
         * vid : VSF9QPM0M
         * sizeSHD : 0
         * playersize : 1
         * ptime : 2019-05-27 23:55:59
         * m3u8_url : http://flv0.bn.netease.com/videolib1/1905/27/7coggx0i1/SD/movie_index.m3u8
         * topicImg : null
         * votecount : 15972
         * length : 93
         * videosource : 新媒体
         * m3u8Hd_url : http://flv0.bn.netease.com/videolib1/1905/27/7coggx0i1/HD/movie_index.m3u8
         * sizeSD : 5746
         * topicSid : VDRDDD11R
         * playCount : 236265
         * replyCount : 3436
         * replyBoard : video_bbs
         * replyid : SF9QPM0M050835RB
         * topicName : 音乐快讯
         * sectiontitle : null
         * topicDesc : 你想知道的互联网资讯，想了解的科技圈新闻，都在这里。
         */

        private int sizeHD;
        private String mp4Hd_url;
        private String description;
        private String title;
        private String mp4_url;
        private String cover;
        private String vid;
        private int sizeSHD;
        private int playersize;
        private String ptime;
        private String m3u8_url;
        private Object topicImg;
        private int votecount;
        private int length;
        private String videosource;
        private String m3u8Hd_url;
        private int sizeSD;
        private String topicSid;
        private int playCount;
        private int replyCount;
        private String replyBoard;
        private String replyid;
        private String topicName;
        private Object sectiontitle;
        private String topicDesc;

        public int getSizeHD() {
            return sizeHD;
        }

        public void setSizeHD(int sizeHD) {
            this.sizeHD = sizeHD;
        }

        public String getMp4Hd_url() {
            return mp4Hd_url;
        }

        public void setMp4Hd_url(String mp4Hd_url) {
            this.mp4Hd_url = mp4Hd_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMp4_url() {
            return mp4_url;
        }

        public void setMp4_url(String mp4_url) {
            this.mp4_url = mp4_url;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public int getSizeSHD() {
            return sizeSHD;
        }

        public void setSizeSHD(int sizeSHD) {
            this.sizeSHD = sizeSHD;
        }

        public int getPlayersize() {
            return playersize;
        }

        public void setPlayersize(int playersize) {
            this.playersize = playersize;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getM3u8_url() {
            return m3u8_url;
        }

        public void setM3u8_url(String m3u8_url) {
            this.m3u8_url = m3u8_url;
        }

        public Object getTopicImg() {
            return topicImg;
        }

        public void setTopicImg(Object topicImg) {
            this.topicImg = topicImg;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getVideosource() {
            return videosource;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public String getM3u8Hd_url() {
            return m3u8Hd_url;
        }

        public void setM3u8Hd_url(String m3u8Hd_url) {
            this.m3u8Hd_url = m3u8Hd_url;
        }

        public int getSizeSD() {
            return sizeSD;
        }

        public void setSizeSD(int sizeSD) {
            this.sizeSD = sizeSD;
        }

        public String getTopicSid() {
            return topicSid;
        }

        public void setTopicSid(String topicSid) {
            this.topicSid = topicSid;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getReplyBoard() {
            return replyBoard;
        }

        public void setReplyBoard(String replyBoard) {
            this.replyBoard = replyBoard;
        }

        public String getReplyid() {
            return replyid;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public Object getSectiontitle() {
            return sectiontitle;
        }

        public void setSectiontitle(Object sectiontitle) {
            this.sectiontitle = sectiontitle;
        }

        public String getTopicDesc() {
            return topicDesc;
        }

        public void setTopicDesc(String topicDesc) {
            this.topicDesc = topicDesc;
        }
    }
}
