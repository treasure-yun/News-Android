package com.example.news.bean;

import java.util.List;

public class Fashion {
    private List<BA8F6ICNwangningBean> BA8F6ICNwangning;

    public List<BA8F6ICNwangningBean> getBA8F6ICNwangning() {
        return BA8F6ICNwangning;
    }

    public void setBA8F6ICNwangning(List<BA8F6ICNwangningBean> BA8F6ICNwangning) {
        this.BA8F6ICNwangning = BA8F6ICNwangning;
    }

    public static class BA8F6ICNwangningBean {
        /**
         * liveInfo : null
         * docid : EG6G7M8V00267VQQ
         * source : 网易时尚
         * title : 从时尚黑洞到提名视后 赵丽颖的野心有多大？
         * priority : 190
         * hasImg : 1
         * url : http://3g.163.com/lady/19/0527/13/EG6G7M8V00267VQQ.html
         * commentCount : 3
         * imgsrc3gtype : 3
         * stitle :
         * digest : 近日，第25届上海电视节白玉兰奖公布入围名单，陈坤、何冰、倪
         * imgsrc : http://cms-bucket.ws.126.net/2019/05/27/bac0d40345304092a0fb90c16c393876.png
         * ptime : 2019-05-27 13:22:42
         * skipURL : http://3g.163.com/touch/photoview.html?channelid=0026&setid=115763
         * skipType : photoset
         * photosetID : 0026|115763
         * modelmode : u
         * imgextra : [{"imgsrc":"http://cms-bucket.ws.126.net/2019/05/26/d3e158535d754a95a55d3e2879719304.jpeg"},{"imgsrc":"http://cms-bucket.ws.126.net/2019/05/26/8d41841de49c4cb9b1fbf4d04b4a65a7.jpeg"}]
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
        private String photosetID;
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

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
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
             * imgsrc : http://cms-bucket.ws.126.net/2019/05/26/d3e158535d754a95a55d3e2879719304.jpeg
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
