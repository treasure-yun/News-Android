package com.example.news.bean;

import java.util.List;

public class Junshi {
    private List<BAI67OGGwangningBean> BAI67OGGwangning;

    public List<BAI67OGGwangningBean> getBAI67OGGwangning() {
        return BAI67OGGwangning;
    }

    public void setBAI67OGGwangning(List<BAI67OGGwangningBean> BAI67OGGwangning) {
        this.BAI67OGGwangning = BAI67OGGwangning;
    }

    public static class BAI67OGGwangningBean {
        /**
         * liveInfo : null
         * docid : 0001set2301929
         * source : 网易综合
         * title : 美国迈阿密航展F-35与海鸥齐飞
         * priority : 99
         * url :
         * skipURL : http://3g.163.com/touch/photoview.html?channelid=0001&setid=2301929
         * commentCount : 1013
         * imgsrc3gtype : 3
         * stitle : 4T8E0001|2301929
         * digest :
         * skipType : photoset
         * photosetID : 0001|2301929
         * imgsrc : http://cms-bucket.ws.126.net/2019/05/27/3a84fa4609694c9b8cae02f86de612c5.jpeg
         * ptime : 2019-05-27 09:33:46
         * modelmode : u
         * imgextra : [{"imgsrc":"http://pic-bucket.ws.126.net/photo/0001/2019-05-27/EG6AHDUJ4T8E0001NOS.png"},{"imgsrc":"http://pic-bucket.ws.126.net/photo/0001/2019-05-27/EG6AHDUK4T8E0001NOS.jpg"}]
         * hasImg : 1
         * imgsrcFrom : doc
         */

        private Object liveInfo;
        private String docid;
        private String source;
        private String title;
        private int priority;
        private String url;
        private String skipURL;
        private int commentCount;
        private String imgsrc3gtype;
        private String stitle;
        private String digest;
        private String skipType;
        private String photosetID;
        private String imgsrc;
        private String ptime;
        private String modelmode;
        private int hasImg;
        private String imgsrcFrom;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSkipURL() {
            return skipURL;
        }

        public void setSkipURL(String skipURL) {
            this.skipURL = skipURL;
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

        public String getModelmode() {
            return modelmode;
        }

        public void setModelmode(String modelmode) {
            this.modelmode = modelmode;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getImgsrcFrom() {
            return imgsrcFrom;
        }

        public void setImgsrcFrom(String imgsrcFrom) {
            this.imgsrcFrom = imgsrcFrom;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public static class ImgextraBean {
            /**
             * imgsrc : http://pic-bucket.ws.126.net/photo/0001/2019-05-27/EG6AHDUJ4T8E0001NOS.png
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
