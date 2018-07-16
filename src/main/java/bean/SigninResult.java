package bean;

public class SigninResult {
    /**
     * message : null
     * data : {"reward":{"power":1,"assets":null}}
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
         * reward : {"power":1,"assets":null}
         */

        private RewardBean reward;

        public RewardBean getReward() {
            return reward;
        }

        public void setReward(RewardBean reward) {
            this.reward = reward;
        }

        public static class RewardBean {
            /**
             * power : 1
             * assets : null
             */

            private int power;
            private Object assets;

            public int getPower() {
                return power;
            }

            public void setPower(int power) {
                this.power = power;
            }

            public Object getAssets() {
                return assets;
            }

            public void setAssets(Object assets) {
                this.assets = assets;
            }
        }
    }
}
