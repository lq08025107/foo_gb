package bean;

import java.util.List;

public class StealUserList {
    /**
     * message : null
     * data : {"leftAmount":304,"list":[{"userId":"Pzdjt8CZtHtaecH3JxD007260","nickName":"田胖子","head":null,"distance":"390m","type":2,"power":267,"canSteal":true,"countDown":null,"stealCount":null},{"userId":"Qb73QkoQKgMXWi94huY0957441103","nickName":"新忠","head":null,"distance":"420m","type":2,"power":471,"canSteal":false,"countDown":null,"stealCount":null},{"userId":"ZCbHV5nkKcjkfKNVD3b002873","nickName":"方vvb","head":null,"distance":"434m","type":2,"power":457,"canSteal":true,"countDown":null,"stealCount":null},{"userId":"fLxDZgLmC4VrtoAzCeX003821","nickName":"五行令主","head":null,"distance":"443m","type":2,"power":464,"canSteal":false,"countDown":null,"stealCount":null},{"userId":"MdiOlmeRxs32DM6WlAJ002683","nickName":"缑先生","head":null,"distance":"451m","type":2,"power":232,"canSteal":false,"countDown":null,"stealCount":null},{"userId":"zJD7Vnco62lX5hcnTHk002761","nickName":"猪猪柚","head":"https://static.gxb.io/gxs/blockcity/heads/992226/2018070208:27:36.jpeg","distance":"458m","type":2,"power":193,"canSteal":false,"countDown":null,"stealCount":null},{"userId":"1MAmU3WoDGurPDmTjKK001223","nickName":"JYWan","head":null,"distance":"461m","type":2,"power":136,"canSteal":false,"countDown":null,"stealCount":null},{"userId":"zZHHYwMhaoOiSXUDvL9002219","nickName":"张布洛克城","head":null,"distance":"463m","type":2,"power":344,"canSteal":false,"countDown":null,"stealCount":null}]}
     */

    private Object message;
    private DataBean data;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * leftAmount : 304
         * list : [{"userId":"Pzdjt8CZtHtaecH3JxD007260","nickName":"田胖子","head":null,"distance":"390m","type":2,"power":267,"canSteal":true,"countDown":null,"stealCount":null},{"userId":"Qb73QkoQKgMXWi94huY0957441103","nickName":"新忠","head":null,"distance":"420m","type":2,"power":471,"canSteal":false,"countDown":null,"stealCount":null},{"userId":"ZCbHV5nkKcjkfKNVD3b002873","nickName":"方vvb","head":null,"distance":"434m","type":2,"power":457,"canSteal":true,"countDown":null,"stealCount":null},{"userId":"fLxDZgLmC4VrtoAzCeX003821","nickName":"五行令主","head":null,"distance":"443m","type":2,"power":464,"canSteal":false,"countDown":null,"stealCount":null},{"userId":"MdiOlmeRxs32DM6WlAJ002683","nickName":"缑先生","head":null,"distance":"451m","type":2,"power":232,"canSteal":false,"countDown":null,"stealCount":null},{"userId":"zJD7Vnco62lX5hcnTHk002761","nickName":"猪猪柚","head":"https://static.gxb.io/gxs/blockcity/heads/992226/2018070208:27:36.jpeg","distance":"458m","type":2,"power":193,"canSteal":false,"countDown":null,"stealCount":null},{"userId":"1MAmU3WoDGurPDmTjKK001223","nickName":"JYWan","head":null,"distance":"461m","type":2,"power":136,"canSteal":false,"countDown":null,"stealCount":null},{"userId":"zZHHYwMhaoOiSXUDvL9002219","nickName":"张布洛克城","head":null,"distance":"463m","type":2,"power":344,"canSteal":false,"countDown":null,"stealCount":null}]
         */

        private int leftAmount;
        private List<ListBean> list;

        public int getLeftAmount() {
            return leftAmount;
        }

        public void setLeftAmount(int leftAmount) {
            this.leftAmount = leftAmount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * userId : Pzdjt8CZtHtaecH3JxD007260
             * nickName : 田胖子
             * head : null
             * distance : 390m
             * type : 2
             * power : 267
             * canSteal : true
             * countDown : null
             * stealCount : null
             */

            private String userId;
            private String nickName;
            private Object head;
            private String distance;
            private int type;
            private int power;
            private boolean canSteal;
            private Object countDown;
            private Object stealCount;

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public Object getHead() {
                return head;
            }

            public void setHead(Object head) {
                this.head = head;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getPower() {
                return power;
            }

            public void setPower(int power) {
                this.power = power;
            }

            public boolean isCanSteal() {
                return canSteal;
            }

            public void setCanSteal(boolean canSteal) {
                this.canSteal = canSteal;
            }

            public Object getCountDown() {
                return countDown;
            }

            public void setCountDown(Object countDown) {
                this.countDown = countDown;
            }

            public Object getStealCount() {
                return stealCount;
            }

            public void setStealCount(Object stealCount) {
                this.stealCount = stealCount;
            }
        }
    }
}
