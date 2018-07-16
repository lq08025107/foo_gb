package bean;

public class StealResult {
    /**
     * message : null
     * data : {"remainAmount":0.02912,"stealAmount":0.00324,"stealPercent":10}
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
         * remainAmount : 0.02912
         * stealAmount : 0.00324
         * stealPercent : 10
         */

        private double remainAmount;
        private double stealAmount;
        private int stealPercent;

        public double getRemainAmount() {
            return remainAmount;
        }

        public void setRemainAmount(double remainAmount) {
            this.remainAmount = remainAmount;
        }

        public double getStealAmount() {
            return stealAmount;
        }

        public void setStealAmount(double stealAmount) {
            this.stealAmount = stealAmount;
        }

        public int getStealPercent() {
            return stealPercent;
        }

        public void setStealPercent(int stealPercent) {
            this.stealPercent = stealPercent;
        }
    }
}
