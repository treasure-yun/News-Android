package com.example.news.bean;

import java.util.List;

public class Education {
    private List<BA8FF5PRwangningBean> BA8FF5PRwangning;
    public List<BA8FF5PRwangningBean> getBA8FF5PRwangning() {
        return BA8FF5PRwangning;
    }

    public void setBA8FF5PRwangning(List<BA8FF5PRwangningBean> BA8FF5PRwangning) {
        this.BA8FF5PRwangning = BA8FF5PRwangning;
    }

    public static class BA8FF5PRwangningBean {
        /**
         * liveInfo : null
         * docid : EG89ER0600297VGM
         * source : 新京报
         * title : 评论：耶鲁不拒国际生 坚守大学包容理念
         * priority : 98
         * hasImg : 1
         * url : http://3g.163.com/edu/19/0528/06/EG89ER0600297VGM.html
         * commentCount : 0
         * imgsrc3gtype : 3
         * stitle :
         * digest : 包括耶鲁大学在内的欧美绝大多数高等院校，并不附和美国“关门”
         * imgsrc : http://cms-bucket.ws.126.net/2019/05/28/7d296712645f437895c7eacb65703e5a.jpeg
         * ptime : 2019-05-28 06:02:45
         * imgsrcFrom : doc
         * imgextra : [{"imgsrc":"http://cms-bucket.ws.126.net/2019/05/27/97a9c71438154ad2a16951edc549735e.png"},{"imgsrc":"http://cms-bucket.ws.126.net/2019/05/27/b7a98eb0d30d440a9d17fc3e5285c884.png"}]
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
             * imgsrc : http://cms-bucket.ws.126.net/2019/05/27/97a9c71438154ad2a16951edc549735e.png
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
