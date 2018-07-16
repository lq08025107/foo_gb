package bean;

public class MineResult {
    /**
     * message : null
     * data : {"drawAmount":0.11924}
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
         * drawAmount : 0.11924
         */

        private double drawAmount;

        public double getDrawAmount() {
            return drawAmount;
        }

        public void setDrawAmount(double drawAmount) {
            this.drawAmount = drawAmount;
        }
    }
}
