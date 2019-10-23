package com.example.news.bean;

import java.util.List;

public class Game {
    private List<BAI6RHDKwangningBean> BAI6RHDKwangning;

    public List<BAI6RHDKwangningBean> getBAI6RHDKwangning() {
        return BAI6RHDKwangning;
    }

    public void setBAI6RHDKwangning(List<BAI6RHDKwangningBean> BAI6RHDKwangning) {
        this.BAI6RHDKwangning = BAI6RHDKwangning;
    }

    public static class BAI6RHDKwangningBean {
        /**
         * liveInfo : null
         * docid : EG676BCJ003198EF
         * source : 网易游戏频道
         * title : Steam周榜：三国中的关二爷会为保命而叛逃？
         * priority : 255
         * hasImg : 1
         * url : http://3g.163.com/play/19/0527/10/EG676BCJ003198EF.html
         * commentCount : 928
         * imgsrc3gtype : 3
         * stitle :
         * digest : 新的一周又开始了，让我们看看关于5月20日到5月26日的St
         * imgsrc : http://cms-bucket.ws.126.net/2019/05/27/e24f6f50af7b4b9d981259c6058075c6.jpeg
         * ptime : 2019-05-27 10:44:41
         * imgextra : [{"imgsrc":"http://cms-bucket.ws.126.net/2019/05/27/6a8eeeba49454289bec5908b916ab748.png"},{"imgsrc":"http://cms-bucket.ws.126.net/2019/05/27/e9df239417384fb780e3b533764c1136.png"}]
         * skipURL : http://3g.163.com/ntes/special/0034073A/touch_videoplay.html?channel=all&offset=19&vid=VDF9UJUSO
         * skipType : video
         * modelmode : u
         */

        private Object liveInfo;
        private String docid;
        private String source;
        private String title;
        private int priority;
        private int hasImg;
        private String url;
        private int commentCount;
        private String imgsrc3gtype;
        private String stitle;
        private String digest;
        private String imgsrc;
        private String ptime;
        private String skipURL;
        private String skipType;
        private String modelmode;
        private List<ImgextraBean> imgextra;

        public Object getLiveInfo() {
            return liveInfo;
        }

        public void setLiveInfo(Object liveInfo) {
            this.liveInfo = liveInfo;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getImgsrc3gtype() {
            return imgsrc3gtype;
        }

        public void setImgsrc3gtype(String imgsrc3gtype) {
            this.imgsrc3gtype = imgsrc3gtype;
        }

        public String getStitle() {
            return stitle;
        }

        public void setStitle(String stitle) {
            this.stitle = stitle;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getSkipURL() {
            return skipURL;
        }

        public void setSkipURL(String skipURL) {
            this.skipURL = skipURL;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getModelmode() {
            return modelmode;
        }

        public void setModelmode(String modelmode) {
            this.modelmode = modelmode;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public static class ImgextraBean {
            /**
             * imgsrc : http://cms-bucket.ws.126.net/2019/05/27/6a8eeeba49454289bec5908b916ab748.png
             */

            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }
    }
}
