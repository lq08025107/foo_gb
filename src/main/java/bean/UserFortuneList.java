package bean;

import java.util.List;

public class UserFortuneList {
    /**
     * message : null
     * data : [{"mineId":367611752,"symbol":"BCDN","canSteal":false,"validDate":1531125720000,"amount":0.0065},{"mineId":370862528,"symbol":"LVCOIN","canSteal":false,"validDate":1531139760000,"amount":0.01431},{"mineId":371348297,"symbol":"PPS","canSteal":false,"validDate":1531137060000,"amount":0.00446},{"mineId":373595123,"symbol":"GXS","canSteal":true,"validDate":1531129860000,"amount":7.2E-4},{"mineId":373980126,"symbol":"BDB","canSteal":true,"validDate":1531144920000,"amount":0.02427},{"mineId":374349997,"symbol":"LVCOIN","canSteal":false,"validDate":1531120740000,"amount":0.01431},{"mineId":374720617,"symbol":"PPS","canSteal":true,"validDate":1531118520000,"amount":0.02433}]
     */

    private Object message;
    private List<DataBean> data;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * mineId : 367611752
         * symbol : BCDN
         * canSteal : false
         * validDate : 1531125720000
         * amount : 0.0065
         */

        private int mineId;
        private String symbol;
        private boolean canSteal;
        private long validDate;
        private double amount;

        public int getMineId() {
            return mineId;
        }

        public void setMineId(int mineId) {
            this.mineId = mineId;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public boolean isCanSteal() {
            return canSteal;
        }

        public void setCanSteal(boolean canSteal) {
            this.canSteal = canSteal;
        }

        public long getValidDate() {
            return validDate;
        }

        public void setValidDate(long validDate) {
            this.validDate = validDate;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
